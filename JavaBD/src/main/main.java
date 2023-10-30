package main;

import controle.controle;

public class main {

    public static void main(String[] args) {
        controle inicio = new controle();
        
        persistencia.DBConnection.getConnection();
        
        inicio.menu();
    }
    
}
