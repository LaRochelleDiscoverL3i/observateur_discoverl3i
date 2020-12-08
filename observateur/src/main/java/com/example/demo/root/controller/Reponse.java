package com.example.demo.root.controller;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reponse {

    String question;
    String reponse_joueur;
    String joueur;
    String reponse;



    public Reponse(){}
    public Reponse(String question,  String joueur ,String reponse){
        this.question=question;
        this.joueur=joueur;
        this.reponse = reponse;


    }
    public Reponse(String question, String reponse_joueur, String joueur ,String reponse){
        this.question=question;
        this.reponse_joueur=reponse_joueur;
        this.joueur=joueur;
        this.reponse = reponse;


    }


    public String getReponse_joueur() {
        return reponse_joueur;
    }

    public void setReponse_joueur(String reponse_joueur) {
        this.reponse_joueur = reponse_joueur;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getJoueur() {
        return joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }
}
