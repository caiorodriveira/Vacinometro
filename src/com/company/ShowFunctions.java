package com.company;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShowFunctions {
    // INICIO DO PROGRAMA SHOWALL, RESPONSÁVEL POR MOSTRAR TUDO O QUE TEM CADASTRADO NO "dosesApli.dat"
    public  void  ShowAll()
    {
        Scanner in = new Scanner(System.in);
        initUrl getUrl = new initUrl();
        String urlNew = getUrl.SearchUrlDosesAplicadas();
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("dosesApli.dat")))) {
            System.out.println("Cidades,TiposDeDose,DosesAplicadas");
            while (true) {

                DosesAplicadas dosesApl = (DosesAplicadas) input.readObject();
                System.out.println(dosesApl.Cidade + "," + dosesApl.TiposDeDose + "," + dosesApl.DosesAplicadas);

            }
        } catch (EOFException e) {
            System.out.println("Fim dos registros");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
    // FIM DO PROGRAMA SHOWALL


    public static  void ShowCitys()
    {
        Scanner in = new Scanner(System.in);
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("cidades.dat")))) {
            System.out.println("Cidades");
            while (true) {
                Cidade cT = (Cidade) input.readObject();
                System.out.println(cT.cidade);

            }
        } catch (EOFException e) {
            System.out.println("\nFim dos registros\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }



    public static  void ShowTypes()
    {
        Scanner in = new Scanner(System.in);
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("tiposdose.dat")))) {
            System.out.println("Cidades");
            while (true) {
                TiposDose tP = (TiposDose) input.readObject();
                System.out.println(tP.TiposDose);
            }
        } catch (EOFException e) {
            System.out.println("\nFim dos registros\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }

}
