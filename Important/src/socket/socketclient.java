
package socket;




import java.io.*;
import java.net.*;

public class socketclient {

    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message="",option="";

    socketclient() {
    }

    void run() {
        try {
            //1. creating a socket to connect to the server
            requestSocket = new Socket("localhost", 2004);
            System.out.println("Connected to localhost in port 2004");
            //2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();

            in = new ObjectInputStream(requestSocket.getInputStream());
            //3: Communicating with the server
            do {
                try {
                    if(option.equals("1")||option.equals("3")||option.equals("")){
                    message = (String) in.readObject();
                    System.out.println("server>" + message);
                    }
                    //sendMessage("Hi my server");
                    InputStreamReader input = new InputStreamReader(System.in);
                    BufferedReader reader = new BufferedReader(input);
                    System.out.println("Enter your choice \n 1.Add \n 2.View\n 3.Quit:");
                    option = reader.readLine();
                    sendMessage(option);
                      if(option.equals("1")||option.equals("2")){
                    System.out.println("Enter your TrainNo ");
                    String content = reader.readLine();
                    sendMessage(content);
                   
                    if (!option.equals("2")) {
                        
                        message = (String) in.readObject();
                        if (message.equals("date")) {
                            System.out.println("Enter your  Date ");
                            String date = reader.readLine();
                            sendMessage(date);
                        }
                        message = (String) in.readObject();
                        if (message.equals("classcode")) {
                            System.out.println("Enter your Classcode");
                            String classcode = reader.readLine();
                            sendMessage(classcode);
                        }
                        message = (String) in.readObject();
                        if (message.equals("message")) {
                            System.out.println("Enter your Message");
                            String msg = reader.readLine();
                            sendMessage(msg);
                        }
                    } 
                    else if (option.equals("2")) {
                        message = (String) in.readObject();
                        System.out.println(message);
                    }
                    }
                } catch (ClassNotFoundException classNot) {
                    System.err.println("data received in unknown format");
                }
            } while (!option.equals("3"));
        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //4: Closing connection
            try {
                in.close();
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
        //System.out.println("client>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String args[]) {
        socketclient client = new socketclient();
        client.run();
    }
}
