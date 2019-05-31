package chap15;
import java.io.*;
import java.net.*;
import java.util.*;


public class VerySimpleChatServer
{
    ArrayList clientOutputStreams;
    static int numOfClient = 1;
    
    public static void main(String[] args) {
        System.out.println("Chatting server started on port 5000");
        new VerySimpleChatServer().go();
    }
    
    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket sock;
        String clientName;

        public ClientHandler(Socket clientSOcket) {
            try {
                clientName = "Client_" + Integer.toString(numOfClient ++);
                sock = clientSOcket;
                System.out.println("[Socket] connected with "+clientName+" on "+sock);
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
                tellEveryone(clientName+": joined this chat room");
            } catch (Exception ex) { ex.printStackTrace(); }
        }
        
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println(clientName+": " + message);
                    tellEveryone(clientName+": "+message);
                }
                closeSocket();
            } catch (Exception ex) { 
                //ex.printStackTrace(); 
                closeSocket();
            }
        }

        void closeSocket() {
            try {
                reader.close();
                sock.close();
                System.out.println("[Socket] closed connection with "+ clientName);
                tellEveryone(clientName+": left !!!");
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    
    public void go() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSock = new ServerSocket(5000);
            while(true) {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                //System.out.println("got a connection");
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    
    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
}
