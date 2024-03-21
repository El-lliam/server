package parser.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 
 * Le serveur traite les données.
 *
 */
public class Server implements Runnable{
    private ServerSocket ss = null;
    private List<Client> clients = new Vector<>();/* Liste de tous les clients connectés */

    private static Server instance = null;
    private Server(){}

    /**
     * Le serveur est également en mode singleton, la seule instance qui renvoie le serveur écoute le port 8080 en même temps
     */
    public static Server getInstance()throws IOException {
        if(instance == null){
            instance = new Server();
            instance.ss = new ServerSocket(8080);
            Thread thread = new Thread(instance);/*Ouvrez un autre thread pour exécuter la méthode run pour écouter le port et attendre la connexion tcp du client*/
            thread.start();
        }
        return instance;
    }


    /**
     * Parcourez tous les clients connectés, lisez leurs requêtes, placez leurs requêtes dans une liste et renvoyez-les, si la requête est une chaîne de sortie, le client se déconnectera
     * @return  Renvoyer toutes les chaînes de requête client dans une liste
     */
    public List<String> update() throws IOException {
        List<String> res = new LinkedList<>();
        List<Client> toRemove = new LinkedList<>();
         for(Client c : clients){
            String msg = c.readMsg();
            if(msg.length() == 0)
                continue;
            System.out.println(msg);
            if(msg.equals("quit")){
                toRemove.add(c);
                c.quit();
            }
            else
                res.add(msg);
        }

         clients.removeAll(toRemove);
         toRemove.clear();

        return  res;
    }

    /**
     * Un autre thread exécute la méthode d'exécution du serveur, dans cette méthode, le port d'écoute attend la connexion tcp du client
     * La raison pour laquelle il est exécuté avec un autre thread est que la méthode ss.accept est bloquée et qu'elle sera bloquée dans cette ligne jusqu'à ce qu'elle attende une connexion tcp.
     */
    @Override
    public void run() {
        try {
            while (true){
                Socket sc = ss.accept();
                clients.add(new Client(sc));
                System.out.println("new client :" + clients.size());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
