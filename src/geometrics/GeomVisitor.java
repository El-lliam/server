package geometrics;

import geometrics.geom.Circle;
import geometrics.geom.Line;
import geometrics.geom.Polygone;

/**
 * Le mode visiteur est utilisé pour dissocier le contenu graphique et la méthode de dessin.
  * Par exemple, le tracé actuel utilise la bibliothèque awt, qui est implémentée dans GeomDisplayVisitor.
  * Si vous souhaitez utiliser d’autres bibliothèques pour dessiner, il vous suffit d’implémenter un autre visiteur sans modifier le code graphique.
 */
public interface GeomVisitor {

	/**
	 * Graphiques composites découplés
	 * @param g
	 */
    void visit(GeomCompos g);
    
    /**
     * Circle découplé.
     * @param c
     */
    void visit(Circle c);
    
    /**
     * Polygones découplés.
     * @param p
     */
    void visit(Polygone p);

    /**
     * Découpler les lignes.
     * @param line
     */
    void visit(Line line);
}
