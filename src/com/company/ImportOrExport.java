package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImportOrExport {

    public static void ImportCSV() {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("dosesApli.dat")));
             BufferedReader br = new BufferedReader(new FileReader("vacinometro.csv"))) {
            br.readLine(); // cabeçalho do arquivo CSV
            while (br.ready()) {
                String[] linha = br.readLine().split(";");
                DosesAplicadas all = new DosesAplicadas();
                all.Cidade = linha[0];
                all.TiposDeDose = linha[1];
                all.DosesAplicadas = Integer.parseInt(linha[2]);
                output.writeObject(all);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato de dados");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }

    public static void ExportCSV() {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("dosesApli.dat")));
             BufferedWriter bw = new BufferedWriter(new FileWriter("vacinometro.csv"))) {
            bw.write("Municio;Doses;Total Doses Aplicadas"); // cabeçalho do arquivo CSV
            bw.newLine();
            while (true) {
                DosesAplicadas all = (DosesAplicadas) input.readObject();
                bw.write(String.format("%s;%s;%d", all.Cidade,all.TiposDeDose,all.DosesAplicadas));
                bw.newLine();
            }
        } catch (EOFException e) {
            System.out.println("Fim dos registros");
        } catch (ClassNotFoundException e) {
            System.out.println("Tipo de objeto invalido!");
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }

}
