package com.tek.order.care.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author
 *
 */
public class FileService {

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static List<String> readFileAsList(String fileName) throws IOException, URISyntaxException {
		List<String> lines = null;
		if (fileName != null) {
			URI uri = FileService.class.getResource(fileName).toURI();
			lines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
		}
		return lines;
	}

}
