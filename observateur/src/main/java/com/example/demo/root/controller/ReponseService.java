package com.example.demo.root.controller;

import java.util.ArrayList;
import java.util.Collection;

public interface ReponseService {

    public abstract void createReponse(Reponse reponse);
    public abstract ArrayList<String> getQuestions();
    public void sendGlobalApi();
}
