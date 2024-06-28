package edu.escuelaing.arsw.ase.app.lab06.controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class Lab06Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
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

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/setpoints")
    public void setPoints(@RequestParam String xval, @RequestParam String yval) {
        Point a = new Point(Integer.valueOf(xval), Integer.valueOf(yval));
        xd.add(a);
    }
}
