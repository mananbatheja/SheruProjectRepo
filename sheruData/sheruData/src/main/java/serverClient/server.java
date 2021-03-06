package serverClient;


import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 */
@RestController
@RequestMapping(value="/sheruData")
public class server {

    private ServerSocket serverSocket;
    private int port;
    public static Socket socket;
    public static int clients = 0;

    public void establish(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        System.out.println("JSONServer has been established on port " + port);
    }

    public void accept() throws IOException {
        while (true) {
        	socket = serverSocket.accept();
            System.out.println("Accepted now");
            Runnable r = new MyThreadHandler(socket);
            Thread t = new Thread(r);
            t.start();
        }
    }

    private static class MyThreadHandler implements Runnable {
        private static Socket socket;

        MyThreadHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        @GetMapping(value="/upload",
        		produces="application/json")
        public void run() {
            clients++;
            System.out.println(clients + " JSONClient(s) connected on port: " + socket.getPort());

            try {
                String jsonObject = receiveJSON();
                PrintWriter out = new PrintWriter("filename.txt");
                out.println(jsonObject);
                
                sendJSON();
            } catch (IOException e) {
            	System.out.println("Error here");
            }  finally {
                try {
                    closeSocket();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void closeSocket() throws IOException {
            socket.close();
        }

        public String receiveJSON() throws IOException {
            InputStream in = socket.getInputStream();
            ObjectInputStream i = new ObjectInputStream(in);
            String jsonObject = null;
            try {
                jsonObject = (String) i.readObject();
                
            } catch (ClassNotFoundException e) {
                 e.printStackTrace();
            
            }
            
            try {
				System.out.println("Got from client on port " + socket.getPort() + " " + jsonObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
            return jsonObject;
        }
        
        public static void sendJSON() throws IOException {
                OutputStream out = socket.getOutputStream();
                ObjectOutputStream o = new ObjectOutputStream(out);
               o.writeObject("Open");
                out.flush();
                System.out.println("Sent to server: Open");            	
       }
    }
    
    public static void sendJSON() throws IOException {
        
        OutputStream out = socket.getOutputStream();
         ObjectOutputStream o = new ObjectOutputStream(out);
        o.writeObject("Close");
         out.flush();
         System.out.println("Sent to server: Close");
   }
    
    public void start(int port) throws IOException{
        establish(port);
        accept();
    }

    public static void main(String[] args) {
        server server = new server();

        try {
            server.start(7777);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println(e);
        }
    }
}