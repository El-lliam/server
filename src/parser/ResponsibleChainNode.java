package parser;

import geometrics.GeomCompos;

import java.util.ArrayList;

/**
 * 
 * Il s'agit d'une classe d'énumération, qui est utilisée pour analyser l'en-tête d'information envoyé par le client. 
 * Par exemple, si l'en-tête de message envoyé par le client est 0... alors c'est Cercle, ce qui signifie dessiner un cercle. 
 * Si c'est 4, puis c'est Charger Lire les graphiques précédemment enregistrés
 *
 */
enum CmdLevel {
    CIRCLE,
    POLYGONE,
    Line ,
    LOAD,
    SAVE,
    CLEAR
}

/**
 * La classe parent de tous les nœuds de la chaîne dans le mode Chaîne de responsabilité
 * Tous les autres nœuds en héritent, tels que NodeCircle NodeLine, etc., 
 * et ils sont tous responsables du traitement de la demande envoyée par un certain Client
 */
public abstract class ResponsibleChainNode {
    protected CmdLevel level = null; /* Le type de requête géré par ce nœud, par exemple, 0 signifie qu'il ne gère que les requêtes de dessin circulaires */
    protected ResponsibleChainNode next = null; /* le nœud suivant de ce nœud */

    public ResponsibleChainNode(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        this.level = cmdLevel;
        prev.next = this;
    }

    public ResponsibleChainNode() {

    }

    public ResponsibleChainNode(CmdLevel cmdLevel) {
        this.level = cmdLevel;
    }

    /**
     * Déterminez si la requête est traitée par ce nœud, si oui, exécutez exec, sinon envoyez la requête au nœud suivant
     * @param geom Représente la collection de tous les graphiques à l'écran
     * @param cmd_idx L'en-tête de requête du client, tel que le dessin d'un cercle, nécessite que l'en-tête de requête soit 0
     * @param args D'autres paramètres demandés par le client, tels que le dessin d'un cercle, nécessitent l'emplacement du centre du cercle et la taille du rayon
     */
    public void handle(GeomCompos geom, int cmd_idx, ArrayList<Integer> args){
        if(cmd_idx > level.ordinal()){
            next.handle(geom,cmd_idx,args);
        }
        else {
            System.out.println("Request :" + this.level.name() + " " + args.toString());
            exec(geom,args);
        }
    }
    /**
     * Lorsqu'il est confirmé que la demande du client doit être traitée par ce nœud, cette fonction sera appelée pour effectuer des opérations spécifiques, et des opérations spécifiques doivent être implémentées dans des sous-classes
     * @param geom Représente la collection de tous les graphiques à l'écran
     * @param args D'autres paramètres demandés par le client, tels que le dessin d'un cercle, nécessitent l'emplacement du centre du cercle et la taille du rayon
     */
    protected abstract void exec(GeomCompos geom, ArrayList<Integer> args);
}
