package hospital.classes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import hospital.classes.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Internacao {
    private String pacienteNomeCompleto;
    private String medicoResponsavel;
    private String dataDeEntrada;
    private String dataDeSaida;
    private String quarto;
    private double custoDaInternacao;
    private boolean pacienteEspecial;


    public Internacao(String pacienteNomeCompleto, String medicoResponsavel, String dataDeEntrada, String quarto, boolean pacienteEspecial) {
        this.pacienteNomeCompleto = pacienteNomeCompleto;
        this.medicoResponsavel = medicoResponsavel;
        this.dataDeEntrada = dataDeEntrada;
        this.quarto = quarto;
        this.pacienteEspecial = pacienteEspecial;
        this.dataDeSaida = "";


        if (pacienteEspecial) {
            this.custoDaInternacao = 100.00;
        } else {
            this.custoDaInternacao = 200.00;
        }
    }


    public void registrarSaida(String dataDeSaida) {
        this.dataDeSaida = dataDeSaida;

    }


    public String getPacienteNomeCompleto() { return pacienteNomeCompleto; }
    public String getMedicoResponsavel() { return medicoResponsavel; }
    public String getDataDeEntrada() { return dataDeEntrada; }
    public String getDataDeSaida() { return dataDeSaida; }
    public String getQuarto() { return quarto; }
    public double getCustoDaInternacao() { return custoDaInternacao; }
    public boolean isPacienteEspecial() { return pacienteEspecial; }


    public String getStatus() {
        return this.dataDeSaida.isBlank() ? "ATIVA" : "CONCLUIDA";
    }

    public static void registrarInternacao(Scanner scanner) {

        System.out.println("\n--- REGISTRO DE INTERNAÇÃO ---");


        System.out.print("Nome Completo do Paciente para Internação: ");
        String pacienteNome = scanner.nextLine();

        System.out.print("Nome Completo do Médico Responsável: ");
        String medicoResp = scanner.nextLine();

        System.out.print("Data de Entrada (dd/mm/aaaa): ");
        String dataEntrada = scanner.nextLine();

        System.out.print("O paciente é 'Especial' (diária R$100)? (S/N): ");
        boolean pacienteEspecial = scanner.nextLine().equalsIgnoreCase("S");


        int quartoNumero = ControleQuartos.alocarProximoQuarto();

        if (quartoNumero == 0) {
            System.out.println("❌ Erro: Todos os quartos de 200 a 400 estão ocupados no momento.");
            return;
        }

        String quarto = String.valueOf(quartoNumero);


        Internacao internacao = new Internacao(pacienteNome, medicoResp, dataEntrada, quarto, pacienteEspecial);


        String custoStr = String.format("%.2f", internacao.getCustoDaInternacao());
        String dadosInternacao = "INFORMAÇÕES DE INTERNAÇÃO\n"
                + "| Paciente: " + internacao.getPacienteNomeCompleto()
                + " | Médico Resp.: " + internacao.getMedicoResponsavel()
                + " | Data Entrada: " + internacao.getDataDeEntrada()
                + " | Data Saída: " + internacao.getDataDeSaida()
                + " | Quarto: " + internacao.getQuarto()
                + " | Custo Diária: R$" + custoStr
                + " | Status: " + internacao.getStatus()
                + " | Especial: " + (internacao.isPacienteEspecial() ? "Sim" : "Nao") + "\n";


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("internacoes.txt", true))) {
            writer.write(dadosInternacao);
            writer.write("----------------------------\n");
        } catch (IOException e) {
            System.err.println("❌ Erro ao salvar registro de internação: " + e.getMessage());
            ControleQuartos.liberarQuarto(quartoNumero);
            return;
        }

        System.out.println("\n✅ Internação registrada com sucesso!");
        System.out.println("Quarto alocado: " + internacao.getQuarto());
        System.out.println("Custo diário aplicado: R$" + custoStr);
    }

    public class ControleQuartos {

        private static final int INICIO_QUARTO = 200;
        private static final int FIM_QUARTO = 400;


        private static Set<Integer> quartosOcupados = inicializarQuartos();


        private static Set<Integer> inicializarQuartos() {
            Set<Integer> ocupados = new HashSet<>();
            File arquivo = new File("internacoes.txt");

            try (Scanner leitor = new Scanner(arquivo)) {
                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();


                    if (linha.contains("| Quarto: ") && linha.contains("| Status: ATIVA")) {


                        int inicio = linha.indexOf("| Quarto: ") + "| Quarto: ".length();
                        int fim = linha.indexOf("|", inicio);
                        if (fim == -1) {
                            fim = linha.indexOf("\n", inicio);
                            if (fim == -1) fim = linha.length();
                        }

                        String quartoStr = linha.substring(inicio, fim).trim();

                        try {
                            int quartoAtual = Integer.parseInt(quartoStr);

                            if (quartoAtual >= INICIO_QUARTO && quartoAtual <= FIM_QUARTO) {
                                ocupados.add(quartoAtual);
                            }
                        } catch (NumberFormatException e) {

                        }
                    }
                }
            } catch (FileNotFoundException e) {

            }
            return ocupados;
        }



        public static int alocarProximoQuarto() {

            for (int quarto = INICIO_QUARTO; quarto <= FIM_QUARTO; quarto++) {
                if (!quartosOcupados.contains(quarto)) {
                    quartosOcupados.add(quarto);
                    return quarto;
                }
            }
            return 0;
        }


        public static void liberarQuarto(int numeroQuarto) {
            quartosOcupados.remove(numeroQuarto);
        }


        public static boolean estaOcupado(int numeroQuarto) {
            return quartosOcupados.contains(numeroQuarto);
        }
    }
    public static boolean cancelarInternacao(String nomePaciente, String quarto, String dataCancelamento) {
        File arquivo = new File("internacoes.txt");
        StringBuilder conteudoNovo = new StringBuilder();
        boolean canceladoComSucesso = false;
        String statusAntigo = "| Status: ATIVA";
        String statusNovo = "| Status: CANCELADA";
        String dataSaidaAntiga = "| Data Saída: ";
        String dataSaidaNova = "| Data Saída: " + dataCancelamento;
        String separador = "----------------------------";


        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {


                if (linha.contains(nomePaciente) && linha.contains("| Quarto: " + quarto) && linha.contains(statusAntigo)) {

                    canceladoComSucesso = true;

                    conteudoNovo.append(linha).append("\n");


                    linha = reader.readLine();
                    conteudoNovo.append(linha).append("\n");


                    linha = reader.readLine();
                    conteudoNovo.append(linha).append("\n");


                    linha = reader.readLine();


                    if (linha.contains(dataSaidaAntiga)) {
                        linha = linha.replace(dataSaidaAntiga, dataSaidaNova);
                    }
                    conteudoNovo.append(linha).append("\n");


                    linha = reader.readLine();


                    if (linha.contains(statusAntigo)) {
                        linha = linha.replace(statusAntigo, statusNovo);
                    }
                    conteudoNovo.append(linha).append("\n");


                    linha = reader.readLine();
                    conteudoNovo.append(linha).append("\n");


                    try {
                        ControleQuartos.liberarQuarto(Integer.parseInt(quarto));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter número do quarto para liberação.");
                    }

                    continue;
                }


                conteudoNovo.append(linha).append("\n");
            }

        } catch (IOException e) {
            System.err.println("❌ Erro ao ler o arquivo de internações: " + e.getMessage());
            return false;
        }

        if (canceladoComSucesso) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                writer.write(conteudoNovo.toString());
            } catch (IOException e) {
                System.err.println("❌ Erro ao reescrever o arquivo de internações: " + e.getMessage());
                return false;
            }
        }

        if (canceladoComSucesso) {
            System.out.println("✅ Internação cancelada e quarto " + quarto + " liberado.");
        } else {
            System.out.println("❌ Erro: Internação ATIVA para o paciente " + nomePaciente + " no quarto " + quarto + " não encontrada.");
        }

        return canceladoComSucesso;
    }
}
