package com.example.demo.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Service
public class ScanServiceImp implements ScanService{





    private static String chercheur ="";
    private static int nbre_scan=0;
    @Override
    public void createScan(Scan scan) {

        chercheur =scan.getChercheur();
        nbre_scan++;


    }

    @Override
    public String getChercheur() {

        return chercheur;
    }


}
