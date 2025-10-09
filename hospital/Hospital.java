package hospital;

import java.util.List;
import java.util.Scanner;

import hospital.classes.*;
import hospital.txt.Arquivo;

public class Hospital {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seja Muito Bem-Vindo ao Hospital Java!");
            System.out.print("Digite --> 1 - se gostaria de Realizar seu Cadastro | 2 - se já Possui Cadastro no nosso Sistema | 3 - se deseja Encerrar o atendimento: ");


            int opcao0 = scanner.nextInt();
            scanner.nextLine();
            switch (opcao0) {
                case 1:

                    boolean continuar1 = false;


                    while (!continuar1) {
                        System.out.println("Paciente Comum - Sem prioridade e sem Plano de saúde; Paciente Especial - Com prioridade(Gravidez, Obesidade, Deficiência...) e/ou plano de saúde");
                        System.out.print("Digite --> 1 - para Paciente Comum | 2 - para Paciente Especial | 3 - para cadastrar como Médico | 4 - Voltar | 5 - Encerrar Atendimento: ");


                        int opcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcao) {
                            case 1:
                                continuar1 = true;
                                boolean continuar2 = true;
                                while (continuar2) {

                                    System.out.print("Escreva seu Primeiro Nome: ");
                                    String nome_comum = scanner.nextLine();
                                    System.out.print("Escreva seu Último Sobrenome: ");
                                    String sobrenome_comum = scanner.nextLine();
                                    System.out.print("Escreva seu CPF no formato --> XXX.XXX.XXX-XX: ");
                                    String cpf_comum = scanner.nextLine();
                                    System.out.print("Digite sua Idade: ");
                                    int idade_comum = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Crie uma senha de até 8 caracteres para login posterior: ");
                                    String senha = scanner.nextLine();


                                    Paciente paciente = new Paciente(nome_comum, sobrenome_comum, cpf_comum, idade_comum, senha);


                                    if (!paciente.getNomeCompleto().isBlank() && paciente.getIdade() != 0 && !paciente.getCpf().isBlank() && !paciente.getSenhaHash().isBlank()) {
                                        String dadosPaciente = "Paciente comum: " + paciente.getNomeCompleto() +
                                                " | CPF: " + paciente.getCpf() +
                                                " | Idade: " + paciente.getIdade() +
                                                " | Login: " + paciente.getLogin() +
                                                " | Senha: " + paciente.getSenhaHash();
                                        Arquivo.salvar("pacientes.txt", dadosPaciente);

                                        System.out.println("Paciente comum cadastrado com sucesso!!");
                                        break;

                                    }


                                }
                                boolean continuar3 = false;


                                while (!continuar3) {
                                    System.out.println("AVISOS: [Nós atendemos, por meio de CONSULTAS, de Segunda a Sábado de 8 às 18] e [Agendamos consultas apenas até o fim dessa semana]");
                                    System.out.println("Deseja agendar agora sua Consulta?");
                                    System.out.print("Digite --> 1 - Sim | 2 - Não | 3 - Voltar | 4 - Encerrar Atendimento: ");

                                    int opcao2 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao2) {
                                        case 1:
                                            boolean continuar4 = true;
                                            while (continuar4) {
                                                System.out.println("Você deseja agendar consulta com algum médico específico?");
                                                System.out.print("Digite --> 1 - Sim | 2 - Não | 3 - Voltar | 4 - Encerrar Atendimento: ");
                                                int opcao3 = scanner.nextInt();
                                                scanner.nextLine();
                                                switch (opcao3) {
                                                    case 1:
                                                        continuar = false;
                                                        continuar3 = true;
                                                        System.out.print("Digite o nome do médico: ");
                                                        String nome_do_medico = scanner.nextLine();
                                                        System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                        System.out.print("Quais dias você estaria disponível para realizar a consulta? Digite Aqui: ");
                                                        String nome_dos_dias = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_dos_dias, nome_do_medico);
                                                        System.out.println("Deseja prosseguir com o agendamento de consulta com este médico? ");
                                                        System.out.print("1 - Sim | 2 - Buscar outro: ");
                                                        int escolha = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (escolha == 1) {
                                                            System.out.println("Agora digite o dia e o horário que você deseja agendar a consulta, caso esteja 'Disponível' o horário");
                                                            System.out.print("Digite o Nome Completo do Médico como consta nao campo 'INFORMAÇÕES': ");
                                                            String nomeMedico = scanner.nextLine();
                                                            System.out.print("Digite o dia (ex: Segunda): ");
                                                            String dia = scanner.nextLine();
                                                            System.out.print("Digite o horário (ex: 08am): ");
                                                            String horario = scanner.nextLine();
                                                            System.out.println("|Exemplo: 10/10|");
                                                            System.out.print("Digite a data (no formato: 'dd/mm') que você deseja agendar a consulta, lembrando que so agendamos até o fim da semana atual: ");
                                                            String data = scanner.nextLine();
                                                            if (Arquivo.verificarEAtualizar(nomeMedico, dia, horario, data)) {
                                                                System.out.print("Digite aqui seu primeiro Nome e Último sobrenome: ");
                                                                String nomePaciente = scanner.nextLine();
                                                                List<String> informacoes = Arquivo.buscarMedicosPorDiaEEspecialidade(nome_dos_dias, nome_do_medico);
                                                                String status = "Agendada";
                                                                Consultas consulta = new Consultas(nomePaciente, informacoes, status);

                                                                if (!consulta.getInformacoes().isEmpty() && !consulta.getPaciente().isBlank() && !consulta.getStatus().isBlank()) {
                                                                    String dadosConsulta = "Paciente Consultado: " + consulta.getPaciente() + "\n" +
                                                                            "| Informações da Consulta: " + consulta.getInformacoes() +
                                                                            "| Status da Consulta: " + consulta.getStatus() +
                                                                            "| Horário da Consulta: " + data + " - " + horario;
                                                                    Arquivo.salvar("Consulta.txt", dadosConsulta);

                                                                    System.out.println("Sua Consulta foi linkada com o Médico Desejado!");
                                                                    break;
                                                                }
                                                            }
                                                            continuar4 = false;
                                                            break;
                                                        } else {
                                                        }

                                                        break;
                                                    case 2:
                                                        continuar = false;
                                                        continuar3 = true;
                                                        System.out.print("Em qual Especialidade Médica você deseja marcar consulta? Digite Aqui: ");
                                                        String especialidade = scanner.nextLine();
                                                        System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                        System.out.print("Quais dias você estaria disponível para realizar a consulta? Digite Aqui: ");
                                                        String nome_dos_dias2 = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_dos_dias2, especialidade);
                                                        System.out.println("Deseja prosseguir com o agendamento de consulta com este médico? ");
                                                        System.out.print("1 - Sim | 2 - Buscar outro: ");
                                                        int escolha2 = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (escolha2 == 1) {
                                                            System.out.println("Agora digite o dia e o horário que você deseja agendar a consulta, caso esteja 'Disponível' o horário");
                                                            System.out.print("Digite o Nome Completo do Médico como consta nao campo 'INFORMAÇÕES': ");
                                                            String nomeMedico = scanner.nextLine();
                                                            System.out.print("Digite o dia (ex: Segunda): ");
                                                            String dia = scanner.nextLine();
                                                            System.out.print("Digite o horário (ex: 08am): ");
                                                            String horario = scanner.nextLine();
                                                            System.out.println("|Exemplo: 10/10|");
                                                            System.out.print("Digite a data que você deseja agendar a consulta, lembrando que so agendamos para daqui a no máximo 1 semana: ");
                                                            String data = scanner.nextLine();
                                                            if (Arquivo.verificarEAtualizar(nomeMedico, dia, horario, data)) {
                                                                System.out.print("Digite aqui seu primeiro Nome e Último sobrenome: ");
                                                                String nomePaciente = scanner.nextLine();
                                                                List<String> informacoes = Arquivo.buscarMedicosPorDiaEEspecialidade(nome_dos_dias2, especialidade);
                                                                String status = "Agendada";
                                                                Consultas consulta = new Consultas(nomePaciente, informacoes, status);

                                                                if (!consulta.getInformacoes().isEmpty() && !consulta.getPaciente().isBlank() && !consulta.getStatus().isBlank()) {
                                                                    String dadosConsulta = "Paciente Consultado: " + consulta.getPaciente() +
                                                                            "| Informações da Consulta: " + consulta.getInformacoes() +
                                                                            "| Status da Consulta: " + consulta.getStatus() +
                                                                            "| Horário da Consulta: " + data + " - " + horario;
                                                                    Arquivo.salvar("Consulta.txt", dadosConsulta);

                                                                    System.out.println("Sua Consulta foi linkada com o Médico Desejado!");
                                                                    break;
                                                                }
                                                            }
                                                            continuar4 = false;
                                                            break;
                                                        } else {
                                                        }
                                                        continuar4 = false;

                                                        break;
                                                    case 3:
                                                        continuar = false;
                                                        System.out.println("Voltando...");
                                                        continuar4 = false;
                                                        break;
                                                    case 4:
                                                        continuar = false;
                                                        continuar3 = true;
                                                        System.out.println("Muito Obrigado por Escolher o Hospital Java, Volte Sempre!!");
                                                        continuar4 = false;
                                                        break;

                                                    default:
                                                        continuar = false;
                                                        System.out.println("Opção Inválida!!");
                                                        break;


                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Voltando à Página Inicial...");
                                            continuar3 = true;
                                            break;
                                        case 3:
                                            continuar = false;
                                            System.out.println("Voltando...");
                                            continuar3 = true;
                                            break;
                                        case 4:
                                            continuar = false;
                                            System.out.println("Muito Obrigado por Escolher o Hospital Java, Volte Sempre!!");
                                            continuar3 = true;
                                            break;
                                        default:
                                            continuar = false;
                                            System.out.println("Opção Inválida!!");
                                            break;
                                    }
                                }

                                break;

                            case 2:
                                continuar1 = true;
                                boolean continuar5 = true;
                                while (continuar5) {
                                    System.out.print("Escreva seu Primeiro Nome: ");
                                    String nome_especial = scanner.nextLine();
                                    System.out.print("Escreva seu Último Sobrenome: ");
                                    String sobrenome_especial = scanner.nextLine();
                                    System.out.print("Escreva seu CPF no formato --> XXX.XXX.XXX-XX: ");
                                    String cpf_especial = scanner.nextLine();
                                    System.out.print("Digite sua Idade: ");
                                    int idade_especial = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("(Apenas digite um '.' caso não possua) Informe seu Plano de Saúde: ");
                                    String plano_de_saude_especial = scanner.nextLine();
                                    System.out.print("(Apenas digite um '.' caso não possua) Informe seu tipo de Prioridade: ");
                                    String tipo_de_prioridade_especial = scanner.nextLine();
                                    System.out.print("Crie uma senha de até 8 caracteres para login posterior: ");
                                    String senha_especial = scanner.nextLine();

                                    Paciente_Especial paciente_especial = new Paciente_Especial(nome_especial, sobrenome_especial, cpf_especial, idade_especial, plano_de_saude_especial, tipo_de_prioridade_especial, senha_especial);

                                    if (!paciente_especial.getNomeCompleto().isBlank() && !paciente_especial.getCpf().isBlank() && !paciente_especial.getTipodeprioridade().isBlank() && paciente_especial.getIdade() != 0 && !paciente_especial.getPlanoDeSaude().isBlank() && !paciente_especial.getSenhaHash().isBlank()) {
                                        String dadosPacienteEspecial = "Paciente especial: " + paciente_especial.getNomeCompleto() +
                                                " | CPF: " + paciente_especial.getCpf() +
                                                " | Idade: " + paciente_especial.getIdade() +
                                                " | Plano: " + paciente_especial.getPlanoDeSaude() +
                                                " | Prioridade: " + paciente_especial.getTipodeprioridade() +
                                                " | Login: " + paciente_especial.getLoginEspecial() +
                                                " | Senha: " + paciente_especial.getSenhaHashEspecial();
                                        Arquivo.salvar("pacientes.txt", dadosPacienteEspecial);

                                        System.out.println("Paciente especial cadastrado com sucesso!!");
                                        break;
                                    }
                                    continuar5 = false;
                                }
                                boolean continuar31 = false;


                                while (!continuar31) {
                                    System.out.println("AVISOS: [Nós atendemos, por meio de CONSULTAS, de Segunda a Sábado de 8 às 18] e [Agendamos consultas apenas até o fim dessa semana]");
                                    System.out.println("Deseja agendar agora sua Consulta?");
                                    System.out.print("Digite --> 1 - Sim | 2 - Não | 3 - Voltar | 4 - Encerrar Atendimento: ");

                                    int opcao2 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao2) {
                                        case 1:
                                            boolean continuar4 = true;
                                            while (continuar4) {
                                                System.out.println("Você deseja agendar consulta com algum médico específico?");
                                                System.out.print("Digite --> 1 - Sim | 2 - Não | 3 - Voltar | 4 - Encerrar Atendimento: ");
                                                int opcao3 = scanner.nextInt();
                                                scanner.nextLine();
                                                switch (opcao3) {
                                                    case 1:
                                                        continuar = false;
                                                        continuar31 = true;
                                                        System.out.print("Digite o nome do médico: ");
                                                        String nome_do_medico = scanner.nextLine();
                                                        System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                        System.out.print("Quais dias você estaria disponível para realizar a consulta? Digite Aqui: ");
                                                        String nome_dos_dias = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_dos_dias, nome_do_medico);
                                                        System.out.println("Deseja prosseguir com o agendamento de consulta com este médico? ");
                                                        System.out.print("1 - Sim | 2 - Buscar outro: ");
                                                        int escolha = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (escolha == 1) {
                                                            System.out.println("Agora digite o dia e o horário que você deseja agendar a consulta, caso esteja 'Disponível' o horário");
                                                            System.out.print("Digite o Nome Completo do Médico como consta nao campo 'INFORMAÇÕES': ");
                                                            String nomeMedico = scanner.nextLine();
                                                            System.out.print("Digite o dia (ex: Segunda): ");
                                                            String dia = scanner.nextLine();
                                                            System.out.print("Digite o horário (ex: 08am): ");
                                                            String horario = scanner.nextLine();
                                                            System.out.println("|Exemplo: 10/10|");
                                                            System.out.print("Digite a data (no formato: 'dd/mm') que você deseja agendar a consulta, lembrando que so agendamos até o fim da semana atual: ");
                                                            String data = scanner.nextLine();
                                                            if (Arquivo.verificarEAtualizar(nomeMedico, dia, horario, data)) {
                                                                System.out.print("Digite aqui seu primeiro Nome e Último sobrenome: ");
                                                                String nomePaciente = scanner.nextLine();
                                                                List<String> informacoes = Arquivo.buscarMedicosPorDiaEEspecialidade(nome_dos_dias, nome_do_medico);
                                                                String status = "Agendada";
                                                                Consultas consulta = new Consultas(nomePaciente, informacoes, status);

                                                                if (!consulta.getInformacoes().isEmpty() && !consulta.getPaciente().isBlank() && !consulta.getStatus().isBlank()) {
                                                                    String dadosConsulta = "Paciente Consultado: " + consulta.getPaciente() +
                                                                            "| Informações da Consulta: " + consulta.getInformacoes() +
                                                                            "| Status da Consulta: " + consulta.getStatus() +
                                                                            "| Horário da Consulta: " + data + " - " + horario;
                                                                    Arquivo.salvar("Consulta.txt", dadosConsulta);

                                                                    System.out.println("Sua Consulta foi linkada com o Médico Desejado!");
                                                                    break;
                                                                }
                                                            }
                                                            continuar4 = false;
                                                            break;
                                                        } else {
                                                        }

                                                        break;
                                                    case 2:
                                                        continuar = false;
                                                        continuar31 = true;
                                                        System.out.print("Em qual Especialidade Médica você deseja marcar consulta? Digite Aqui: ");
                                                        String especialidade = scanner.nextLine();
                                                        System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                        System.out.print("Quais dias você estaria disponível para realizar a consulta? Digite Aqui: ");
                                                        String nome_dos_dias2 = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_dos_dias2, especialidade);
                                                        System.out.println("Deseja prosseguir com o agendamento de consulta com este médico? ");
                                                        System.out.print("1 - Sim | 2 - Buscar outro: ");
                                                        int escolha2 = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (escolha2 == 1) {
                                                            System.out.println("Agora digite o dia e o horário que você deseja agendar a consulta, caso esteja 'Disponível' o horário");
                                                            System.out.print("Digite o Nome Completo do Médico como consta nao campo 'INFORMAÇÕES': ");
                                                            String nomeMedico = scanner.nextLine();
                                                            System.out.print("Digite o dia (ex: Segunda): ");
                                                            String dia = scanner.nextLine();
                                                            System.out.print("Digite o horário (ex: 08am): ");
                                                            String horario = scanner.nextLine();
                                                            System.out.println("|Exemplo: 10/10|");
                                                            System.out.print("Digite a data que você deseja agendar a consulta, lembrando que so agendamos para daqui a no máximo 1 semana: ");
                                                            String data = scanner.nextLine();
                                                            if (Arquivo.verificarEAtualizar(nomeMedico, dia, horario, data)) {
                                                                System.out.print("Digite aqui seu primeiro Nome e Último sobrenome: ");
                                                                String nomePaciente = scanner.nextLine();
                                                                List<String> informacoes = Arquivo.buscarMedicosPorDiaEEspecialidade(nome_dos_dias2, especialidade);
                                                                String status = "Agendada";
                                                                Consultas consulta = new Consultas(nomePaciente, informacoes, status);

                                                                if (!consulta.getInformacoes().isEmpty() && !consulta.getPaciente().isBlank() && !consulta.getStatus().isBlank()) {
                                                                    String dadosConsulta = "Paciente Consultado: " + consulta.getPaciente() +
                                                                            "| Informações da Consulta: " + consulta.getInformacoes() +
                                                                            "| Status da Consulta: " + consulta.getStatus() +
                                                                            "| Horário da Consulta: " + data + " - " + horario;
                                                                    Arquivo.salvar("Consulta.txt", dadosConsulta);

                                                                    System.out.println("Sua Consulta foi linkada com o Médico Desejado!");
                                                                    break;
                                                                }
                                                            }
                                                            continuar4 = false;
                                                            break;
                                                        } else {
                                                        }

                                                        continuar4 = false;

                                                        break;
                                                    case 3:
                                                        continuar = false;
                                                        System.out.println("Voltando...");
                                                        continuar4 = false;
                                                        break;
                                                    case 4:
                                                        continuar = false;
                                                        continuar31 = true;
                                                        System.out.println("Muito Obrigado por Escolher o Hospital Java, Volte Sempre!!");
                                                        continuar4 = false;
                                                        break;

                                                    default:
                                                        continuar = false;
                                                        System.out.println("Opção Inválida!!");
                                                        break;


                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Voltando à Página Inicial...");
                                            continuar31 = true;
                                            break;
                                        case 3:
                                            continuar = false;
                                            System.out.println("Voltando...");
                                            continuar31 = true;
                                            break;
                                        case 4:
                                            continuar = false;
                                            System.out.println("Muito Obrigado por Escolher o Hospital Java, Volte Sempre!!");
                                            continuar31 = true;
                                            break;
                                        default:
                                            continuar = false;
                                            System.out.println("Opção Inválida!!");
                                            break;
                                    }
                                }

                                break;

                            case 3:
                                continuar = false;
                                continuar1 = true;
                                boolean continuar6 = true;
                                while (continuar6) {
                                    boolean senha = true;
                                    while (senha) {
                                        System.out.print("Digite aqui a senha fornecida pelo Hospital Java para se cadastrar como Medico: ");
                                        String senhaMedico = scanner.nextLine();
                                        senha = SenhaMedico.VerificarSenha(senhaMedico);
                                    }
                                    System.out.print("Escreva seu Primeiro Nome: ");
                                    String nomeMedico = scanner.nextLine();
                                    System.out.print("Escreva seu Último Sobrenome: ");
                                    String sobrenomeMedico = scanner.nextLine();
                                    System.out.print("Digite aqui seu CRM: ");
                                    int crm = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Escreva sua ou suas especialidades seguindo este modelo(Dermatologia, Pediatria...): ");
                                    String especialidade = scanner.nextLine();
                                    System.out.print("Escreva o preço (numérico) que você cobra por consulta para pacientes sem plano de saúde: ");
                                    double custoDaConsulta = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("Escreva o preço (numérico) que você cobra por consulta para pacientes com plano de saúde e/ou algum tipo de prioridade: ");
                                    double custoDaConsulta2 = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("Escreva o preço (numérico) que você cobra por consulta para pacientes 60+ : ");
                                    double custoDaConsulta3 = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("Crie uma senha para login posterior contendo no máximo 8 caracteres: ");
                                    String senhaMedico2 = scanner.nextLine();
                                    System.out.println("|Preencha os horários com 'A' - Apto para Realizar Consulta| ou |Deixe Em Branco - Horário não disponível|");
                                    System.out.println("Digite aqui como é sua agenda de horários: ");
                                    String[][] agenda_de_horarios = new String[7][24];


                                    boolean continuar7 = true;
                                    for (int i = 0; i < 7; i++) {
                                        for (int j = 8; j < 19; j++) {
                                            do {
                                                continuar7 = true;
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
                                                    agenda_de_horarios[i][j] = scanner.nextLine();
                                                    if (agenda_de_horarios[i][j].length() < 2) {
                                                        continuar7 = false;
                                                    }

                                                } else if (j < 12) {
                                                    System.out.print(j + "am: ");
                                                    agenda_de_horarios[i][j] = scanner.nextLine();
                                                    if (agenda_de_horarios[i][j].length() < 2) {
                                                        continuar7 = false;
                                                    }

                                                } else {
                                                    System.out.print(j + "pm: ");
                                                    agenda_de_horarios[i][j] = scanner.nextLine();
                                                    if (agenda_de_horarios[i][j].length() < 2) {
                                                        continuar7 = false;
                                                    }
                                                }
                                            } while (continuar7);
                                        }

                                    }


                                    Medico medico = new Medico(nomeMedico, sobrenomeMedico, crm, especialidade, custoDaConsulta, custoDaConsulta2, custoDaConsulta3, agenda_de_horarios, senhaMedico2);


                                    if (!medico.getNomeCompleto().isBlank() && medico.getCrm() != 0 && !medico.getEspecialidade().isBlank() && medico.getCustoDaConsulta() != 0) {
                                        String dadosMedico = "INFORMAÇÕES" + "\n" + "|Medico: " + medico.getNomeCompleto() +
                                                " |Especialidade: " + medico.getEspecialidade() +
                                                " | Custo da Consulta - Paciente Comum: " + medico.getCustoDaConsulta() +
                                                " | Custo da Consulta - Paciente Especial: " + medico.getCustoDaConsulta2() +
                                                " | Custo da Consulta - Paciente 60+: " + medico.getCustoDaConsulta3() +
                                                " | Sala: " + medico.getSala() +
                                                " | CRM: " + medico.getCrm() +
                                                " | Senha: " + medico.getSenhaMedico() +
                                                " | ↓↓ Agenda de horários do: " + medico.getNomeCompleto() + "  ↓↓\n";
                                        Arquivo.salvar("medicos.txt", dadosMedico);

                                        Arquivo.salvarAgenda("medicos.txt", medico.getAgenda_de_horarios());

                                        System.out.println("Médico cadastrado com sucesso, sua sala de atendimento é a: " + medico.getSala() + ".");
                                        break;
                                    }


                                }
                                break;

                            case 4:
                                System.out.println("Voltando...");
                                continuar1 = true;
                                break;

                            case 5:
                                continuar = false;
                                System.out.println("Muito Obrigado por Escolher o Hospital Java, volte sempre!!");
                                continuar1 = true;
                                break;


                            default:
                                continuar = false;
                                System.out.println("Opção Inválida!!");
                                break;
                        }
                    }
                    break;

                case 2:
                    boolean verificacao = true;
                    while (verificacao) {
                        System.out.println("Você deseja realizar login como Médico ou Paciente?");
                        System.out.print("Digite 1 para Paciente | 2 para Médico: ");
                        int login2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (login2) {
                            case 1:
                                System.out.print("Digite os 6 primeiros dígitos do seu CPF (Tudo Junto): ");
                                String login = scanner.nextLine();
                                System.out.print("Digite sua Senha: ");
                                String senha = scanner.nextLine();
                                verificacao = SenhaPaciente.verificarLogin(login, SenhaPaciente.verificarSenhaHash(senha));
                                System.out.println("Bem-Vindo ao Hospital Java!");
                                boolean continuar31 = false;
                                while (!continuar31) {
                                    System.out.println("AVISOS: [Nós atendemos, por meio de CONSULTAS, de Segunda a Sábado de 8 às 18] e [Agendamos consultas apenas até o fim dessa semana]");
                                    System.out.println("Deseja agendar agora sua Consulta?");
                                    System.out.print("Digite --> 1 - Sim | 2 - Não | 3 - Voltar | 4 - Encerrar Atendimento: ");

                                    int opcao2 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao2) {
                                        case 1:
                                            boolean continuar4 = true;
                                            while (continuar4) {
                                                System.out.println("Você deseja agendar consulta com algum médico específico?");
                                                System.out.print("Digite --> 1 - Sim | 2 - Não | 3 - Voltar | 4 - Encerrar Atendimento: ");
                                                int opcao3 = scanner.nextInt();
                                                scanner.nextLine();
                                                switch (opcao3) {
                                                    case 1:
                                                        continuar = false;
                                                        continuar31 = true;
                                                        System.out.print("Digite o nome do médico: ");
                                                        String nome_do_medico = scanner.nextLine();
                                                        System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                        System.out.print("Quais dias você estaria disponível para realizar a consulta? Digite Aqui: ");
                                                        String nome_dos_dias = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_dos_dias, nome_do_medico);
                                                        System.out.println("Deseja prosseguir com o agendamento de consulta com este médico? ");
                                                        System.out.print("1 - Sim | 2 - Buscar outro: ");
                                                        int escolha = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (escolha == 1) {
                                                            System.out.println("Agora digite o dia e o horário que você deseja agendar a consulta, caso esteja 'Disponível' o horário");
                                                            System.out.print("Digite o Nome Completo do Médico como consta nao campo 'INFORMAÇÕES': ");
                                                            String nomeMedico = scanner.nextLine();
                                                            System.out.print("Digite o dia (ex: Segunda): ");
                                                            String dia = scanner.nextLine();
                                                            System.out.print("Digite o horário (ex: 08am): ");
                                                            String horario = scanner.nextLine();
                                                            System.out.println("|Exemplo: 10/10|");
                                                            System.out.print("Digite a data (no formato: 'dd/mm') que você deseja agendar a consulta, lembrando que so agendamos até o fim da semana atual: ");
                                                            String data = scanner.nextLine();
                                                            if (Arquivo.verificarEAtualizar(nomeMedico, dia, horario, data)) {
                                                                System.out.print("Digite aqui seu primeiro Nome e Último sobrenome: ");
                                                                String nomePaciente = scanner.nextLine();
                                                                List<String> informacoes = Arquivo.buscarMedicosPorDiaEEspecialidade(nome_dos_dias, nome_do_medico);
                                                                String status = "Agendada";
                                                                Consultas consulta = new Consultas(nomePaciente, informacoes, status);

                                                                if (!consulta.getInformacoes().isEmpty() && !consulta.getPaciente().isBlank() && !consulta.getStatus().isBlank()) {
                                                                    String dadosConsulta = "Paciente Consultado: " + consulta.getPaciente() +
                                                                            "| Informações da Consulta: " + consulta.getInformacoes() +
                                                                            "| Status da Consulta: " + consulta.getStatus() +
                                                                            "| Horário da Consulta: " + data + " - " + horario;
                                                                    Arquivo.salvar("Consulta.txt", dadosConsulta);

                                                                    System.out.println("Sua Consulta foi linkada com o Médico Desejado!");
                                                                    break;
                                                                }
                                                            }
                                                            continuar4 = false;
                                                            break;
                                                        } else {
                                                        }

                                                        break;
                                                    case 2:
                                                        continuar = false;
                                                        continuar31 = true;
                                                        System.out.print("Em qual Especialidade Médica você deseja marcar consulta? Digite Aqui: ");
                                                        String especialidade = scanner.nextLine();
                                                        System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                        System.out.print("Quais dias você estaria disponível para realizar a consulta? Digite Aqui: ");
                                                        String nome_dos_dias2 = scanner.nextLine();
                                                        Arquivo.lerArquivoScanner(nome_dos_dias2, especialidade);
                                                        System.out.println("Deseja prosseguir com o agendamento de consulta com este médico? ");
                                                        System.out.print("1 - Sim | 2 - Buscar outro: ");
                                                        int escolha2 = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (escolha2 == 1) {
                                                            System.out.println("Agora digite o dia e o horário que você deseja agendar a consulta, caso esteja 'Disponível' o horário");
                                                            System.out.print("Digite o Nome Completo do Médico como consta nao campo 'INFORMAÇÕES': ");
                                                            String nomeMedico = scanner.nextLine();
                                                            System.out.print("Digite o dia (ex: Segunda): ");
                                                            String dia = scanner.nextLine();
                                                            System.out.print("Digite o horário (ex: 08am): ");
                                                            String horario = scanner.nextLine();
                                                            System.out.println("|Exemplo: 10/10|");
                                                            System.out.print("Digite a data que você deseja agendar a consulta, lembrando que so agendamos para daqui a no máximo 1 semana: ");
                                                            String data = scanner.nextLine();
                                                            if (Arquivo.verificarEAtualizar(nomeMedico, dia, horario, data)) {
                                                                System.out.print("Digite aqui o primeiro Nome e Último sobrenome do paciente a ser Consultado: ");
                                                                String nomePaciente = scanner.nextLine();
                                                                List<String> informacoes = Arquivo.buscarMedicosPorDiaEEspecialidade(nome_dos_dias2, especialidade);
                                                                String status = "Agendada";
                                                                Consultas consulta = new Consultas(nomePaciente, informacoes, status);

                                                                if (!consulta.getInformacoes().isEmpty() && !consulta.getPaciente().isBlank() && !consulta.getStatus().isBlank()) {
                                                                    String dadosConsulta = "Paciente Consultado: " + consulta.getPaciente() +
                                                                            "| Informações da Consulta: " + consulta.getInformacoes() +
                                                                            "| Status da Consulta: " + consulta.getStatus() +
                                                                            "| Horário da Consulta: " + data + " - " + horario;
                                                                    Arquivo.salvar("Consulta.txt", dadosConsulta);

                                                                    System.out.println("Sua Consulta foi linkada com o Médico Desejado!");
                                                                    break;
                                                                }
                                                            }
                                                            continuar4 = false;
                                                            break;
                                                        } else {
                                                        }

                                                        continuar4 = false;

                                                        break;
                                                    case 3:
                                                        continuar = false;
                                                        System.out.println("Voltando...");
                                                        continuar4 = false;
                                                        break;
                                                    case 4:
                                                        continuar = false;
                                                        continuar31 = true;
                                                        System.out.println("Muito Obrigado por Escolher o Hospital Java, Volte Sempre!!");
                                                        continuar4 = false;
                                                        break;

                                                    default:
                                                        continuar = false;
                                                        System.out.println("Opção Inválida!!");
                                                        break;


                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Voltando à Página Inicial...");
                                            continuar31 = true;
                                            break;
                                        case 3:
                                            continuar = false;
                                            System.out.println("Voltando...");
                                            continuar31 = true;
                                            break;
                                        case 4:
                                            continuar = false;
                                            System.out.println("Muito Obrigado por Escolher o Hospital Java, Volte Sempre!!");
                                            continuar31 = true;
                                            break;
                                        default:
                                            continuar = false;
                                            System.out.println("Opção Inválida!!");
                                            break;
                                    }
                                }

                                break;


                            case 2:

                                System.out.print("Digite o seu CRM: ");
                                String login3 = scanner.nextLine();
                                System.out.print("Digite sua Senha: ");
                                String senha3 = scanner.nextLine();
                                verificacao = SenhaMedico.verificarLogin(login3, SenhaPaciente.verificarSenhaHash(senha3));
                                if (!verificacao) {
                                    boolean continuarAcoesMedico = true;
                                    while (continuarAcoesMedico) {
                                        System.out.println("\nBem-Vindo Doutor(a)!");
                                        System.out.print("Digite --> 1 - Checar Agenda | 2 - Registrar Internação | 3 - Cancelar Internação | 4 - Encerrar Atendimento: ");
                                        int acaoMedico = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (acaoMedico) {
                                            case 1:
                                                System.out.print("Digite seu Primeiro Nome e Último Sobrenome: ");
                                                String nome_do_medico = scanner.nextLine();
                                                System.out.println("Exemplo: Segunda, Quarta, Sábado");
                                                System.out.print("Quais dias você gostaria de checar como está a sua agenda? Digite Aqui: ");
                                                String nome_dos_dias = scanner.nextLine();


                                                Arquivo.lerArquivoScanner(nome_dos_dias, nome_do_medico);


                                                System.out.print("Gostaria de Encerrar a Agenda da Semana Doutor(a)? ");
                                                System.out.print("1 - Sim | 2 - Não: ");
                                                int opcao90 = scanner.nextInt();
                                                scanner.nextLine();
                                                switch (opcao90) {
                                                    case 1:

                                                        System.out.print("Confirme seu Primeiro Nome e Último Sobrenome: ");
                                                        String nome_do_medico2 = scanner.nextLine();
                                                        Arquivo.fecharAgendaInterativa(scanner, nome_do_medico2);
                                                        break;
                                                    case 2:

                                                        break;
                                                    default:
                                                        System.out.println("Opção inválida.");
                                                        break;
                                                }
                                                break;

                                            case 2:

                                                Internacao.registrarInternacao(scanner);
                                                break;

                                            case 3:
                                                System.out.println("\n--- CANCELAR INTERNAÇÃO ---");
                                                System.out.print("Nome Completo do Paciente: ");
                                                String pacienteCancela = scanner.nextLine();
                                                System.out.print("Número do Quarto (200-400): ");
                                                String quartoCancela = scanner.nextLine();
                                                System.out.print("Data de Cancelamento/Saída (dd/mm/aaaa): ");
                                                String dataCancela = scanner.nextLine();


                                                Internacao.cancelarInternacao(pacienteCancela, quartoCancela, dataCancela);
                                                break;
                                            case 4:
                                                System.out.println("Sessão encerrada. Voltando ao Menu Principal.");
                                                continuarAcoesMedico = false;
                                                verificacao = true;
                                                break;
                                            default:
                                                System.out.println("Opção inválida.");
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("❌ Login ou Senha Incorretos.");
                                }
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
    }
}














