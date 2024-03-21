package geometrics.geom;

import geometrics.GeomSimple;
import geometrics.GeomVisitor;
import geometrics.tools.Points;

import java.util.List;

/**
 * Un polygone graphique simple composé d'une série de sommets
 */
public class Polygone extends GeomSimple {
	
	/**
	 * Utilisez plusieurs sommets pour définir un polygone.
	 * @param points Ensemble de sommets qui composent un polygone.
	 */
    public Polygone(List<Points> points) {
        for (Points p: points){
            addPoint(p);
        }
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }
}
