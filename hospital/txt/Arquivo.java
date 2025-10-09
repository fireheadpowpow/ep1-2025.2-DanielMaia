package hospital.txt;

import java.io.*;

import hospital.classes.Medico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        LocalDate dataInicial = LocalDate.of(2025, 10, 06); // Segunda 20/01/2025
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {

            for (int i = 0; i < 7; i++) {
                StringBuilder linhaAgenda = new StringBuilder();
                for (int j = 8; j < 19; j++) {
                    if (i == 0 && j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Segunda - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Segunda - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0 && j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Segunda - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 0) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Segunda - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Terça - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Terça - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1 && j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Terça - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 1) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Terça - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Quarta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Quarta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2 && j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Quarta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 2) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Quarta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Quinta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Quinta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3 && j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Quinta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 3) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Quinta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Sexta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Sexta - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4 && j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Sexta - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 4) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Sexta - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Sábado - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Sábado - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5 && j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Sábado - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (i == 5) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Sábado - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    } else if (j == 8) {
                        linhaAgenda.append("ID: " + dataInicial.plusDays(i).format(formato) + " - Domingo - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (j < 10) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Domingo - 0" + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else if (j < 12) {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Domingo - " + j + "am: ").append(agenda[i][j]).append(" | ");
                    } else {
                        linhaAgenda.append(dataInicial.plusDays(i).format(formato) + " - Domingo - " + j + "pm: ").append(agenda[i][j]).append(" | ");
                    }
                    if (i == 6 && j == 18) {
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


        int totalMedicosEncontradosGeral = 0;

        for (String dia : diasLista) {
            for (String termoBusca : especialidadeLista) {

                String diaFormatado = formatarPrimeiraLetraMaiuscula(dia);
                String termoFormatado = formatarPrimeiraLetraMaiuscula(termoBusca);


                int medicosEncontradosNaBuscaAtual = 0;

                System.out.println("\n---- BUSCANDO POR: " + termoFormatado + " em " + diaFormatado + " ----");

                try {
                    File arquivo = new File("medicos.txt");
                    Scanner leitor = new Scanner(arquivo);

                    StringBuilder blocoParaImprimir = new StringBuilder();
                    boolean dentroDoBlocoMedico = false;
                    boolean especialidadeEncontrada = false;
                    boolean diaEncontrado = false;

                    while (leitor.hasNextLine()) {
                        String linha = leitor.nextLine();


                        if (linha.startsWith("INFORMAÇÕES")) {


                            if (especialidadeEncontrada && diaEncontrado) {
                                medicosEncontradosNaBuscaAtual++;
                                totalMedicosEncontradosGeral++;
                                System.out.println("\n--- MÉDICO ENCONTRADO (" + medicosEncontradosNaBuscaAtual + ") ---");
                                System.out.println(blocoParaImprimir.toString());
                            }


                            blocoParaImprimir.setLength(0);
                            blocoParaImprimir.append(linha).append("\n");
                            dentroDoBlocoMedico = true;
                            especialidadeEncontrada = false;
                            diaEncontrado = false;
                            continue;
                        }


                        if (dentroDoBlocoMedico) {


                            if (linha.contains("|Especialidade: ") && linha.contains(termoFormatado)) {
                                especialidadeEncontrada = true;
                                blocoParaImprimir.append(linha).append("\n");
                                continue;
                            }


                            if (especialidadeEncontrada) {

                                if (linha.startsWith("ID:") && linha.contains(diaFormatado)) {
                                    diaEncontrado = true;
                                    blocoParaImprimir.append(linha).append("\n");


                                    dentroDoBlocoMedico = false;
                                }
                            }
                        }
                    }


                    if (especialidadeEncontrada && diaEncontrado) {
                        medicosEncontradosNaBuscaAtual++;
                        totalMedicosEncontradosGeral++;
                        System.out.println("\n--- MÉDICO ENCONTRADO (" + medicosEncontradosNaBuscaAtual + ") ---");
                        System.out.println(blocoParaImprimir.toString());
                    }

                    leitor.close();


                    if (medicosEncontradosNaBuscaAtual == 0) {
                        System.out.println("Nenhum médico encontrado com a especialidade/dia: " + termoFormatado + " em " + diaFormatado);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Erro: Arquivo 'medicos.txt' não encontrado.");
                }
            }
        }
    }


    public static List<String> buscarMedicosPorDiaEEspecialidade(String dias, String especialidadeOuMedico) {
        List<String> medicosEncontrados = new ArrayList<>();


        List<String> diasLista = new ArrayList<>(Arrays.asList(dias.split(", ")));
        List<String> especialidadeLista = new ArrayList<>(Arrays.asList(especialidadeOuMedico.split(", ")));

        for (String dia : diasLista) {
            for (String especialidade : especialidadeLista) {

                String diaFormatado = formatarPrimeiraLetraMaiuscula(dia);
                String especialidadeFormatada = formatarPrimeiraLetraMaiuscula(especialidade);

                try (Scanner leitor = new Scanner(new File("medicos.txt"))) {

                    boolean medicoEncontrado = false;
                    String nomeMedico = "";
                    String sala = "";
                    String crm = "";
                    String especialidadeMedico = "";

                    while (leitor.hasNextLine()) {
                        String linha = leitor.nextLine();


                        if (linha.contains("|Medico: ")) {


                            String[] partes = linha.split("\\|");
                            for (String parte : partes) {
                                parte = parte.trim();
                                if (parte.startsWith("Medico:")) {
                                    nomeMedico = parte.replace("Medico:", "").trim();
                                } else if (parte.startsWith("Especialidade:")) {
                                    especialidadeMedico = parte.replace("Especialidade:", "").trim();
                                } else if (parte.startsWith("Sala:")) {
                                    sala = parte.replace("Sala:", "").trim();
                                } else if (parte.startsWith("CRM:")) {
                                    crm = parte.replace("CRM:", "").trim();
                                }
                            }


                            medicoEncontrado = especialidadeMedico.contains(especialidadeFormatada)
                                    || nomeMedico.contains(especialidadeFormatada);
                        }


                        if (medicoEncontrado && linha.contains("ID:") && linha.contains(diaFormatado)) {
                            String resumo = "Medico: " + nomeMedico +
                                    " | Especialidade: " + especialidadeMedico +
                                    " | Sala: " + sala +
                                    " | CRM: " + crm +
                                    "\n-------------------------------\n";

                            medicosEncontrados.add(resumo);
                            medicoEncontrado = false;
                        }
                    }

                    if (medicosEncontrados.isEmpty()) {
                        System.out.println("Nenhum médico encontrado com a especialidade/dia: " + especialidadeFormatada + " em " + diaFormatado);
                    }

                } catch (FileNotFoundException e) {
                    System.err.println("Erro: Arquivo 'medicos.txt' não encontrado.");
                }
            }
        }

        return medicosEncontrados;
    }


    public static String formatarPrimeiraLetraMaiuscula(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        String[] palavras = texto.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            if (palavra.length() > 0) {

                String primeiraLetra = palavra.substring(0, 1).toUpperCase();

                String restante = palavra.substring(1);

                resultado.append(primeiraLetra).append(restante).append(" ");
            }
        }


        return resultado.toString().trim();
    }


    public static boolean verificarEAtualizar(String nomeMedico, String dia, String horario, String data) {
        File arquivo = new File("medicos.txt");


        String diaFormatado = formatarPrimeiraLetraMaiuscula(dia);
        String nomeMedicoFormatado = formatarPrimeiraLetraMaiuscula(nomeMedico);

        String horarioFormatado = horario.toLowerCase().replace(" ", "");
        if (!horarioFormatado.endsWith("am") && !horarioFormatado.endsWith("pm")) {
            horarioFormatado += "am";
        }

        String linhaAgendaBusca = "ID: " + data + " - " + diaFormatado + " ";
        String chaveDisponivel = horarioFormatado + ": Disponível";
        String chaveOcupado = horarioFormatado + ": Ocupado";
        String chaveSubstituicao = horarioFormatado + ": Ocupado";

        boolean deuCerto = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            StringBuilder conteudoNovo = new StringBuilder();
            String linha;
            boolean atualizado = false;
            boolean dentroDoBlocoDoMedicoCorreto = false;

            while ((linha = reader.readLine()) != null) {

                if (linha.contains("|Medico: " + nomeMedicoFormatado + " ")) {
                    dentroDoBlocoDoMedicoCorreto = true;
                }


                if (dentroDoBlocoDoMedicoCorreto && linha.contains("|Medico: ") && !linha.contains(nomeMedicoFormatado)) {
                    dentroDoBlocoDoMedicoCorreto = false;
                }

                if (dentroDoBlocoDoMedicoCorreto && linha.contains(linhaAgendaBusca)) {
                    if (linha.contains(chaveDisponivel)) {
                        linha = linha.replace(chaveDisponivel, chaveSubstituicao);
                        atualizado = true;
                        deuCerto = true;
                        System.out.println("✅ Consulta agendada com sucesso para " + data + " às " + horarioFormatado + " com o médico(a) " + nomeMedicoFormatado + ".");
                    } else if (linha.contains(chaveOcupado)) {
                        System.out.println("❌ Esse horário (" + horarioFormatado + ") já está ocupado com o médico(a) " + nomeMedicoFormatado + "!");
                    }
                }

                conteudoNovo.append(linha).append("\n");
            }

            reader.close();

            if (atualizado) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                    writer.write(conteudoNovo.toString());
                }
                System.out.println("Agenda do médico atualizada.");
            } else if (!deuCerto) {
                System.out.println("❌ Não foi possível agendar. Médico(a) " + nomeMedicoFormatado + " não encontrado, ou dia/horário não disponível/inexistente.");
            }

        } catch (IOException e) {
            System.out.println("❌ Erro ao ler ou atualizar o arquivo: " + e.getMessage());
        }
        return deuCerto;
    }


    public static void fecharAgendaInterativa(Scanner scanner, String nomeMedicoLogado) {
        File arquivo = new File("medicos.txt");
        boolean houveAtualizacao = false;
        String nomeMedicoLogadoFormatado = formatarPrimeiraLetraMaiuscula(nomeMedicoLogado);

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            StringBuilder conteudoNovo = new StringBuilder();
            String linha;
            boolean dentroDoBlocoDoMedico = false;

            while ((linha = reader.readLine()) != null) {
                String linhaModificada = linha;


                if (linha.contains("|Medico: ")) {
                    dentroDoBlocoDoMedico = linha.contains(nomeMedicoLogadoFormatado);
                }


                if (dentroDoBlocoDoMedico &&
                        (linhaModificada.contains(": Ocupado") || linhaModificada.contains(": Agendada"))) {

                    linhaModificada = processarSlotsOcupadosNaLinha(linhaModificada, scanner, nomeMedicoLogadoFormatado);

                    if (!linhaModificada.equals(linha)) {
                        houveAtualizacao = true;
                    }
                }

                conteudoNovo.append(linhaModificada).append("\n");
            }

            if (houveAtualizacao) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                    writer.write(conteudoNovo.toString());
                    System.out.println("\n✅ Agenda de " + nomeMedicoLogadoFormatado + " finalizada e atualizada com sucesso.");
                }
            } else {
                System.out.println("\n⚠️ Nenhuma consulta pendente encontrada para " + nomeMedicoLogadoFormatado + ".");
            }

        } catch (IOException e) {
            System.err.println("❌ Erro ao processar o arquivo: " + e.getMessage());
        }
    }


    private static String processarSlotsOcupadosNaLinha(String linha, Scanner scanner, String nomeMedicoLogadoFormatado) {
        String[] slots = linha.split(" \\| ");
        StringBuilder novaLinha = new StringBuilder();


        for (String slot : slots) {
            boolean estaPendente = slot.contains(": Ocupado") || slot.contains(": Agendada");
            boolean jaEstaFechado = slot.contains("(Concluído)") || slot.contains("(Cancelado)");

            if (estaPendente && !jaEstaFechado) {
                String estadoAtual;
                if (slot.contains(": Ocupado")) {
                    estadoAtual = slot.contains("(Pendente)") ? ": Ocupado (Pendente)" : ": Ocupado";
                } else {
                    estadoAtual = ": Agendada";
                }

                String identificadorSlot = slot.substring(0, slot.indexOf(estadoAtual));

                System.out.println("\n--- ENCONTRADO PENDENTE (" + estadoAtual.replace(": ", "") + ") ---");
                System.out.println("Médico: " + nomeMedicoLogadoFormatado);
                System.out.println("Slot: " + identificadorSlot);
                System.out.print("[1] Concluído | [2] Cancelado | [3] Manter Pendente: ");
                String escolha = scanner.nextLine().trim();

                String novoEstado = estadoAtual.replace(": ", "");

                if (escolha.equals("1")) {
                    novoEstado = novoEstado + " (Concluído)";


                    System.out.print("🩺 Digite o diagnóstico (caso não tenha deixe em branco e caso direcionado a internação digite 'internado'): ");
                    String diagnostico = scanner.nextLine().trim();
                    if (diagnostico.isEmpty()) {
                        diagnostico = "Não foi possível diagnosticar o caso";
                    }

                    System.out.print("💊 Digite a prescrição do medicamento (caso não tenha deixe em branco): ");
                    String prescricao = scanner.nextLine().trim();
                    if (prescricao.isEmpty()) {
                        prescricao = "Sem medicamento prescrito";
                    }


                    novoEstado += " | Diagnóstico: " + diagnostico + " | Prescrição: " + prescricao;

                } else if (escolha.equals("2")) {
                    novoEstado = novoEstado + " (Cancelado)";
                }

                slot = slot.replace(estadoAtual, ": " + novoEstado);
                System.out.println("Status atualizado para: " + novoEstado);
            }

            if (novaLinha.length() > 0 && !novaLinha.toString().endsWith("|")) {
                novaLinha.append(" | ");
            }
            novaLinha.append(slot);
        }

        return novaLinha.toString();
    }





}










