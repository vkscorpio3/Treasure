
package socket;



import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class socketserver {

    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message, trainno, date, classcode, msg, send;
    ArrayList id = new ArrayList();
    Map m = new HashMap();
    Map SL = new HashMap();
    Map map_3A = new HashMap();
    Map map_2A = new HashMap();
    Map map_1A = new HashMap();
    Map CC = new HashMap();
    Map SS = new HashMap();

    socketserver() {
    }

    void run() {
        try {
           providerSocket = new ServerSocket(2004, 10);
             System.out.println("Waiting for connection");
            connection = providerSocket.accept();
            System.out.println("Connection received from InetAddress " + connection.getInetAddress().getHostName());
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successful");
             do {
                try {
                    message = (String) in.readObject();
                    if (message.equals("1")) {
                        trainno = (String) in.readObject();
                        if (!id.contains(trainno)) {
                            //id.clear();
                            id.add(trainno);
                        // m.put(trainno, "");
                        }
                        sendMessage("date");
                        date = (String) in.readObject();
                        if (!(m.containsKey(trainno) && (m.get(trainno)).equals(date))) {
                            
                            SL.remove(trainno);
                            map_3A.remove(trainno);
                            map_2A.remove(trainno);
                            map_1A.remove(trainno);
                            SS.remove(trainno);
                            CC.remove(trainno);
                            m.put(trainno, date);
                        }else{
                            
                        }
                        sendMessage("classcode");
                        classcode = (String) in.readObject();
                        if (classcode.equals("SL")) {
                            if (!SL.containsKey(trainno)) {
                                SL.put(trainno, "");
                            }
                        }
                        if (classcode.equals("3A")) {
                            if (!map_3A.containsKey(trainno)) {
                                map_3A.put(trainno, "");
                            }
                        }
                        if (classcode.equals("2A")) {
                            if (!map_2A.containsKey(trainno)) {
                                map_2A.put(trainno, "");
                            }
                        }
                        if (classcode.equals("1A")) {
                            if (!map_1A.containsKey(trainno)) {
                                map_1A.put(trainno, "");
                            }
                        }
                        if (classcode.equals("CC")) {
                            if (!CC.containsKey(trainno)) {
                                CC.put(trainno, "");
                            }
                        }
                        if (classcode.equals("SS")) {
                            if (!SS.containsKey(trainno)) {
                                SS.put(trainno, "");
                            }
                        }
                        sendMessage("message");
                        msg = (String) in.readObject();
                        if (classcode.equals("SL")) {
                            SL.put(trainno, msg);
                        }
                        if (classcode.equals("3A")) {
                            map_3A.put(trainno, msg);
                        }
                        if (classcode.equals("2A")) {
                            map_2A.put(trainno, msg);
                        }
                        if (classcode.equals("1A")) {
                            map_1A.put(trainno, msg);
                        }
                        if (classcode.equals("CC")) {
                            CC.put(trainno, msg);
                        }
                        if (classcode.equals("SS")) {
                            SS.put(trainno, msg);
                        }
                        sendMessage(msg + " is added");

                    }
                      if (message.equals("2")) {

                        trainno = (String) in.readObject();
                        if (!id.contains(trainno)) {
                            sendMessage("This train no is not exist");
                        } else {
                            send = "Train No\tDate\tclasscode\tMessage\n";
                            if (SL.containsKey(trainno)) {
                                send = send +trainno + "\t" + m.get(trainno) + "\tSL\t\t" + SL.get(trainno) + "\n";
                            }
                            if (map_3A.containsKey(trainno)) {
                                send = send +  trainno + "\t" + m.get(trainno) + "\t3A\t\t" + map_3A.get(trainno) + "\n";
                            }
                            if (map_2A.containsKey(trainno)) {
                                send = send +  trainno + "\t" + m.get(trainno) + "\t2A\t\t" + map_2A.get(trainno) + "\n";
                            }
                            if (map_1A.containsKey(trainno)) {
                                send = send+  trainno + "\t" + m.get(trainno) + "\t1A\t\t" + map_1A.get(trainno) + "\n";
                            }
                            if (CC.containsKey(trainno)) {
                                send = send +  trainno + "\t" + m.get(trainno) + "\tCC\t\t" + CC.get(trainno) + "\n";
                            }
                            if (SS.containsKey(trainno)) {
                                send = send+  trainno + "\t" + m.get(trainno) + "\tSS\t\t" + SS.get(trainno) + "\n";
                            }
                            sendMessage(send);
                        }

                    }
                //
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
                providerSocket.close();
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

    public static void main(String args[]) {
        socketserver server = new socketserver();
        while (true) {
                       server.run();
        }
    }
}

