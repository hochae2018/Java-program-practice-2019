package chap15;
import java.io.*;
import java.net.*;

public class DailyAdviceServer
{
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat",
        "One word: inappropriate", "Just for today, be honest.  Tell your boss what you *really* think", 
        "You might want to rethink that haircut"};
        
    public void go() {
        try {
            // make a server socket
            ServerSocket serverSock = new ServerSocket(4242);
            while (true) {
                // get a socket connection
                Socket sock = serverSock.accept();
                // make a socket writer
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                // get advice from a method
                String advice = getAdvice();
                // send the message 
                writer.println(advice);
                // close the connection
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
    
    public static void main(String[] args)
    {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

}
