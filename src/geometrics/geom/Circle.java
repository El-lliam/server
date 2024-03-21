package geometrics.geom;
import geometrics.GeomSimple;
import geometrics.GeomVisitor;
import geometrics.tools.Points;

/**
 * Une forme simple, un cercle, se compose d'un centre et d'un rayon
 */
public class Circle extends GeomSimple {
    private Points center;
    private int R;

    /**
     * Générez un cercle.
     * @param center Un point contenant les coordonnées du centre du cercle.
     * @param R rayon du cercle
     */
    public Circle(Points center,int R){
        addPoint(center);
        this.center = center;
        this.R = R;
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }

    public Points getCenter() {
        return center;
    }

    public void setCenter(Points center) {
        this.center = center;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }
}
