package com.example.demo.root.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class ReponseServiceImpl implements ReponseService{
    private static Reponse rep =new Reponse();

    private String reponse_joueur;
    private String bonne_reponse;
    private int nbre_reponses=0;

    private static ArrayList<String> questions = new ArrayList<String>();

    @Override
    public void createReponse(Reponse reponse) {
        rep.setQuestion(reponse.getQuestion());
        reponse_joueur= reponse.getReponse_joueur();
        rep.setJoueur(reponse.getJoueur());
        bonne_reponse= reponse.getReponse();


        sendGlobalApi();
    }




    @Override
    public ArrayList<String> getQuestions() {
        return questions;
    }

    @Override
    public void sendGlobalApi(){



        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/api";
        if(bonne_reponse.equals(reponse_joueur)){
            nbre_reponses++;
            rep.setReponse(bonne_reponse);
            System.out.println("coucou");
            questions.add("bonne reponse" +bonne_reponse );

            template.postForLocation(url, rep);
        }
        else{
            rep.setReponse("");
            template.postForLocation(url, rep);
            questions.add("mauvaise reponse" );

        }




    }
}
