package com.loanapp.controller;

import java.io.File;
import java.io.FilenameFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class FileScannerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileScannerController.class);

//	@Scheduled(fixedDelay = 60 * 1000)
	public void scanForFiles() {
		LOGGER.info("Scanning");
		File workingDirectory = new File("C:/temp1");
		File[] xmlFiles = workingDirectory.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.endsWith("xml");
			}
		});

		if (xmlFiles != null && xmlFiles.length > 0) {
			long startTime = System.currentTimeMillis();
			LOGGER.info("Files are available for processing. # of files:" + xmlFiles.length);

			LOGGER.info("Checking if there are any files being processed by this node");
		}

	}
}
