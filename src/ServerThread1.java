
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author troiano.daniele
 */
public class ServerThread1 {
    private Socket clientSocket;

    public ServerThread1(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        System.out.println("Serverino  partito: "
                + clientSocket.getInetAddress());
        try {

            PrintWriter out
                    = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String richiesta = "";
            while (!richiesta.equals("exit")) {
                System.out.println("serverino in ascolto...");
                richiesta = in.readLine();
                System.out.println("caratteri: " + richiesta);
                out.println("caratteri: " + richiesta.length());
            }

            out.close();
            clientSocket.close();

            System.out.println("chiusura connessione effettuata");

        } catch (IOException ex) {
            Logger.getLogger(ServerThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

