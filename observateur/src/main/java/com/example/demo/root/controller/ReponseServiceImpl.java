package com.example.demo.root.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ReponseServiceImpl implements ReponseService{
    private static Reponse rep =new Reponse();
    private static Map<String, Integer> joueur_reponse = new HashMap<String, Integer>();


    private String reponse_joueur;
    private String bonne_reponse;
    private int nbre_reponses=0;

    private static ArrayList<String> questions = new ArrayList<String>();

    @Override
    public void createReponse(Reponse reponse) {

        if(joueur_reponse.containsKey(reponse.getJoueur())){
            nbre_reponses = joueur_reponse.get(reponse.getJoueur());
            nbre_reponses++;
            joueur_reponse.remove(reponse.getJoueur());
            joueur_reponse.put(reponse.getJoueur(),nbre_reponses);
            System.out.println("ca marche");


        }
        else{

            joueur_reponse.put(reponse.getJoueur(),1);
            System.out.println("ca marche pas ");

        }
        rep.setQuestion(reponse.getQuestion());
        reponse_joueur= reponse.getReponse_joueur();
        rep.setJoueur(reponse.getJoueur());
        bonne_reponse= reponse.getReponse();



        sendGlobalApi();
    }

    @Override
    public HashMap<String, Integer> getJoueur_reponse(String joueur) {
        HashMap<String, Integer> map = new HashMap<>();
        if(joueur_reponse.containsKey(joueur)){
            map.put(joueur,joueur_reponse.get(joueur) );
            joueur_reponse.remove(joueur);
            joueur_reponse.put(joueur,0);
            return map;
        }
        else{
            joueur_reponse.put(joueur,0);
            map.put(joueur,joueur_reponse.get(joueur));
            return map;
        }

    }

    public void setJoueur_reponse(Map<String, Integer> joueur_reponse) {
        this.joueur_reponse = joueur_reponse;
    }

    @Override
    public ArrayList<String> getQuestions() {
        return questions;
    }

    @Override
    public void sendGlobalApi(){



        RestTemplate template = new RestTemplate();

        if(bonne_reponse.equals(reponse_joueur)){
            if(joueur_reponse.containsKey(rep.getJoueur())){
                nbre_reponses = joueur_reponse.get(rep.getJoueur());
                nbre_reponses++;
                joueur_reponse.remove(rep.getJoueur());
                joueur_reponse.put(rep.getJoueur(),nbre_reponses);

            }
            else{
                joueur_reponse.put(rep.getJoueur(),1);

            }


            rep.setReponse(bonne_reponse);
            System.out.println("coucou");
            questions.add("bonne reponse" +bonne_reponse );
            String url = "http://localhost:8084/api";
            template.postForLocation(url, rep);
        }
        else{
            rep.setReponse(reponse_joueur);
            String url = "http://localhost:8084/api";
            template.postForLocation(url, rep);
            questions.add("mauvaise reponse" );

        }




    }
}
