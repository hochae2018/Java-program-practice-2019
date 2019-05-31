package chap15;

import java.io.*;
import java.net.*;

public class DailyAdviceClient
{
    public void go() {
        try {
            // make a socket connection
            Socket s = new Socket("127.0.0.1", 4242);
            // make a stream reader with the socket
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream()); 
            // make a buffered reader with the stream reader
            BufferedReader reader = new BufferedReader(streamReader);
            // read a line from the buffered reader
            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);
            // close the reader
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
