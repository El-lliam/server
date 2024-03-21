package geometrics;

import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
* Les graphiques simples, contrairement à GeomCompos, sont des graphiques uniques,
* Tels que les polygones, les cercles et les segments de ligne, qui sont constitués d’une série d’extrémités
 */
public abstract class GeomSimple extends Geometric{
    private ArrayList<Points> points;

    private Color color = Color.black;
    public GeomSimple(){
        points = new ArrayList<>();
    }

    /**
     * Augmenter le nombre de sommets du graphe simple courant
     * @param p Il s'agit d'un point, y compris les coordonnées horizontales et verticales.
     */
    protected void addPoint(Points p){
        points.add(p);
    }

    /**
     * Renvoie le nombre de sommets de la forme simple actuelle.
     * @return points.size()
     */
    public int nbPoints(){
        return points.size();
    }

    /**
     * Renvoie tous les sommets du graphe simple courant.
     * @return points
     */
    public ArrayList<Points> getPoints(){
        return points;
    }

    /**
     * Renvoie la couleur
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * change la couleur
     * @param c
     */
    public  void setColor(Color c){
        color = c;
    }
}
