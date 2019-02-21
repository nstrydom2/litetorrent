package org.bitnick.web.litetorrent.runtime.cli;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;
import org.bitnick.litetorrent.torrent.Client;

import com.turn.ttorrent.client.SharedTorrent;

@SuppressWarnings("deprecation")
public class CommandLine {
	private Logger log = null;
	private Client client = null;
	
	public CommandLine() {
		// Set up root logger
		this.log = Logger.getLogger(CommandLine.class);
	}

	public boolean downloadFile(File torrent, File downloadDirectory) {
		try {
			// For debug, report what the current process is
			log.debug("Initiliazing Client.");
			
			// Initialize bittorrent client and
			// Provide torrent file
			this.client = new Client(
					// Provide the interface the client will listen on
					InetAddress.getLocalHost(),
					
					// Load the torrent from the torrent file, and provide 
					// output directory. Partials downloads are recovered
					SharedTorrent.fromFile(
							torrent,
							downloadDirectory)
					);
			
			// Client initialization and torrent load is a success
			// Report that download is starting
			log.debug("Torrent file successfully loaded.");
			log.debug("Download is starting...");
			
			// Start download and wait till completed
			client.download();
			client.waitForCompletion();

			// Nothing went wrong up to this point, return that
			// execution was a success
			return true;
		}
		
		catch (Exception ex) {
			log.error(String.format("Exception thrown: {0}", ex));
			
			// Return false, or in other words something went wrong
			return false;
		}
		
		finally {
			client.stop();
		}
	}
	
	public boolean downloadQueue(List<File> torrents, File downloadDirectory) {
		try {
			for (File torrent : torrents) {
				downloadFile(torrent, downloadDirectory);
			}
			
			return true;
		}
		
		catch (Exception ex) {
			log.error(String.format("Exception thrown: {0}", ex));
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}
