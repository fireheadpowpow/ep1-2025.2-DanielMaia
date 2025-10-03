package hospital.txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import hospital.classes.Medico;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Arquivo {

    public static void salvar(String nomeArquivo, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(conteudo);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public static void salvarAgenda(String nomeArquivo, String[][] agenda) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {

            for (int i = 0; i < 7; i++) {
                StringBuilder linhaAgenda = new StringBuilder();
                for (int j = 0; j < 24; j++) {
                    if (i == 0 && j == 0) {
                        linhaAgenda.append("ID: Segunda - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j < 10 && j > 0) {
                        linhaAgenda.append("Segunda - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j > 9 && j < 12) {
                        linhaAgenda.append("Segunda - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j > 11) {
                        linhaAgenda.append("Segunda - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j == 0) {
                        linhaAgenda.append("ID: Terça - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j < 10 && j > 0) {
                        linhaAgenda.append("Terça - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j > 9 && j < 12) {
                        linhaAgenda.append("Terça - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j > 11) {
                        linhaAgenda.append("Terça - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j == 0) {
                        linhaAgenda.append("ID: Quarta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j < 10 && j > 0) {
                        linhaAgenda.append("Quarta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j > 9 && j < 12) {
                        linhaAgenda.append("Quarta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j > 11) {
                        linhaAgenda.append("Quarta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j == 0) {
                        linhaAgenda.append("ID: Quinta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j < 10 && j > 0) {
                        linhaAgenda.append("Quinta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j > 9 && j < 12) {
                        linhaAgenda.append("Quinta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j > 11) {
                        linhaAgenda.append("Quinta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j == 0) {
                        linhaAgenda.append("ID: Sexta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j < 10 && j > 0) {
                        linhaAgenda.append("Sexta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j > 9 && j < 12) {
                        linhaAgenda.append("Sexta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j > 11) {
                        linhaAgenda.append("Sexta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j == 0) {
                        linhaAgenda.append("ID: Sábado - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j < 10 && j > 0) {
                        linhaAgenda.append("Sábado - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j > 9 && j < 12) {
                        linhaAgenda.append("Sábado - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j > 11) {
                        linhaAgenda.append("Sábado - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 6 && j == 0) {
                        linhaAgenda.append("ID: Domingo - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 6 && j < 10 && j > 0) {
                        linhaAgenda.append("Domingo - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 6 && j > 9 && j < 12) {
                        linhaAgenda.append("Domingo - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j > 11 && j < 23) {
                        linhaAgenda.append("Domingo - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 6 && j == 23) {
                        linhaAgenda.append("Domingo - " + j + "pm: ").append(agenda[i][j]).append("\n\n-----------------------------------------------------------------------------------------------------------");
                    }
                }
                writer.write(linhaAgenda.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar a agenda: " + e.getMessage());
        }

    }

    public static void lerArquivoScanner(String nome_do_medico) {
        try {
            File arquivo = new File("medicos.txt");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                // exemplo: só imprime linhas que começam com "ID:"
                if (linha.startsWith("ID: ") && linha.contains(nome_do_medico)) {
                    System.out.println(linha);
                }
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}





