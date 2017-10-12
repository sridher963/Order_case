package com.tek.order.care.services;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.tek.order.care.service.FileService;

public class FileServiceTest {

	@Test
	public void testReadFileAsListForInvalidArgument() throws Exception {
		List<String> lines = FileService.readFileAsList(null);
		assertNull(lines);
	}

	@Test(expected = NullPointerException.class)
	public void testReadFileAsListForMissingFile() throws Exception {
		List<String> lines = FileService.readFileAsList("/test.csv");
		assertNull(lines);
	}

}
