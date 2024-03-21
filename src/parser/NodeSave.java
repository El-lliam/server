package parser;

import geometrics.GeomCompos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * Enregistrez les données de tous les graphiques affichés sur l'écran actuel dans le local sous la forme d'un fichier, ce qui est pratique pour la lecture la prochaine fois.
 *
 */
public class NodeSave extends ResponsibleChainNode{
    public NodeSave(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        super(cmdLevel, prev);
    }

    /**
     * Enregistrez l'objet graphique de l'écran actuel sous forme de fichier, vous pouvez directement lire et afficher cet objet la prochaine fois que vous souhaitez l'utiliser
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {

        try {
            FileOutputStream fo = new FileOutputStream("GomeSaved.geom");

            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(geom);
            out.close();
            fo.close();
            System.out.println("Save file ok");
        }
        catch (IOException i){
            System.out.println("Cant save file");
        }

    }
}
