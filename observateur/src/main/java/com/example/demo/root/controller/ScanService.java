package com.example.demo.root.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ScanService {
    public abstract void createScan(Scan scan);
    public abstract Map<String, String> getChercheur(String joueur);
    public abstract HashMap<String, Integer> getJoueur_scan(String joueur);
}
