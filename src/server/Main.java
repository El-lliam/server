package server;

import geometrics.GeomCompos;
import geometrics.GeomVisitor;
import graphic.DisplayWindow;
import graphic.GeomDisplayVisitor;
import geometrics.geom.Circle;
import geometrics.tools.Points;
import parser.RequestParser;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            GeomCompos rootGeom = new GeomCompos(); /*Une collection de graphiques représentant tout l'écran*/

            while (true) {
                boolean changed = RequestParser.getInstance().update(rootGeom);/*Analyser et traiter la requête, et indiquer si un nouveau graphique a été ajouté*/
                if (changed) {
                    GeomDisplayVisitor.getInstance().visit(rootGeom);/*Si de nouveaux graphiques sont ajoutés, utilisez le visiteur pour y accéder et effectuez le traitement correspondant via le visiteur, ici pour dessiner via awt*/
                    DisplayWindow.getInstance().update();
                    rootGeom.clear();
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}