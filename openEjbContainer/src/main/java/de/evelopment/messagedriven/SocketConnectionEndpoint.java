package de.evelopment.messagedriven;

public interface SocketConnectionEndpoint {

  public void onMessage(SocketConnection socketMessage) throws Exception;

}