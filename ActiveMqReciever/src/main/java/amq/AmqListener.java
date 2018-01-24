package amq;

import javax.jms.Destination;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
@Component
public class AmqListener {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	Destination replyDestination;
	@JmsListener(destination="Mine")
	//@SendTo("TestQueueTwo1")
	public String Message(final Message arg0,@Header(JmsHeaders.CORRELATION_ID) String correlationId) {
		System.out.println("Iam listening");	
		/*try {
				System.out.println("The queue mine has got a new Message and I have to reply to it at "+arg0.getJMSReplyTo());
				jmsTemplate.send(arg0.getJMSReplyTo(), new MessageCreator() {
					
					public Message createMessage(Session session) throws JMSException {
						System.out.println("Iam sending a reply with the same Correlation Id: "+arg0.getJMSCorrelationID());
						TextMessage message =session.createTextMessage("Here take a reply bro");
						message.setJMSCorrelationID(arg0.getJMSCorrelationID());
						return message;
					}
				});
			} catch (JMSException e) {
				e.printStackTrace();
			}*/
			
			return "Iam A reply sent using spring";
		}
	
	
	}