package learn.jms.ex01.jms11;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSReceiver {
	
	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = cf.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("EM_TRADE.Q");
		
		MessageConsumer receiver = session.createConsumer(queue);
		TextMessage textMessage = (TextMessage)receiver.receive();
		System.out.println(textMessage.getText());
		System.out.println("Message received");
		connection.close();
	}
}
