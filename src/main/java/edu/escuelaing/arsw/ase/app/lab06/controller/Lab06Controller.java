package edu.escuelaing.arsw.ase.app.lab06.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class Lab06Controller {
    private ArrayList<Point> xd = new ArrayList<>();
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getpoints")
    public String getPoints() {
        return new Gson().toJson(xd);
    }

    @GetMapping("/points")
    public String points() {
        String a = "";
        Point ab = new Point(Integer.valueOf(0), Integer.valueOf(0));
        xd.add(ab);
        for (Point b : xd) {
            a += b + "\n";
        }
        return a;
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/setpoints")
    public void setPoints(@RequestParam String xval, @RequestParam String yval) {
        Point a = new Point(Integer.valueOf(xval), Integer.valueOf(yval));
        xd.add(a);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/delpoints")
    public void delPoints() {
       ArrayList<Point> con = new ArrayList<>();
       xd = con;
    }
}
