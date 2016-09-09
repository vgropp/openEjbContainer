package de.evelopment.messagedriven;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public interface SocketConnection {

  Socket getRawSocket();

  String getEncoding();

  InputStream getInputStream() throws IOException;

  OutputStream getOutputStream() throws IOException;

  Reader getReader();

  Writer getWriter();

}