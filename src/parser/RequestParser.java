package parser;

import geometrics.GeomCompos;
import parser.network.Server;

import java.io.IOException;
import java.util.ArrayList;

/**
 * L'analyseur de demande client convertit l'analyse de la demande client sous la forme d'une chaîne en une forme retraitable et la transmet à la chaîne de responsabilité du traitement.
 */
public class RequestParser {
    /**
     *  Le nœud principal de la chaîne de responsabilité, toutes les demandes qui se résolvent avec succès seront transmises de la tête jusqu'à ce que le nœud de traitement correspondant soit trouvé
     */
    private static ResponsibleChainNode root = null;
    private RequestParser(){
        root = new NodeCircle(CmdLevel.CIRCLE);
        NodePolygone p = new NodePolygone(CmdLevel.POLYGONE,root);
        NodeLine ln = new NodeLine(CmdLevel.Line,p);
        NodeLoad load = new NodeLoad(CmdLevel.LOAD,ln);
        NodeSave save = new NodeSave(CmdLevel.SAVE,load);
        NodeClear clear = new NodeClear(CmdLevel.CLEAR,save);
    }
    private static RequestParser instance = null;

    /**
     * L'analyseur est un modèle singleton, car il n'est pas nécessaire d'avoir plusieurs analyseurs
     */
    public static RequestParser getInstance(){
        if(instance == null){
            instance = new RequestParser();
        }
        return instance;
    }

    /**
     * Déterminez si la requête est traitée par ce nœud, si oui, exécutez exec, sinon envoyez la requête au nœud suivant
     * @param screen Représente une collection de tous les graphiques à l'écran, car les instructions analysées peuvent y ajouter de nouveaux graphiques
     * @return Indique si un nouveau graphique a été ajouté à l'écran
     */
    public boolean update(GeomCompos screen) throws IOException {
        try {
            for(String msg: Server.getInstance().update()){
                String[] args = msg.split(" ");
                if(args.length == 0) return false;

                ArrayList<Integer> params = new ArrayList<>();
                int cmd = Integer.parseInt(args[0]);

                for(int i = 1;i < args.length;++i){
                    params.add(Integer.parseInt(args[i]));
                }

                root.handle(screen,cmd,params);
                return  true;
            }
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex);
        }
        return  false;
    }

}
