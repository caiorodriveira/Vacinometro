package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int opc = 0;
        RegisterCDI cT = new RegisterCDI();
        ShowFunctions sF = new ShowFunctions();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("SEJA BEM VINDO AO GLIFE\nSelecione uma das opções abaixo:");
            System.out.println("[1] - Cadastrar cidade\n[2] - Mostrar Vacinometro\n[3] - Cadastrar cidade/tipo\n[4] - Listar cidades\n[5] - Listar Doses\n[6] - Sair" );
            switch (opc = in.nextInt()) {
                case 1:
                    cT.RegisterCTD();
                    break;
                case 2:
                    sF.ShowAll();
                    break;
                case 3:
                    cT.CadCity();
                    break;
                case 4:
                    sF.ShowCitys();
                    break;
                case 5:
                    sF.ShowTypes();
                    break;
                case 6:
                    break;
                default:

            }
        } while(opc !=6);
        System.out.println("Obrigado por usar GLIFE! Programa encerrado");
        in.close();
    }

    public class  oi{

    }
}


