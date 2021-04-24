package app;

import app.conect.ConnectManager;
import app.navegation.InitialMenu;

import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {

        ConnectManager manager = new ConnectManager();

        InitialMenu start = new InitialMenu();
        boolean end;

        System.out.println("Universidade Tecnológica Federal do Paraná");
        System.out.println("Tecnologia em Sistemas para Internet");
        System.out.println("Banco de dados 2");
        System.out.println("Aplicação JPA");
        System.out.print("\n\n\n");
        System.out.print("\nDev by: Maiko Rodrigo Defreyn\n");
        System.out.print("\nBEM VINDO!\n");
//        do {
            EntityTransaction transaction = manager.init();
            transaction.begin();
//            end = start.ignite();
            manager.close();
//        } while (end);
        System.out.print("\n\n\n");
        System.out.print("Encerrando aplicação!");
    }
}
