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


    /*
    *
    *  */
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    List<String> getQuestion() {

        return reponseService.getQuestions();
    }

    /*
     * Route : localhost:8084/reponse
     * Type: POST
     * permet de GlobalApiServer d'envoyer les reponses a l'observateur pour qu'il fait ses observations sur les reponses des joueurs
     *
     * */
    @RequestMapping(value = "/reponse", method = RequestMethod.POST)
    void addReponse(@RequestBody Reponse reponse){


        reponseService.createReponse(reponse);
    }
    /*
    * pour tester les poste sur GLobalApiServer
     */
    @RequestMapping(value = "/api", method = RequestMethod.POST)
    void apiReponse(@RequestBody Reponse reponse){


       System.out.println("recu");
    }

    /*
     * Route : localhost:8084/scan
     * Type: POST
     * permet de GlobalApiServer d'envoyer les scan a l'observateur pour qu'il fait ses observations sur les scans des joueurs
     *
     */

    @RequestMapping(value = "/scan", method = RequestMethod.POST)
    void addScan(@RequestBody Scan scan){


        scanService.createScan(scan);

    }


    /*
     * Route : localhost:8084/analyste/{type}/{joueur}
     * Type: GET
     * permet de GlobalApiServer de recuperer la curiosite ou la progression d'un joueur
     *
     *return  {
     *          -"joueur": "nbre"
     *           }
     */
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


    /*
      *Route : localhost:8084/chercheur/joueur
      *Type: GET
      * return :
      * {
      *   - "joueur": "dernierchercheurScane"
      * }

     */

    @RequestMapping(value = "/chercheur/{joueur}", method = RequestMethod.GET)
    @ResponseBody
    Map<String, String> getChercheur(@PathVariable String joueur) {
        return scanService.getChercheur(joueur);
    }


}
