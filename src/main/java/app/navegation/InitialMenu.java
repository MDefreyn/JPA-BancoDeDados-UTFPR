package app.navegation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InitialMenu {
    static String head = "\nInforme uma opção entre os símbolos [ ]";
    static String erro = "\nOpção inválida. Selecione o número ou letra que esta entre os símbolos [ ]!\n";
    static boolean sair;

    public boolean ignite() {
        System.out.print(head);
        System.out.print("\n\t[1]\t[C]rud App");
        System.out.print("\n\t[2]\t[D]inamic query");
        System.out.print("\n\t[3]\t[E]xpressão Select New");
        System.out.print("\n\t[4]\t[N]amed query");
        System.out.print("\n\t[5]\t[O]utras");
        System.out.print("\n\t[ ]\t[S]air\n\n");
        char str = getOpcao().toUpperCase().charAt(0);
        switch (str) {
            case '1':
            case 'C':
                return new CrudApp().menu();
            case '2':
            case 'D':
                return new DinamicQuery().start();
            case '3':
            case 'E':
                return new SelectNew().start();
            case '4':
            case 'N':
                return new NamedQuery().start();
            case '5':
            case 'O':
                return new Outras().start();
            case 'S':
                return false;
            default:
                System.out.print(erro);
        }
        return true;
    }

    private String getOpcao() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.print("Digite aqui:");
        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str.isEmpty()) {
            str = "0";
        }
        return str;
    }
}
