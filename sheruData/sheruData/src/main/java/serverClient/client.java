package serverClient;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class client {

    private String host;
    private int port;
    public Socket socket;
    private static int f=1;
    private final String DEFAULT_HOST = "localhost";

    public void connect(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        socket = new Socket(host, port);
        System.out.println("Client has been connected..");
    }

    public String receiveJSON() throws IOException, ClassNotFoundException {
 
        InputStream in = socket.getInputStream();
        ObjectInputStream i = new ObjectInputStream(in);
        String line = null;
        line = (String) i.readObject();
        
        if(line!=null)return line;
        else return "";
    }


    public void sendJSON(String jsonObject) throws IOException, ParseException {
    	
         OutputStream out = socket.getOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(out);
         o.writeObject(jsonObject);
        out.flush();
        System.out.println("Sent to server");
    }
    
    public static void main(String[] args) throws  ParseException, IOException, ClassNotFoundException {
        client client = new client();
        try{
                client.connect("localhost", 7777);
                
                JSONObject jsonObject2;
                jsonObject2 = new JSONObject();
                JSONParser parser = new JSONParser();

                URL url = new URL("http://13.233.13.254:2222/xenergyData.json");
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

                client.sendJSON(in.readLine());
                in.close();
                String str=client.receiveJSON();
        }
        finally {
            	System.out.println("It hould have closed here");
                client.socket.close();
            
        }

    }
}