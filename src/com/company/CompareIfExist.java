package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompareIfExist {

    public static  boolean CompareCityIfExist (String cidade)
    {
      //  Path path = Paths.get("cidades.dat");
        try
        {
            Path path = Paths.get("cidades.dat");
            if(Files.exists(path))
            {
                try(ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("cidades.dat")))) {
                    while (true) {
                        Cidade c = (Cidade) input.readObject();
                        if (c.cidade.equalsIgnoreCase(cidade) ) {
                            return true;
                        }
                    }
                } catch (EOFException e) {
                    return false;
                } catch (ClassNotFoundException e) {
                    System.out.println("Tipo de objeto invalido!");
                } catch (IOException e) {
                    System.out.println("Erro de leitura no arquivo");
                }
            }else
            {
                try (FileOutputStream fosMainCad = new FileOutputStream("cidades.dat", true)) {
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo cidades.dat");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo cidades.dat");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
















    public static  boolean CompareIfTypeExist (String TiposDose)
    {
        Path pathc = Paths.get("tiposdose.dat");
        try
        {
            if(Files.exists(pathc))
            {
                try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("tiposdose.dat")))) {
                    while (true) {
                        TiposDose t = (TiposDose) input.readObject();
                        if (t.TiposDose.equals(TiposDose)) {
                            return true;
                        }
                    }
                } catch (EOFException e) {
                    return false;
                } catch (ClassNotFoundException e) {
                    System.out.println("Tipo de objeto invalido!");
                } catch (IOException e) {
                    System.out.println("Erro de leitura no arquivo");
                }
            }else
            {
                try (FileOutputStream fosMainCad = new FileOutputStream("tiposdose.dat", true);) {
                } catch (FileNotFoundException e) {
                    System.out.println("Nao foi possível abrir o arquivo tiposdose.data");
                } catch (IOException e) {
                    System.out.println("Erro de escrita no arquivo tiposdose.dat");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}
