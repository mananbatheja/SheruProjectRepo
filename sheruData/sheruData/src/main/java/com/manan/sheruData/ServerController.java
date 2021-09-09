package com.manan.sheruData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sherudata")
@CrossOrigin()
public class ServerController {

	@GetMapping(value = "/upload")
	public String getData() throws FileNotFoundException, IOException, ParseException {

		File file = new File("Write the file location where server is storing the received JSON");
		// File file = new
		// File("C:\Users\Manan\Downloads\sheruData\sheruData\filename.txt");
		Scanner sc = new Scanner(file);
		return sc.nextLine();
	}
}
