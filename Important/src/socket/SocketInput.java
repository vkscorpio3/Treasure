/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package socket;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author root
 */
public class SocketInput extends HttpServlet {
   
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
 static clientThread t[] = new clientThread[10];

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int port_number=2225;
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
            sendMessage("Connection successful");
             do {
                try {
                    message = (String) in.readObject();
                    if (message.equals("1")) {
                        trainno = (String) in.readObject();
                        //System.out.println();
                        if (!SocketInput.id.contains(trainno)) {
                            //id.clear();
                            SocketInput.id.add(trainno);
                        // m.put(trainno, "");
                        }
                        sendMessage("date");
                        date = (String) in.readObject();
                        if (!(SocketInput.m.containsKey(trainno) && (SocketInput.m.get(trainno)).equals(date))) {

                            SocketInput.SL.remove(trainno);
                            SocketInput.map_3A.remove(trainno);
                            SocketInput.map_2A.remove(trainno);
                            SocketInput.map_1A.remove(trainno);
                            SocketInput.SS.remove(trainno);
                            SocketInput.CC.remove(trainno);
                            SocketInput.m.put(trainno, date);
                        }else{

                        }
                        sendMessage("classcode");
                        classcode = (String) in.readObject();
                        if (classcode.equals("SL")) {
                            if (!SocketInput.SL.containsKey(trainno)) {
                                SocketInput.SL.put(trainno, "");
                            }
                        }
                        if (classcode.equals("3A")) {
                            if (!SocketInput.map_3A.containsKey(trainno)) {
                                SocketInput.map_3A.put(trainno, "");
                            }
                        }
                        if (classcode.equals("2A")) {
                            if (!SocketInput.map_2A.containsKey(trainno)) {
                                SocketInput.map_2A.put(trainno, "");
                            }
                        }
                        if (classcode.equals("1A")) {
                            if (!SocketInput.map_1A.containsKey(trainno)) {
                                SocketInput.map_1A.put(trainno, "");
                            }
                        }
                        if (classcode.equals("CC")) {
                            if (!SocketInput.CC.containsKey(trainno)) {
                                SocketInput.CC.put(trainno, "");
                            }
                        }
                        if (classcode.equals("SS")) {
                            if (!SocketInput.SS.containsKey(trainno)) {
                                SocketInput.SS.put(trainno, "");
                            }
                        }
                        sendMessage("message");
                        msg = (String) in.readObject();
                        if (classcode.equals("SL")) {
                            SocketInput.SL.put(trainno, msg);
                        }
                        if (classcode.equals("3A")) {
                            SocketInput.map_3A.put(trainno, msg);
                        }
                        if (classcode.equals("2A")) {
                            SocketInput.map_2A.put(trainno, msg);
                        }
                        if (classcode.equals("1A")) {
                            SocketInput.map_1A.put(trainno, msg);
                        }
                        if (classcode.equals("CC")) {
                            SocketInput.CC.put(trainno, msg);
                        }
                        if (classcode.equals("SS")) {
                            SocketInput.SS.put(trainno, msg);
                        }
                        sendMessage(msg + " is added");

                    }
                      if (message.equals("2")) {

                        trainno = (String) in.readObject();
                        if (!SocketInput.id.contains(trainno)) {
                            sendMessage("This train no is not exist");
                        } else {
                            send = "Train No\tDate\tclasscode\tMessage\n";
                            if (SocketInput.SL.containsKey(trainno)) {
                                send = send +trainno + "\t" + SocketInput.m.get(trainno) + "\tSL\t\t" + SocketInput.SL.get(trainno) + "\n";
                            }
                            if (SocketInput.map_3A.containsKey(trainno)) {
                                send = send +  trainno + "\t" + SocketInput.m.get(trainno) + "\t3A\t\t" + SocketInput.map_3A.get(trainno) + "\n";
                            }
                            if (SocketInput.map_2A.containsKey(trainno)) {
                                send = send +  trainno + "\t" + SocketInput.m.get(trainno) + "\t2A\t\t" + SocketInput.map_2A.get(trainno) + "\n";
                            }
                            if (SocketInput.map_1A.containsKey(trainno)) {
                                send = send+  trainno + "\t" + SocketInput.m.get(trainno) + "\t1A\t\t" + SocketInput.map_1A.get(trainno) + "\n";
                            }
                            if (SocketInput.CC.containsKey(trainno)) {
                                send = send +  trainno + "\t" + SocketInput.m.get(trainno) + "\tCC\t\t" + SocketInput.CC.get(trainno) + "\n";
                            }
                            if (SocketInput.SS.containsKey(trainno)) {
                                send = send+  trainno + "\t" + SocketInput.m.get(trainno) + "\tSS\t\t" + SocketInput.SS.get(trainno) + "\n";
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


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
