package com.company;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;

public class ShowFunctions {
    // INICIO DO PROGRAMA SHOWALL, RESPONSÁVEL POR MOSTRAR TUDO O QUE TEM CADASTRADO NO "dosesApli.dat"
    public static  void  ShowAll()
    {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("dosesApli.dat")))) {
            System.out.println("Cidades,TiposDeDose,DosesAplicadas");
            while (true) {
                DosesAplicadas dosesApl = (DosesAplicadas) input.readObject();
                System.out.println(dosesApl.Cidade + "," + dosesApl.TiposDeDose + "," + dosesApl.DosesAplicadas);
            }
        } catch (EOFException e) {
            System.out.println("\nFim dos registros");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
    // FIM DO PROGRAMA SHOWALL


    public static  void ShowCitys()
    {
        List<String> citys = new ArrayList<String>();
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("cidades.dat")))) {
            System.out.println("Cidades");
            while (true) {
                Cidade cT = (Cidade) input.readObject();
                citys.add(cT.cidade);
                Collections.sort(citys);



            }

        } catch (EOFException e) {
            for(int i = 0; i < citys.size(); i++)
            {
                System.out.println(citys.get(i));
            }
            System.out.println("\nFim dos registros\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }



    public static  void ShowTypes()
    {
        List<String> types = new ArrayList<String>();
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("tiposdose.dat")))) {
            System.out.println("Doses");
            while (true) {
                TiposDose tP = (TiposDose) input.readObject();
                types.add(tP.TiposDose);
                Collections.sort(types);


            }

        } catch (EOFException e) {
            for(int i = 0; i < types.size(); i++)
            {
                System.out.println(types.get(i));
            }
            System.out.println("\nFim dos registros\n");

        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }

    }




}
