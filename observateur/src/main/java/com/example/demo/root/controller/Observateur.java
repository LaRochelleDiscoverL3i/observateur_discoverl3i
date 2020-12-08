package com.example.demo.root.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Observateur {




    @Autowired
    ReponseService reponseService;

    @Autowired
    ScanService scanService;


    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    List<String> getQuestion() {

        return reponseService.getQuestions();
    }


    @RequestMapping(value = "/reponses", method = RequestMethod.POST)
    void addReponse(@RequestBody Reponse reponse){


        reponseService.createReponse(reponse);
    }

    @RequestMapping(value = "/api", method = RequestMethod.POST)
    void apiReponse(@RequestBody Reponse reponse){


       System.out.println("recu");
    }

    @RequestMapping(value = "/scan", method = RequestMethod.POST)
    void addScan(@RequestBody Scan scan){


        scanService.createScan(scan);

    }



    @RequestMapping(value = "/chercheur", method = RequestMethod.GET)
    @ResponseBody
    String getChercheur() {
        return scanService.getChercheur();
    }


}
