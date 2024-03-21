package geometrics.tools;

import java.io.Serializable;

/**
 * La base de tous les graphiques. 
 * Tous les graphiques sont constitués par de points. 
 * Par exemple, deux points peuvent déterminer un segment de droite. 
 */
public class Points implements Serializable {
    private int x;
    private int y;

    /**
     * Un point a deux attributs de base d'abscisse et d'ordonnée.
     * @param x abscisse du point
     * @param y ordonnée du point
     */
    public Points(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Points(Integer x,Integer y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
