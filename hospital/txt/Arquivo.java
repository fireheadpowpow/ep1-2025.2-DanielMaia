package hospital.txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import hospital.classes.Medico;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


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
                for (int j = 8; j < 19; j++) {
                    if (i == 0 && j == 8) {
                        linhaAgenda.append("ID: Segunda - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j < 10) {
                        linhaAgenda.append("Segunda - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j < 12) {
                        linhaAgenda.append("Segunda - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0) {
                        linhaAgenda.append("Segunda - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j == 8) {
                        linhaAgenda.append("ID: Terça - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j < 10) {
                        linhaAgenda.append("Terça - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j < 12) {
                        linhaAgenda.append("Terça - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1) {
                        linhaAgenda.append("Terça - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j == 8) {
                        linhaAgenda.append("ID: Quarta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j < 10) {
                        linhaAgenda.append("Quarta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j < 12) {
                        linhaAgenda.append("Quarta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2) {
                        linhaAgenda.append("Quarta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j == 8) {
                        linhaAgenda.append("ID: Quinta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j < 10) {
                        linhaAgenda.append("Quinta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j < 12) {
                        linhaAgenda.append("Quinta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3) {
                        linhaAgenda.append("Quinta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j == 8) {
                        linhaAgenda.append("ID: Sexta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j < 10) {
                        linhaAgenda.append("Sexta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j < 12) {
                        linhaAgenda.append("Sexta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4) {
                        linhaAgenda.append("Sexta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j == 8){
                        linhaAgenda.append("ID: Sábado - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j < 10) {
                        linhaAgenda.append("Sábado - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j < 12) {
                        linhaAgenda.append("Sábado - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5) {
                        linhaAgenda.append("Sábado - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (j == 8) {
                        linhaAgenda.append("ID: Domingo - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (j < 10) {
                        linhaAgenda.append("Domingo - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (j < 12) {
                        linhaAgenda.append("Domingo - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else{
                        linhaAgenda.append("Domingo - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    }
                    if(i == 6 && j == 18){
                        linhaAgenda.append("\n\n");
                        linhaAgenda.append("                       ----------------------------------------------------------------                         ");
                    }
                }
                writer.write(linhaAgenda.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar a agenda: " + e.getMessage());
        }

    }


    public static void lerArquivoScanner(String dias, String especialidade_ou_medico) {

        List<String> diasLista = new ArrayList<>(Arrays.asList(dias.split(", ")));
        List<String> especialidadeLista = new ArrayList<>(Arrays.asList(especialidade_ou_medico.split(", ")));

        for (String dia : diasLista) {
            for (String especialidade : especialidadeLista) {

                String diaFormatado = formatarPrimeiraLetraMaiuscula(dia);
                String especialidadeFormatada = formatarPrimeiraLetraMaiuscula(especialidade);

                try {
                    File arquivo = new File("medicos.txt");
                    Scanner leitor = new Scanner(arquivo);

                    System.out.println("---- BUSCANDO POR: " + especialidadeFormatada + " em " + diaFormatado + " ----");


                    StringBuilder blocoMedico = new StringBuilder();
                    boolean buscandoEspecialidadeNaLinhaSeguinte = false;
                    boolean diaDisponivel = false;
                    boolean encontrado = false;


                    while (leitor.hasNextLine()) {
                        String linha = leitor.nextLine();


                        if (linha.startsWith("INFORMAÇÕES")) {

                            blocoMedico.setLength(0);
                            blocoMedico.append(linha).append("\n");
                            buscandoEspecialidadeNaLinhaSeguinte = true;
                            continue;
                        }


                        if (buscandoEspecialidadeNaLinhaSeguinte) {


                            if (linha.contains("|Especialidade: ") && linha.contains(especialidadeFormatada)) {


                                encontrado = true;

                                blocoMedico.append(linha).append("\n");


                                buscandoEspecialidadeNaLinhaSeguinte = false;
                                continue;
                            } else {

                                buscandoEspecialidadeNaLinhaSeguinte = false;
                                continue;
                            }
                        }


                        if (encontrado && linha.startsWith("ID:") && linha.contains(diaFormatado)) {


                            blocoMedico.append(linha).append("\n");
                            diaDisponivel = true;


                            break;
                        }


                        if (encontrado && !linha.startsWith("ID:")) {
                            blocoMedico.append(linha).append("\n");
                        }

                    }


                    if (encontrado && diaDisponivel) {
                        System.out.println("\n--- INFORMAÇÕES DO MÉDICO ENCONTRADO ---");
                        System.out.println(blocoMedico.toString());
                    } else {
                        System.out.println("Nenhum médico encontrado com a especialidade/dia: " + especialidadeFormatada + " em " + diaFormatado);
                    }

                    leitor.close();

                } catch (FileNotFoundException e) {
                    System.out.println("Erro: Arquivo 'medicos.txt' não encontrado.");
                }
            }
        }
    }


    private static String formatarPrimeiraLetraMaiuscula(String s) {
        if (s == null || s.isBlank() || s.length() == 0) {
            return "";
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}




