package graphic;

import geometrics.GeomCompos;
import geometrics.GeomVisitor;
import geometrics.Geometric;
import geometrics.geom.Circle;
import geometrics.geom.Line;
import geometrics.geom.Polygone;
import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;

public class GeomDisplayVisitor implements GeomVisitor {

    private DisplayWindow w = DisplayWindow.getInstance();

    private static GeomDisplayVisitor instance;
    private GeomDisplayVisitor(){}

    /**
     * Le visiteur qui dessine des graphiques utilise le mode singleton, car il n'est pas nécessaire d'avoir plusieurs instances du visiteur
     */
    public static GeomDisplayVisitor getInstance(){
        if(instance == null){
            instance = new GeomDisplayVisitor();
        }
        return  instance;
    }

    @Override
    public void visit(GeomCompos geomCompos) {
        for (Geometric g :
                geomCompos.getGeometrics()) {
            g.accept(this);
        }
    }

    @Override
    public void visit(Circle c) {
        Graphics g = w.getGraphics();
        g.setColor(c.getColor());
        g.fillOval(c.getCenter().getX() - c.getR(),c.getCenter().getY() - c.getR(),c.getR() * 2,c.getR() * 2);
    }

    @Override
    public void visit(Polygone p) {
        int xx[] = new int[p.nbPoints()];
        int yy[] = new int[p.nbPoints()];
        int i=0;
        for (Points pt:p.getPoints()){
            xx[i] = pt.getX();
            yy[i] = pt.getY();
            i+=1;
        }
        Graphics g = w.getGraphics();
        g.setColor(p.getColor());
        g.fillPolygon(xx,yy,p.nbPoints());
    }

    @Override
    public void visit(Line line) {
        Points p1 = line.getPoints().get(0);
        Points p2 = line.getPoints().get(1);
        Graphics g = w.getGraphics();
        g.setColor(line.getColor());
        g.drawLine(p1.getX(), p1.getY(), p2.getX(),p2.getY());
    }


}
