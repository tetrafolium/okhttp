/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * A {@link SSLSocketFactory} that delegates calls. Sockets can be configured after creation by
 * overriding {@link #configureSocket(javax.net.ssl.SSLSocket)}.
 */
public class DelegatingSSLSocketFactory extends SSLSocketFactory {

  private final SSLSocketFactory delegate;

  public DelegatingSSLSocketFactory(final SSLSocketFactory delegate) {
    this.delegate = delegate;
  }

  @Override public SSLSocket createSocket() throws IOException {
    SSLSocket sslSocket = (SSLSocket) delegate.createSocket();
    return configureSocket(sslSocket);
  }

  @Override public SSLSocket createSocket(final String host, final int port) throws IOException {
    SSLSocket sslSocket = (SSLSocket) delegate.createSocket(host, port);
    return configureSocket(sslSocket);
  }

  @Override public SSLSocket createSocket(
      final String host, final int port, final InetAddress localAddress, final int localPort) throws IOException {
    SSLSocket sslSocket = (SSLSocket) delegate.createSocket(host, port, localAddress, localPort);
    return configureSocket(sslSocket);
  }

  @Override public SSLSocket createSocket(final InetAddress host, final int port) throws IOException {
    SSLSocket sslSocket = (SSLSocket) delegate.createSocket(host, port);
    return configureSocket(sslSocket);
  }

  @Override public SSLSocket createSocket(
      final InetAddress host, final int port, final InetAddress localAddress, final int localPort) throws IOException {
    SSLSocket sslSocket = (SSLSocket) delegate.createSocket(host, port, localAddress, localPort);
    return configureSocket(sslSocket);
  }

  @Override public String[] getDefaultCipherSuites() {
    return delegate.getDefaultCipherSuites();
  }

  @Override public String[] getSupportedCipherSuites() {
    return delegate.getSupportedCipherSuites();
  }

  @Override public SSLSocket createSocket(
      final Socket socket, final String host, final int port, final boolean autoClose) throws IOException {
    SSLSocket sslSocket = (SSLSocket) delegate.createSocket(socket, host, port, autoClose);
    return configureSocket(sslSocket);
  }

  protected SSLSocket configureSocket(final SSLSocket sslSocket) throws IOException {
    // No-op by default.
    return sslSocket;
  }
}
