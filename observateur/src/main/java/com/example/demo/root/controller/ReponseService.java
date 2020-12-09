package com.example.demo.root.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface ReponseService {

    public abstract void createReponse(Reponse reponse);
    public abstract ArrayList<String> getQuestions();
    public abstract void sendGlobalApi();
    public HashMap<String, Integer> getJoueur_reponse(String joueur) ;
}


