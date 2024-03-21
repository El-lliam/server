package geometrics.geom;

import geometrics.GeomSimple;
import geometrics.GeomVisitor;
import geometrics.tools.Points;

/**
 * Graphiques simples Un segment de ligne composé de deux extrémités
 */
public class Line extends GeomSimple {

	/**
	 * Définissez une ligne droite avec deux extrémités.
	 * @param p1 L'extrémité gauche de la ligne.
	 * @param p2 L'extrémité droite de la ligne.
	 */
    public Line(Points p1, Points p2) {
        addPoint(p1);
        addPoint(p2);
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }
}
