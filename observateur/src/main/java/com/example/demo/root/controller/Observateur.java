package com.example.demo.root.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/analyste/{joueur}/{type}", method = RequestMethod.GET)
    @ResponseBody
    HashMap<String, Integer>  findanalyste( @PathVariable String joueur, @PathVariable String type){

        if(type.equals("progression")){
            System.out.println("progressivite");

            return reponseService.getJoueur_reponse(joueur);
        }

        if(type.equals("curiosite")){
            System.out.println("curiosite");
            return scanService.getJoueur_scan(joueur);

        }
        else {
            return null;
        }

    }



    @RequestMapping(value = "/chercheur", method = RequestMethod.GET)
    @ResponseBody
    String getChercheur() {
        return scanService.getChercheur();
    }


}
