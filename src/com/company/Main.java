package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int opc = 0;
        RegisterCDI cT = new RegisterCDI();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("SEJA BEM VINDO AO GLIFE\n Selecione uma das opções abaixo:");
            System.out.println("[1] - Cadastrar cidade\n[2] - Mostrar Vacinometro\n[3] - Cadastrar cidade/tipo" );
            switch (opc = in.nextInt()) {
                case 1:
                    cT.RegisterCTD();
                    break;
                case 2:
                    cT.ShowAll();
                    break;
                case 3:
                    cT.CadCity();
                    break;
                case 4:
                    break;
                default:

            }
        } while(opc !=4);
        System.out.println("Obrigado por usar GLIFE! Programa encerrado");
        in.close();
    }

    public class  oi{

    }
}


