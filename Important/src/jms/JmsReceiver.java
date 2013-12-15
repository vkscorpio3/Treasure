package jms;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsReceiver {

	public static void main(String[] args) {

		try {

			Hashtable env = new Hashtable();

			env.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");

			env.put(Context.PROVIDER_URL, "jnp://localhost:1099");

			env.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");

			// Create the initial context

			Context ctx = new InitialContext(env);

			ConnectionFactory connectionFactory = (ConnectionFactory) ctx
					.lookup("ConnectionFactory");

			Queue queue = (javax.jms.Queue) ctx.lookup("/queue/DLQ");

			Connection connection = connectionFactory.createConnection();

			Session session = connection.createSession(false,
					Session.CLIENT_ACKNOWLEDGE);

			MessageConsumer messageConsumer = session.createConsumer(queue);

			// Start the Connection created

			connection.start();

			// Receive a message from the queue.

			Message msg = messageConsumer.receive();

			// Retrieve the contents of the message.

			if (msg instanceof TextMessage) {

				TextMessage txtMsg = (TextMessage) msg;

				System.out.println("Read Message: " + txtMsg.getText());

			}

			// Close the session and connection resources.

			session.close();

			connection.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

}
