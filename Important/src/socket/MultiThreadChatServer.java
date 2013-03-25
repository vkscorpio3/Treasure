package socket;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultiThreadChatServer{
    static Map m = new HashMap();
    static Map SL = new HashMap();
    static Map map_3A = new HashMap();
    static Map map_2A = new HashMap();
    static Map map_1A = new HashMap();
    static Map CC = new HashMap();
    static Map SS = new HashMap();
   static  ArrayList id = new ArrayList();
static  Socket clientSocket = null;
    static  ServerSocket serverSocket = null;
 static  clientThread t[] = new clientThread[10];
 public static void main(String args[]) throws IOException {
int port_number=2234;
	    serverSocket = new ServerSocket(port_number);
       while(true){
	    try {
		clientSocket = serverSocket.accept();
		for(int i=0; i<=9; i++){
		    if(t[i]==null)
			{
			    (t[i] = new clientThread(clientSocket,t)).start();

			    break;
			}
		}
	    }
	    catch (IOException e) {
		System.out.println(e);}
	}
    }
}
class clientThread extends Thread{
ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message, trainno, date, classcode, msg, send;
   
    
//    DataInputStream is = null;
//    PrintStream os = null;
    Socket clientSocket = null;
    clientThread t[];
  Socket requestSocket;
//    ObjectOutputStream out;
//    ObjectInputStream in;
    String option="1";
    public clientThread(Socket clientSocket, clientThread[] t){
	this.clientSocket=clientSocket;
        this.t=t;
    }

    public synchronized void run()
    {
	  try {

       
           connection =  this.clientSocket;

            System.out.println("Connection received from InetAddress " + connection.getInetAddress().getHostName());
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successfull");
             do {
                try {
                    message = (String) in.readObject();

                    System.out.println("qqqqqqqqqqqqqqqqqqqqqq"+message);

                    sendMessage("Please Enter the Date");

                  
                } catch (ClassNotFoundException classnot) {
                    System.err.println("ClassNotFoundException");
                }
            } while (!message.equals("3"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //4: Closing connection
            try {
                System.out.println("close server");
                in.close();
                out.close();
                //providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
      void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
           // System.out.println("server>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
