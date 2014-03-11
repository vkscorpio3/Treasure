/* IBM Confidential
 *
 * OCO Source Materials
 *
 * 5724-E11
 * 5724-E26
 * (C) Copyright IBM Corp. 2002, 2005, 2009
 *
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been deposited
 * with the U.S. Copyright office
 */

package jmsnode;

//Import required classes.

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageEOFException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.BytesMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQTopicConnectionFactory;

//-----------------------------------------------------------------------------
//JMSSubscriber class
//-----------------------------------------------------------------------------
@SuppressWarnings("deprecation")
public class JMSSubscriber {

	public MQTopicConnectionFactory ippsFactory = new MQTopicConnectionFactory();
	TopicConnection ipConn = null;
	private String ourtopic = null;
	
	//-----------------------------------------------------------------------------
	// Method: JMSSubscriber.IPSubscriber
	//-----------------------------------------------------------------------------
	/**
	 * <p>This is the constructor.
	 * 
	 * @param topic
	 */
	//-----------------------------------------------------------------------------	
	public JMSSubscriber(String topic) {
		ourtopic = topic;
	}
	
	//-----------------------------------------------------------------------------
	// Method: JMSSubscriber.start
	//-----------------------------------------------------------------------------
	/**
	 * <p>This method starts the JMS connection to the Broker's WMQ Queue Manager 
	 */
	//-----------------------------------------------------------------------------	
    public void start(){
		try {
			ippsFactory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
            ippsFactory.setQueueManager("MB8QMGR");   // TODO Adjust if not using default configuration
			ippsFactory.setHostName("localhost");
			ippsFactory.setPort(2414);                // TODO Adjust if not using default configuration
			ippsFactory.setBrokerVersion (JMSC.MQJMS_BROKER_V2);
			ippsFactory.setSubscriptionStore (JMSC.MQJMS_SUBSTORE_BROKER);
			
			ipConn = ippsFactory.createTopicConnection();
			ipConn.start();
			
			subscribe();
			
		} catch (JMSException e1) {
			System.out.println("JMS Subscriber:\tError creating IP Topic Connection");
			e1.printStackTrace();
		}		
	}
	
	//-----------------------------------------------------------------------------
	// Method: JMSSubscriber.subscribe
	//-----------------------------------------------------------------------------
	/**
	 * <p>This method takes a topic string and registers it.
	 * <br>It then enters the receive loop and waits for messages.
	 * <br>When a message arrives it prints it to the console.
	 */
	//-----------------------------------------------------------------------------
	public void subscribe() {
        
		try {
			TopicSession topicsession = ipConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = topicsession.createTopic(ourtopic);
	        System.out.println("JMS Subscriber:\tSubscribing on topic: " + ourtopic);
	        TopicSubscriber topicsubscriber = topicsession.createSubscriber(topic);
	        Message message = null;
	        
	        try {
	        	message = (Message)topicsubscriber.receive();
	        } catch (MessageEOFException eof) {}
	
	        if (message instanceof BytesMessage)
	        {
	        	System.out.println("JMS Subscriber:\tReceived Bytes Message");
	        	BytesMessage bytesmessage = (BytesMessage)message;
	        	byte msgbytes[] = new byte[1000];
	        	int i = bytesmessage.readBytes(msgbytes);
	        	System.out.println("JMS Subscriber:\tMessage Text = " + new String(msgbytes, 0, i));
	        	System.out.println("JMS Subscriber:\tReceived from Message Destination = " + bytesmessage.getJMSDestination());
	        }
	        if(message instanceof TextMessage)
	        {
	            System.out.println("JMS Subscriber:\tReceived Text Message");
	            TextMessage textmessage = (TextMessage)message;
	            System.out.println("JMS Subscriber:\tMessage Text = " + textmessage.getText());
	            System.out.println("JMS Subscriber:\tReceived from Message Destination = " + textmessage.getJMSDestination());
	        } else
	        if(message == null)
	            System.out.println("JMS Subscriber:\tERROR: No Message received");
			
		} catch (JMSException e1) {
			System.out.println("JMS Subscriber:\tCannot subscribe");
			e1.printStackTrace();
		}
	}
	
	//-----------------------------------------------------------------------------
	// Method: JMSSubscriber.main
	//-----------------------------------------------------------------------------
	/**
	 * <p>This method starts an JMSSubscriber.
	 */
	//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		JMSSubscriber sub = new JMSSubscriber("update/invoices");
		sub.start();
	}
}
