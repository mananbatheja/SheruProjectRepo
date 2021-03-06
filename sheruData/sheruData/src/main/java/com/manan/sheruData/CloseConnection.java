package com.manan.sheruData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import serverClient.client;
import serverClient.server;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="sherudata")
public class CloseConnection {

    @PostMapping(value="/closeConnection")
    public void close() throws IOException {
    	server.sendJSON();
    }
}

