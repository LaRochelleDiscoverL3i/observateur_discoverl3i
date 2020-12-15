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


    @RequestMapping(value = "/reponse", method = RequestMethod.POST)
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
    @RequestMapping(value = "/analyste/{type}/{joueur}", method = RequestMethod.GET)
    @ResponseBody
    HashMap<String, Integer>  findanalyste(  @PathVariable String type ,@PathVariable String joueur){

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



    @RequestMapping(value = "/chercheur/{joueur}", method = RequestMethod.GET)
    @ResponseBody
    Map<String, String> getChercheur(@PathVariable String joueur) {
        return scanService.getChercheur(joueur);
    }


}
