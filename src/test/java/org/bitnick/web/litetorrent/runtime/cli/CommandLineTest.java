package org.bitnick.web.litetorrent.runtime.cli;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

public class CommandLineTest {
	private final CommandLine commandLineTest = new CommandLine();
	
	@Test
	public void downloadFileWithTorrentFileTest() {
		String torrentFile = "C:/Users/Nick/Downloads/DamnSmallLinux_4.4.10.torrent";
		String outputDirectory = "C:/Users/Nick/Downloads/";
		
		assertTrue(commandLineTest.downloadFile(
				// This is the torrent file
				new File(torrentFile),
				
				// This is the output directory, or in other words
				// the download destination directory
				new File(outputDirectory)
				));
	}
	
	@Ignore
	@Test
	public void test() {

	}
}
