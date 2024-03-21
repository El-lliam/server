package parser;

import geometrics.GeomCompos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * 
 * Lire les données graphiques d'un fichier local et les afficher à l'écran.
 *
 */
public class NodeLoad extends ResponsibleChainNode{
    public NodeLoad(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        super(cmdLevel, prev);
    }

    /**
     * Lire le dernier graphique enregistré et l'afficher à l'écran
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        try{
            FileInputStream fi = new FileInputStream("GomeSaved.geom");
            ObjectInputStream in = new ObjectInputStream(fi);
            GeomCompos tmp = (GeomCompos) in.readObject();
            geom.getGeometrics().clear();
            geom.MergeGeomCompos(tmp);
            in.close();
            fi.close();
        }
        catch (IOException i)
        {
            System.out.println(i);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
