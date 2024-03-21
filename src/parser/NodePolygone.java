package parser;

import geometrics.GeomCompos;
import geometrics.geom.Polygone;
import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Utilisé pour traiter les données sur les polygones envoyées par le client.
 *
 */
public class NodePolygone extends ResponsibleChainNode {
    public NodePolygone(CmdLevel polygone, ResponsibleChainNode prev) {
        super(polygone,prev);
    }
    /**
     * Dessinez un polygone, stockez les sommets du polygone dans des arguments
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        List<Points> points = new ArrayList<>();

        for(int i=0;i<args.size()-3;i+=2){
            points.add(new Points(args.get(i),args.get(i+1)));
        }

        Polygone pl = new Polygone(points);
        int r = args.get(args.size()-3);
        int g = args.get(args.size()-2);
        int b = args.get(args.size()-1);
        pl.setColor(new Color(r,g,b));
        geom.addGeometric(pl);
    }
}
