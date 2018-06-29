package de.evelopment.messagedriven;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
    name = "JmsMessageDriven",
    mappedName = "JmsMessageDriven",
    messageListenerInterface = MessageListener.class,
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName="maxSession", propertyValue="1")
    })
public class JmsMessageDrivenBean implements MessageListener {

	public JmsMessageDrivenBean() {
	}

	@Override
	public void onMessage(Message message) {
	}

}