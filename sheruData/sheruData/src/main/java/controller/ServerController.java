package controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="sherudata")
public class ServerController {

    @GetMapping(value="/upload")
    public void getData(){
        System.out.println("<h1>Hello</h1>");
 
    }
}