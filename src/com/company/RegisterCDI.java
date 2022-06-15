package com.company;

import java.io.*;
import java.nio.file.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterCDI implements Serializable  {

    //INICIO DO PROGRAMA CADCITY QUE É RESPONSÁVEL PELO CADASTRO DE TUDO O QUE TEM NOS ARQUIVOS "cidades.dat" && "tiposdose.dat
    public  static void CadCity()
    {
        Cidade c = new Cidade();
        TiposDose t = new TiposDose();
        CompareIfExist compare = new CompareIfExist();
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Digite o nome da cidade: ");
            c.cidade = in.nextLine();
            if (compare.CityExist(c.cidade)) {
                System.out.println("ERROR 404: JÁ EXISTE UMA CIDADE CADASTRADA COM ESSE NOME");
                return;
            }
            System.out.println("Digite o nome da dose: ");
            t.TiposDose = in.nextLine();
            if(compare.TypeExist(t.TiposDose)){
                System.out.println("ERROR 404: JÁ EXISTE UMA DOSE CADASTRADA COM ESSE NOME");
                return;
            }
            Path pathc = Paths.get("cidades.dat");
            Path patht = Paths.get("tiposdose.dat");
            if (Files.exists(pathc)) {
                try (FileOutputStream fos = new FileOutputStream("cidades.dat", true);
                     AppendingObjectOutputStream output = new AppendingObjectOutputStream(fos)) {
                    output.writeObject(c);
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo cidades.dat!");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo cidades.dat!");
                }
            } else {
                try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(pathc))) {
                    output.writeObject(c);
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo cidades.dat!");
                }
            }

            //INICIO CADASTRO DO TIPO DE DOSE
            if (Files.exists(patht)) {
                try (FileOutputStream fos = new FileOutputStream("tiposdose.dat", true);
                     AppendingObjectOutputStream output = new AppendingObjectOutputStream(fos)) {
                    output.writeObject(t);
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo tiposdose.dat!");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo tiposdose.dat!");
                }
            } else {
                try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(patht))) {
                    output.writeObject(t);
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo tiposdose.dat!");
                }
            }
            //FIM CADASTRO DO TIPO DE DOSE

        } catch (InvalidPathException e) {
            System.out.println("Nao foi possivel encontrar o arquivo um dos arquivos!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada de dados!");
        }

    }
    //FIM DO PROGRAMA"




    // INICIO DO PROGRAMA REGISTERCTD, responsável por cadastrar os dados no arquivo "dosesApli.dat"
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
            System.out.println("Nao foi possivel encontrar o arquivo dosesApli.dat!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada de dados!");
        }
    }
    // FIM DO PROGRAMA REGISTERCTD

}

