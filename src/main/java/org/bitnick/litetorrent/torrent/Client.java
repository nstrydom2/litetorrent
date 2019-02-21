package org.bitnick.litetorrent.torrent;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.turn.ttorrent.client.SharedTorrent;

public class Client extends com.turn.ttorrent.client.Client {

	public Client(InetAddress address, SharedTorrent torrent) throws UnknownHostException, IOException {
		super(address, torrent);
		// TODO Auto-generated constructor stub
	}
	
	public void setProxy(String proxyServer, String proxyServerPort) throws Exception {
		System.setProperty("http.proxyHost", proxyServer);
		System.setProperty("http.proxyPort", proxyServerPort);
	}

}
