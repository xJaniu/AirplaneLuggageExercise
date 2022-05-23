package com.example.Airlines.Controllers;

import com.example.Airlines.Model.Flight;
import com.example.Airlines.Model.Luggage;
import com.example.Airlines.Services.FlightService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/")
    public String findAllFlights(Model model){
        model.addAttribute("allFlights", flightService.findAllFlights());
        return "index";
    }

    @GetMapping("/showLuggage")
    public String showLuggage(Model model){
        model.addAttribute("allLuggage", flightService.findAllLuggage());
        return "show-luggage";
    }

    @GetMapping("/deleteAllFlights")
    public String deleteAllFlights(){
        this.flightService.deleteAllFlights();
        return "redirect:/";
    }

    @GetMapping("/deleteAllLuggage")
    public String deleteAllLuggage(){
        this.flightService.deleteAllLuggage();
        return "redirect:/";
    }

//    @GetMapping("/test/{flightId}")
//    public String testQuery(@PathVariable (value = "id") int id, Model model){
//        this.flightService.infoByFlightNumber(id);
//        return "redirect:/";
//
//    }

    @GetMapping("/uploadData")
    public String uploadData(){


        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;

        try {
            FileReader fr = new FileReader("flights.json");
            Object obj = jsonParser.parse(fr);
            JSONArray flightList = (JSONArray) obj;

            for(int i = 0;i<flightList.size();i++){
                jsonObject = (JSONObject) flightList.get(i);
                Flight flight = new Flight();
                flight.setFlightId((Long) jsonObject.get("flightId"));
                flight.setFlightNumber((Long) jsonObject.get("flightNumber"));
                flight.setArrivalAirportIATACode((String) jsonObject.get("departureAirportIATACode"));
                flight.setDepartureAirportIATACode((String) jsonObject.get("arrivalAirportIATACode"));
                flight.setDepartureDate((String) jsonObject.get("departureDate"));



                flightService.addFlight(flight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject1,jsonObject2;

        try(FileReader fr = new FileReader("luggage.json")) {

            Object obj = jsonParser.parse(fr);
            JSONArray boardList = (JSONArray) obj;
            JSONArray baggage, cargo;
            long id, pieces, weight;

            for(int i = 0;i<boardList.size();i++){
                jsonObject = (JSONObject) boardList.get(i);
                baggage = (JSONArray) jsonObject.get("baggage");
                cargo = (JSONArray) jsonObject.get("cargo");

                for(int j = 0;j<baggage.size();j++){
                    jsonObject1 = (JSONObject) baggage.get(j);
                    Luggage luggage = new Luggage();
                    luggage.setFlightId((Long) jsonObject.get("flightId"));
                    luggage.setLuggageType("baggage");

                    id = (long) jsonObject1.get("id");
                    luggage.setId((int) id);

                    pieces = (long) jsonObject1.get("pieces");
                    luggage.setPieces((int) pieces);

                    weight = (long) jsonObject1.get("weight");
                    luggage.setWeight((double) weight);

                    luggage.setWeightUnit((String) jsonObject1.get("weightUnit"));
                    flightService.addLuggage(luggage);
                }

                for(int k = 0;k< cargo.size();k++){
                    jsonObject2 = (JSONObject) cargo.get(k);
                    Luggage luggage2 = new Luggage();
                    luggage2.setFlightId((Long) jsonObject.get("flightId"));
                    luggage2.setLuggageType("cargo");

                    id = (long) jsonObject2.get("id");
                    luggage2.setId((int) id);

                    pieces = (long) jsonObject2.get("pieces");
                    luggage2.setPieces((int) pieces);

                    weight = (long) jsonObject2.get("weight");
                    luggage2.setWeight((double) weight);

                    luggage2.setWeightUnit((String) jsonObject2.get("weightUnit"));
                    flightService.addLuggage(luggage2);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }





        return "redirect:/";
    }
}
