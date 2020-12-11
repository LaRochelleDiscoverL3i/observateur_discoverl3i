# observateur

Dans cette partie nous expliquerons la communication entre globalAPIServer et observateur. 

1. Partie Scan : 

- globalAPIServer recoie un scan du joueur  de la partie phoneGap , qui est de type : 
   {
     - question ,
      - chercheur,
      - joueur,
     }

  ex:

  {
    - "question": "auteuru .. ..",
    - "chercheur": "Arnaud Revel",
    - "joueur": "toto"
  }
  elle l'envoie directement le json à l'api du observaeur sur : localhost:port/scan
    
 
 2. Partie reponse : 
  - globalAPIServer recoie une reponse du joueur  de la partie phoneGap, qui est de type:
    {
      - question,
      - reponse :    /* la reponse du joeur peut etre bonne ou fausse */,
      - joueur,
        }
   - globalAPIServer doit chercher dans la base de donnes la bonne reponse de la question , puis elle envoie  à l'api du observaeur  le json suivant :
    {
      - question,
      - reponse,
      - joueur ,
      - reponse_joueur ,
    }

    {
      - "question": "qui travail avec jeanloup",
      - "reponse": "Arnaud revel",
      - "joueur": "toto",
      - "reponse_joueur":"Frederic Bertrand"
    }
  le json doit etre envoye sur :  localhost:port/reponses
     
     
  si la reponse du joueur , c-a-d : reponse = reponse_joueur , l'observateur envoie à globalAPIServer  le json   :
    {
      - question,
      - reponse,     
      - joueur
    }
        
   afin que globalAPIServer insere dans la table Question_joueur et scan_joueur  les infromations.
   
   
   Partie analyste: 
   
   - Pour que l'analyste fait ses analyses, il doit demander à globalAPIServer tt les x minutes  de lui trouver pour un  joueur son nombre scan ou son nombre de reponse. Afin que globalAPIServer trouve les informations demandes, il demande  à l'observateur pour un jour: 
  -  Pour nbre scan, il fait un get sur l'url : http://localhost:8080/analyste/curiosite/{joueur}
   il aura le json suivant :
     {
      - "joueur": nbre_scan
    }

    ex: 
     {
      - "toto": 4
    }

  - Pour nbre reponse, il fait un get sur l'url : http://localhost:8080/analyste/progression{joueur}
   il aura le json suivant :
     {
      - "joueur": nbre_reponse

      }
      ex:
      {
        - "toto": 3
      }
                           
                          
                          
                            
                                    
   
    
