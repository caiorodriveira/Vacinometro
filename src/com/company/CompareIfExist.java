package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompareIfExist {

    public static boolean CityExist(String cidade) {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("cidades.dat")))) {
            while (true) {
                Cidade city = (Cidade) input.readObject();
                if (city.cidade.equalsIgnoreCase(cidade)) {
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
        return false;
    }


    public static boolean TypeExist(String TiposDose) {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("tiposdose.dat")))) {
            while (true) {
                TiposDose type = (TiposDose) input.readObject();
                if (type.TiposDose.equalsIgnoreCase(TiposDose)) {
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
        return false;
    }
}