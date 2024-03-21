package parser.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Le client traite les données.
 *
 */
public class Client {
    private Socket socket;
    private DataInputStream in;

    private LinkedList<String> cmdBuff = new LinkedList<>();

    /**
     * Analysez le flux d'octets dans DataInputStream, 
     * la fin d'une chaîne est représentée par un caractère de saut de ligne, 
     * convertissez-les en chaînes et placez-les dans cmdBuff une par une
     */
    
    private void upate() throws IOException{
        if(in.available() == 0)return;
        byte [] buff = new byte[1024 * 5];
        int nb = in.read(buff);
        String res = new String(buff,0,nb,"UTF-8");
        List<String> tmps = Arrays.asList(res.split("\n"));
        cmdBuff.addAll(tmps);
    }
    public Client(Socket sc) throws IOException {
        socket = sc;
        in = new DataInputStream(sc.getInputStream());
    }

    /**
     * Renvoie la chaîne de requête analysée
     * @return  Renvoie la première chaîne analysée avec succès
     */
    public String readMsg() throws IOException {
        upate();
        if(cmdBuff.size() == 0)
            return "";
        return cmdBuff.removeFirst();
    }
    /**
     * Le lien client est déconnecté, le socket peut être fermé
     */
    public void quit() throws IOException {
        System.out.println("A client was disconnected");
        socket.close();
    }
}
