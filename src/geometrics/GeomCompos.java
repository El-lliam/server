package geometrics;

import java.util.ArrayList;

/**
* GeomSimple ne peut pas se suffire à lui-même contrairement à de simples graphiques,
* Il se compose d’une série de figures, qui peuvent être considérées comme un ensemble de figures géométriques.
 */
public class GeomCompos extends Geometric{

    private ArrayList<Geometric> geometrics;

    public GeomCompos(){
        geometrics = new ArrayList<>();
    }

    /**
     * Ajoute une nouvelle forme simple geom à la collection.
     * @param geom est un graphique simple
     */
    public void addGeometric(Geometric geom){
        geometrics.add(geom);
    }

    /**
     * Ajoute une autre forme complexe à la collection de formes complexes actuelle
     * @param other c'est un graphique complexe
     */
    public void MergeGeomCompos(GeomCompos other){
        geometrics.addAll(other.geometrics);
    }

    public ArrayList<Geometric> getGeometrics() {
        return geometrics;
    }

    /**
     * Utilisez Visitor pour afficher les graphiques actuels, il faut les imprimer
     */
    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }

    /**
     * Effacez l'écran
     */
    public void clear(){geometrics.clear();}
}
