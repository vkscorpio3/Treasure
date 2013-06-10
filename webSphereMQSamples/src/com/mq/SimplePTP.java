package com.mq;

import javax.jms.JMSException;
import javax.jms.Session;

import com.ibm.jms.JMSMessage;
import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.MQC;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

/**
 * SimplePTP: A minimal and simple testcase for Point-to-point messaging (1.02 style).
 *
 * Assumes that the queue is empty before being run.
 *
 * Does not make use of JNDI for ConnectionFactory and/or Destination definitions.
 *
 * @author saket
 */
public class SimplePTP {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    try {
      MQQueueConnectionFactory cf = new MQQueueConnectionFactory();

      // Config
      cf.setHostName("192.168.1.70");
      cf.setPort(1414);
      cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
      cf.setQueueManager("qm");
      cf.setChannel("SYSTEM.DEF.SVRCONN");

      MQQueueConnection connection = (MQQueueConnection) cf.createQueueConnection();
      System.out.println(11);
      
      
      MQQueueSession session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
      MQQueue queue = (MQQueue) session.createQueue("queue:///in");
      MQQueueSender sender =  (MQQueueSender) session.createSender(queue);
      MQQueueReceiver receiver = (MQQueueReceiver) session.createReceiver(queue);      

      long uniqueNumber = System.currentTimeMillis() % 1000;
      JMSTextMessage message = (JMSTextMessage) session.createTextMessage("SimplePTP "+ uniqueNumber);     

      // Start the connection
      connection.start();

      sender.send(message);
      System.out.println("Sent message:\\n" + message);

      JMSMessage receivedMessage = (JMSMessage) receiver.receive(100000000);
      System.out.println("\\nReceived message:\\n" + receivedMessage);

      sender.close();
      receiver.close();
      session.close();
      connection.close();

      System.out.println("\\nSUCCESS\\n");
    }
    catch (JMSException jmsex) {
      System.out.println(jmsex);
      System.out.println("\\nFAILURE\\n");
    }
    catch (Exception ex) {
      System.out.println(ex);
      System.out.println("\\nFAILURE\\n");
    }
  }
}
