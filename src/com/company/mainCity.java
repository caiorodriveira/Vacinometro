package com.company;

import java.io.*;
import java.nio.file.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainCity  {



    public void SubMenuCityOptions()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a opção desejada: \n [1] - Mostrar Cidades\n [2] - Cadastrar cidade\n [3] - Voltar ao menu anterior");
        int opc = in.nextInt();

        switch (opc)
        {
            case 1:
                ShowCity();
                break;
            case 2:
                RegisterCTD();
                break;
            case 3:

                break;
        }
    }


    public  void  ShowCity()
    {
        Scanner in = new Scanner(System.in);
        initUrl getUrl = new initUrl();

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(getUrl.SearchUrlCidade())))) {
            while (true) {

                Cidade c =(Cidade) input.readObject();

                System.out.printf("%s \n", c.cidade);
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
        Cidade c = new Cidade();
        TiposDose t = new TiposDose();
        DosesAplicadas d = new DosesAplicadas();
        initUrl getUrl = new initUrl();
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Digite o nome da cidade");
            c.cidade = in.nextLine();
            System.out.println("Digite o tipo de dose");
            t.TiposDose = in.nextLine();
            System.out.println("Digite a quantidade de doses aplicadas");
            d.DosesAplicadas = in.nextInt();
            Path path = Paths.get(getUrl.SearchUrlCidade());
            if (Files.exists(path)) {

                try (FileOutputStream fosCidade = new FileOutputStream(getUrl.SearchUrlCidade(), true);
                     AppendingObjectOutputStream output = new AppendingObjectOutputStream(fosCidade)) {
                    output.writeObject(c);
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo "+ getUrl.SearchUrlCidade() +" !");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo "+ getUrl.SearchUrlCidade() + " !");
                }

                try (FileOutputStream fosTiposDose = new FileOutputStream(getUrl.SearchUrlTiposDeDose(), true);
                     AppendingObjectOutputStream outputCidade = new AppendingObjectOutputStream(fosTiposDose)) {
                    outputCidade.writeObject(t);
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo "+ getUrl.SearchUrlTiposDeDose() +" !");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo " + getUrl.SearchUrlTiposDeDose() + " !");
                }


                try (FileOutputStream fosDosesAplicadas = new FileOutputStream(getUrl.SearchUrlDosesAplicadas(), true);
                     AppendingObjectOutputStream outputCidade = new AppendingObjectOutputStream(fosDosesAplicadas)) {
                    outputCidade.writeObject(d);
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo "+ getUrl.SearchUrlDosesAplicadas() +" !");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo " + getUrl.SearchUrlDosesAplicadas() +" !");
                }


            } else {
                try (ObjectOutputStream outputCidade = new ObjectOutputStream(Files.newOutputStream(path))) {
                    outputCidade.writeObject(c);
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo conta.dat!");
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

//try (
//        FileWriter fw = new FileWriter(getUrl.SearchUrlCity(),true);
//        BufferedWriter bw = new BufferedWriter(fw)) {
//        String str = null;
//    while (!(str = in.nextLine()).isEmpty()) {
//        bw.write(str);
//        bw.newLine();
//    }
//} catch (IOException e) {
//    System.out.println("Erro de escrita");
//}