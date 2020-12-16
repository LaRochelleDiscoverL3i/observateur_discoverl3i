package com.example.demo.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class ScanServiceImp implements ScanService{






    private static int nbre_scan=0;
    private static  Map<String, Integer> joueur_scan = new HashMap<String, Integer>();
    private static Map<String, String> joueur_dernierscan = new HashMap<String, String>();

    @Override
    public HashMap<String, Integer> getJoueur_scan(String joueur) {
        HashMap<String, Integer> map = new HashMap<>();
        if ( joueur_scan.containsKey(joueur)){

            map.put( joueur,joueur_scan.get(joueur) );
            joueur_scan.remove(joueur);
            joueur_scan.put( joueur,0 );
            return map;
        }
        else{
            joueur_scan.put(joueur,0);
            map.put(joueur,joueur_scan.get(joueur) );
            return map;
        }

    }
    public void setJoueur_scan(Map<String, Integer> joueur_scan) {
        this.joueur_scan = joueur_scan;
    }


    /* reception scan joueur afin d'incrementer les scan d'un joueur

     */
    @Override
    public void createScan(Scan scan) {


        // verfier si le joueur exite deja ou non
        if(joueur_scan.containsKey(scan.getJoueur())){
            nbre_scan = joueur_scan.get(scan.getJoueur());
            nbre_scan++;
            joueur_scan.remove(scan.getJoueur());
            joueur_scan.put(scan.getJoueur(),nbre_scan);
            System.out.println("ca marche");
            joueur_dernierscan.remove(scan.getJoueur());
            joueur_dernierscan.put(scan.getJoueur(),scan.getChercheur());


        }
        else{

            joueur_scan.put(scan.getJoueur(),1);
            joueur_dernierscan.put(scan.getJoueur(),scan.getChercheur());
            System.out.println("ca marche pas ");

        }


    }

    // recuperer le dernier chercheur scanne par un joueur
    @Override
    public Map<String, String> getChercheur(String joueur) {
        HashMap<String, String> map = new HashMap<>();

        if(joueur_dernierscan.containsKey(joueur)){
            map.put(joueur, joueur_dernierscan.get(joueur));
        }

        return map;
    }


}
