package geometrics;

import java.io.Serializable;

/**
* Classe parente pour tous les graphiques,
* Tous les graphiques doivent hériter de la classe et implémenter la méthode accept pour accepter l’accès du visiteur
 */
public abstract class Geometric implements Serializable {
    public abstract void accept(GeomVisitor geomVisitor);
}
