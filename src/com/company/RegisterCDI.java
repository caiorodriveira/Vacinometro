package com.company;

import java.io.*;
import java.nio.file.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterCDI implements Serializable  {




    public  void  ShowCity()
    {
        Scanner in = new Scanner(System.in);
        initUrl getUrl = new initUrl();
        String urlNew = getUrl.SearchUrlDosesAplicadas();
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("dosesApli.dat")))) {
            while (true) {

                DosesAplicadas dosesApl = (DosesAplicadas) input.readObject();
                System.out.println(dosesApl.Cidade + " " + dosesApl.TiposDeDose + " " + dosesApl.DosesAplicadas);

            }
        } catch (EOFException e) {
            System.out.println("Fim dos registros");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }



    }

    public   void RegisterCTD() {
        // write your code here

        DosesAplicadas dosesApl = new DosesAplicadas();
        initUrl getUrl = new initUrl();
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Digite o nome da cidade");
            dosesApl.Cidade = in.nextLine();
            System.out.println("Digite o tipo de dose");
            dosesApl.TiposDeDose = in.nextLine();
            System.out.println("Digite a quantidade de doses");
            dosesApl.DosesAplicadas = in.nextInt();
            Path path = Paths.get("dosesApli.dat");
            if (Files.exists(path)) {

                try (FileOutputStream fosMainCad = new FileOutputStream("dosesApli.dat", true);
                     AppendingObjectOutputStream outputCidade = new AppendingObjectOutputStream(fosMainCad)) {
                    outputCidade.writeObject(dosesApl);
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo dosesApli.data");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo dosesApli.dat");
                }
            } else {
                try (ObjectOutputStream outputCidade = new ObjectOutputStream(Files.newOutputStream(path))) {
                    outputCidade.writeObject(dosesApl);
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo");
                }
            }
        }
        catch (InvalidPathException e) {
            System.out.println("Nao foi possivel encontrar o arquivo conta.dat!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada de dados!");
        }
    }
}

