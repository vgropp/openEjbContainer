package de.evelopment.messagedriven;

import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@MessageDriven(name = "SocketMessageDriven", mappedName = "SocketResourceAdapter", messageListenerInterface = SocketConnectionEndpoint.class)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class SocketMessageDrivenBean implements SocketConnectionEndpoint {

	public SocketMessageDrivenBean() {
	}

	@Override
	public void onMessage(SocketConnection socketMessage) throws Exception {

	}

}