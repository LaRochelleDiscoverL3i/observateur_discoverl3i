package com.example.demo.root.controller;

public class Scan {

    String question;
    String chercheur;
    String joueur;

    public Scan(){}
    public Scan(String question, String chercheur, String joueur) {
        this.question = question;
        this.chercheur = chercheur;
        this.joueur = joueur;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChercheur() {
        return chercheur;
    }

    public void setChercheur(String chercheur) {
        this.chercheur = chercheur;
    }

    public String getJoueur() {
        return joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }
}
