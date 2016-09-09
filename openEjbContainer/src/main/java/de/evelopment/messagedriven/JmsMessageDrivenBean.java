package de.evelopment.messagedriven;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
    name = "JmsMessageDriven",
    mappedName = "testJms",
    messageListenerInterface = MessageListener.class,
    activationConfig = {
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Queue"
        )
    })
public class JmsMessageDrivenBean implements MessageListener {

	public JmsMessageDrivenBean() {
	}

	@Override
	public void onMessage(Message message) {
	}

}