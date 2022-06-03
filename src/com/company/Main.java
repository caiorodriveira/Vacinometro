package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int opc = 0;
        mainCity cT = new mainCity();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("SEJA BEM VINDO AO AOC\n Selecione uma das opções abaixo:");
            System.out.println("[1] - Cadastrar cidade\n[2] - Cadastrar vacina\n[3] - Cancelar");
            switch (opc = in.nextInt()) {
                case 1:
                    cT.SubMenuCityOptions();
                    break;
                case 2:
                    cT.ShowCity();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Obrigado por usar AOC! Programa encerrado");

            }
        } while(opc !=3);
        in.close();
    }
}