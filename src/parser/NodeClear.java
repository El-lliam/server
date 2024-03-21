package parser;

import geometrics.GeomCompos;
import graphic.DisplayWindow;

import java.util.ArrayList;

/**
 * 
 * Efface tous les graphiques de l'écran actuel.
 *
 */
public class NodeClear extends ResponsibleChainNode{
    public NodeClear(CmdLevel cmdLevel, NodeSave prev) {
            super(cmdLevel, prev);
    }

    /**
     * Effacez l'écran.
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        DisplayWindow.getInstance().clear();
    }
}
