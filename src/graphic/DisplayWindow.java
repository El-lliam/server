package graphic;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

/**
 * Appelez l'interface graphique pour générer une fenêtre graphique, en utilisant le mode singleton, car il n'y a pas besoin de plusieurs fenêtres
 */
public class DisplayWindow {

    private static DisplayWindow instance;
    private DisplayWindow(){}

    /**
     * Appelez l'interface graphique pour générer une fenêtre graphique, en utilisant le mode singleton, car plusieurs clients n'ont pas besoin de plusieurs fenêtres et plusieurs clients dessinent dans la même fenêtre
     */
    public static DisplayWindow getInstance(){
        if(instance == null){
            instance = new DisplayWindow("display");
        }
        return instance;
    }

    private  Frame frame;//Classes requises pour définir les paramètres de la fenêtre d'affichage

    public Frame getFrame() {
        return frame;
    }

    /**
     * Ouvrez une fenêtre qui peut être utilisée pour le dessin et complétez ses paramètres de base.
     * @param name Le nom de la fenêtre.
     */
    public DisplayWindow(String name){
        frame = new Frame(name);
        frame.setBounds(60,60,900,600);
        frame.setVisible(true);
        frame.setIgnoreRepaint(true);
        frame.createBufferStrategy(2);
        
        frame.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		frame.dispose();
        		System.exit(0);
        	}
        });
        
        try {
            Thread.sleep(150);
        }
        catch (InterruptedException e){

        }

        update();
    }

    /**
     * obtenir obj dessinable
     */
    public Graphics getGraphics(){
        return  frame.getBufferStrategy().getDrawGraphics();
    }

    /**
     * Après avoir dessiné les graphiques, vous devez appeler cette méthode pour afficher les nouveaux graphiques dessinés à l'écran
     */
    public void update(){
        BufferStrategy strategy = frame.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        strategy.show();
        graphics.dispose();
    }

    /**
     * Effacer la peinture sur l'écran
     */
    public void clear(){
        BufferStrategy strategy = frame.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,frame.getWidth(),frame.getHeight());
        graphics.setColor(c);
        System.out.println("clear");
    }

}
