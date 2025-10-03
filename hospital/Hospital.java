package hospital;

import java.util.Scanner;
import hospital.classes.Paciente;
import hospital.classes.Medico;
import hospital.classes.Paciente_Especial;
import hospital.txt.Arquivo;

public class Hospital {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
        System.out.println("Seja Bem-Vindo ao Hospital Java!");
        System.out.print("Digite 1 se gostaria de Realizar seu Cadastro | 2 se já Possui Cadastro no nosso Sistema | 3 se deseja Encerrar o atendimento: ");


        int opcao0 = scanner.nextInt();
        scanner.nextLine();
            switch (opcao0) {
                case 1:
                    continuar = false;


                    while (!continuar){
                    System.out.println("Paciente Comum - Sem prioridade e sem Plano de saúde; Paciente Especial - Com prioridade e/ou plano de saúde");
                    System.out.print("Digite --> 1 para Paciente Comum ||| 2 para Paciente Especial ||| 3 para cadastrar como Médico: ");


                    int opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao) {
                        case 1:
                             continuar = true;
                            while(continuar) {

                             Paciente paciente = null;

                                do {

                                    System.out.print("Escreva seu Nome Completo: ");
                                    String nome_comum = scanner.nextLine();
                                    System.out.print("Escreva seu CPF no formato --> XXX.XXX.XXX-XX: ");
                                    String cpf_comum = scanner.nextLine();
                                    System.out.print("Digite sua Idade: ");
                                    int idade_comum = scanner.nextInt();
                                    scanner.nextLine();



                                    paciente = new Paciente(nome_comum, cpf_comum, idade_comum);
                                }while(paciente.getNome().isEmpty() || paciente.getCpf().isEmpty() || paciente.getIdade() <= 0);


                                    String dadosPaciente = "Paciente comum: " + paciente.getNome() +
                                            " | CPF: " + paciente.getCpf() +
                                            " | Idade: " + paciente.getIdade();
                                    Arquivo.salvar("pacientes.txt", dadosPaciente);

                                    System.out.println("Paciente comum cadastrado com sucesso!!");

                                continuar = false;


                            while(!continuar) {
                                System.out.println("Deseja agendar agora sua Consulta?");
                                System.out.print("1 - Sim ; 2 - Não: ");

                                int opcao2 = scanner.nextInt();
                                scanner.nextLine();
                                switch (opcao2) {
                                    case 1:
                                        continuar = true;
                                        while (continuar) {
                                            System.out.println("Você deseja agendar consulta com algum médico específico?");
                                            System.out.print("1 - Sim ; 2 - Não: ");
                                            int opcao3 = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (opcao3) {
                                                case 1:
                                                    continuar = false;
                                                    while (!continuar) {
                                                        System.out.print("Digite o nome do médico: ");
                                                        String nome_do_medico = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_do_medico);
                                                        System.out.println("Para qual semana você gostaria de tentar agendar com este médico?");
                                                        System.out.println("Digite o Mês e depois o número da Semana, exemplo: '1 - Agosto'");
                                                        System.out.print("Digite aqui o nome do Mês: ");
                                                        String mes = scanner.nextLine();
                                                        System.out.print("Digite aqui o número da Semana: ");
                                                        int semana = scanner.nextInt();
                                                        continuar = true;

                                                        break;
                                                    }
                                                case 2:
                                                    continuar = false;
                                                    System.out.print("Quais dias você estaria disponível para realizar a consulta? ");
                                                    break;
                                                default:
                                                    System.out.println("Opção Inválida!!");
                                                    break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Muito Obrigado por Escolher o Hospital Java, volte sempre!!");
                                        continuar = true;
                                        break;
                                    default:
                                        System.out.println("Opção Inválida!!");
                                        break;
                                }
                            }

                                    break;
                            }
                        case 2:
                            continuar = true;
                            while(continuar) {
                                System.out.print("Escreva seu Nome Completo: ");
                                String nome_especial = scanner.nextLine();
                                System.out.print("Escreva seu CPF no formato --> XXX.XXX.XXX-XX: ");
                                String cpf_especial = scanner.nextLine();
                                System.out.print("Digite sua Idade: ");
                                int idade_especial = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("(Apenas digite um '.' caso não possua) Informe seu Plano de Saúde: ");
                                String plano_de_saude_especial = scanner.nextLine();
                                System.out.print("(Apenas digite um '.' caso não possua) Informe seu tipo de Prioridade: ");
                                String tipo_de_prioridade_especial = scanner.nextLine();

                                Paciente_Especial paciente_especial = new Paciente_Especial(nome_especial, cpf_especial, idade_especial, plano_de_saude_especial, tipo_de_prioridade_especial);

                                String dadosPacienteEspecial = "Paciente especial: " + paciente_especial.getNome() +
                                        " | CPF: " + paciente_especial.getCpf() +
                                        " | Idade: " + paciente_especial.getIdade() +
                                        " | Plano: " + paciente_especial.getPlanoDeSaude() +
                                        " | Prioridade: " + paciente_especial.getTipodeprioridade();
                                Arquivo.salvar("pacientes_especiais.txt", dadosPacienteEspecial);

                                System.out.println("Paciente especial cadastrado com sucesso!!");
                                continuar = false;

                                break;
                            }
                        case 3:
                            continuar = true;
                            while(continuar) {
                                System.out.print("Escreva seu Nome completo: ");
                                String nome_medico = scanner.nextLine();
                                System.out.print("Digite aqui seu CRM: ");
                                int crm = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Escreva sua ou suas especialidades(Dermatologia, pediatria...): ");
                                String especialidade = scanner.nextLine();
                                System.out.print("Escreva o preço (numérico) que você cobra por consulta: ");
                                double custo_da_consulta = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Preencha os horários com 'Disponível' - Apto para Consulta ou 'Ocupado' - Horário não disponível");
                                System.out.println("Digite aqui como é sua agenda de horários: ");
                                String[][] agenda_de_horarios = new String[7][24];
                                for (int i = 0; i < 7; i++) {
                                    for (int j = 0; j < 24; j++) {
                                        if (i == 0) {
                                            System.out.println("Segunda");
                                        } else if (i == 1) {
                                            System.out.println("Terça");
                                        } else if (i == 2) {
                                            System.out.println("Quarta");
                                        } else if (i == 3) {
                                            System.out.println("Quinta");
                                        } else if (i == 4) {
                                            System.out.println("Sexta");
                                        } else if (i == 5) {
                                            System.out.println("Sábado");
                                        } else {
                                            System.out.println("Domingo");
                                        }
                                        if (j < 10) {
                                            System.out.print("0" + j + "am: ");
                                        } else if (j > 9 && j < 12) {
                                            System.out.print(j + "am: ");
                                        } else {
                                            System.out.print(j + "pm: ");
                                        }
                                        agenda_de_horarios[i][j] = scanner.nextLine();

                                    }
                                }

                                Medico Medico = new Medico(nome_medico, crm, especialidade, custo_da_consulta, agenda_de_horarios);

                                String dadosMedico = "Medico: " + Medico.getNome() +
                                        " | CRM: " + Medico.getCrm() +
                                        " | Especialidade: " + Medico.getEspecialidade() +
                                        " | Custo da Consulta: " + Medico.getCusto_da_consulta() +
                                        " | ↓↓ Agenda de horários do: " + Medico.getNome() + "  ↓↓\n";
                                Arquivo.salvar("medicos.txt", dadosMedico);

                                Arquivo.salvarAgenda("medicos.txt", Medico.getAgenda_de_horarios());
                                continuar = false;


                                break;
                            }

                        default:
                            System.out.println("Opção Inválida!!");
                            break;
                    }
                    }
                case 2:
                    continuar = false;
                    break;
                case 3:
                    System.out.println("Muito Obrigado por Escolher o Hospital Java, volte sempre!!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }
            }
            scanner.close();
        }
    }













