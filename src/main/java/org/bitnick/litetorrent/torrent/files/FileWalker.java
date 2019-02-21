package org.bitnick.litetorrent.torrent.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileWalker {
	
	public FileWalker() { }
	
	public List<File> loadTorrentFiles(File directory) {
		List<File> torrentFiles = new ArrayList<File>();
		
		for (File childFile : directory.listFiles()) {
			if (!childFile.isDirectory()) {
				if (childFile.getName().indexOf(".torrent") != -1) {
					torrentFiles.add(new File(childFile.getAbsolutePath()));
				}
			}
		}
		
		return torrentFiles;
	}	
}
