package hospital.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Medico{
    private String nome;
    private String sobrenome;
    private int crm;
    private String especialidade;
    private double custoDaConsulta;
    private String[][] agenda_de_horarios;
    private int sala;
    private String senhaMedico;
    private double custoDaConsulta2;
    double custoDaConsulta3;
    private static int proximaSalaDisponivel =  inicializarProximaSala();
    ;

    public Medico(String nome, String sobrenome, int crm, String especialidade, double custoDaConsulta, double custoDaConsulta2, double custoDaConsulta3, String[][] agenda_de_horarios, String senhaMedico){
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
        this.setCustoDaConsulta(custoDaConsulta);
        this.setAgenda_de_horarios(agenda_de_horarios);
        this.sala = proximaSalaDisponivel;
        proximaSalaDisponivel++;
        this.setSenhaMedico(senhaMedico);
        this.setCustoDaConsulta2(custoDaConsulta2);
        this.setCustoDaConsulta3(custoDaConsulta3);
    }


    public int getSala() {
    return sala;
    }

    private static int inicializarProximaSala() {
        int maiorSala = 0;
        File arquivo = new File("medicos.txt");

        try (Scanner leitor = new Scanner(arquivo)) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();


                if (linha.contains("| Sala: ")) {


                    int inicio = linha.indexOf("| Sala: ") + "| Sala: ".length();


                    int fim = linha.indexOf("|", inicio);

                    if (fim == -1) {
                        fim = linha.length();
                    }


                    String salaStr = linha.substring(inicio, fim).trim();

                    try {
                        int salaAtual = Integer.parseInt(salaStr);
                        if (salaAtual > maiorSala) {
                            maiorSala = salaAtual;
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        } catch (FileNotFoundException e) {

            return 1;
        }


        return maiorSala + 1;
    }

    public void setNome(String nome){
        if(nome.isBlank()){
            System.out.println("Credencial Nome Inválida!, Tente Novamente");
           this.nome = "";
        }
        else{
            String nomeFormatado = nome.substring(0, 1).toUpperCase();
            String restante = nome.substring(1).toLowerCase();
            this.nome = nomeFormatado + restante;
        }
    }

    public void setSobrenome(String sobrenome){
        if(sobrenome.isBlank()){
            System.out.println("Credencial Sobrenome Inválida!, Tente Novamente");
            this.sobrenome  = "";
        }
        else{
            String sobrenomeFormatado = sobrenome.substring(0, 1).toUpperCase();
            String restante2 = sobrenome.substring(1).toLowerCase();
            this.sobrenome = sobrenomeFormatado + restante2;
        }
    }


    public void setEspecialidade(String especialidade){
        List<String> listaEspecialidade;
        if (especialidade.isBlank()){
            System.out.println("Credencial Especialidade Inválida!, Tente Novamente");
            this.especialidade = "";
        }
        else {
                String[] especialidadeMedicoVetor = especialidade.split(", ");
                listaEspecialidade = new ArrayList<>(Arrays.asList(especialidadeMedicoVetor));
                for(int i = 0; i < listaEspecialidade.size(); i++) {
                    String palavra = listaEspecialidade.get(i);

                    String parteFormatada = palavra.substring(0, 1).toUpperCase();
                    String restoFormatada = palavra.substring(1).toLowerCase();

                    String palavraFormatada = parteFormatada + restoFormatada;

                    listaEspecialidade.set(i, palavraFormatada);
                }
            this.especialidade = String.join(", ", listaEspecialidade);
        }

    }

    public void setAgenda_de_horarios(String[][] agenda_de_horarios){
        for (int i = 0; i < 7; i++) {
            for (int j = 8; j < 19; j++) {
                if(!agenda_de_horarios[i][j].isBlank() && agenda_de_horarios[i][j].length() == 1)
                    agenda_de_horarios[i][j] = "Disponível";
                else{
                    agenda_de_horarios[i][j] = "Ocupado";
                }
            }
            }
        this.agenda_de_horarios = agenda_de_horarios;
    }

    public void setCrm(int crm){
        if (crm <= 0){
            System.out.println("Credencial CRM Inválida!, Tente Novamente");
            this.crm = 0;
        }
        else{
            this.crm = crm;
        }
    }

    public void setCustoDaConsulta(double custoDaConsulta){
        if (custoDaConsulta <= 0){
            System.out.println("Credencial Custo da Consulta Inválida!, Tente Novamente");
            this.custoDaConsulta = 0;
        }
        else{
            this.custoDaConsulta = custoDaConsulta;
        }
    }

    public void setCustoDaConsulta2(double custoDaConsulta2){
        if (custoDaConsulta2 <= 0){
            System.out.println("Credencial Custo da Consulta para plano de saúde e/ou prioridade Inválida!, Tente Novamente");
            this.custoDaConsulta2 = 0;
        }
        else{
            this.custoDaConsulta2 = custoDaConsulta2;
        }
    }

    public void setCustoDaConsulta3(double custoDaConsulta3){
        if (custoDaConsulta3 <= 0){
            System.out.println("Credencial Custo da Consulta para 60+ Inválida!, Tente Novamente");
            this.custoDaConsulta3 = 0;
        }
        else{
            this.custoDaConsulta3 = custoDaConsulta3;
        }
    }

    public void setSenhaMedico(String senhaMedico){
        if (senhaMedico == null || senhaMedico.isBlank()) {
            this.senhaMedico = null;

        }
        String tudoMaiusculo = senhaMedico.substring(0).toUpperCase();
        int tamanho = tudoMaiusculo.length();
        int metade = tamanho / 2;
        String primeiraMetade = tudoMaiusculo.substring(0, metade);
        String segundaMetade = tudoMaiusculo.substring(metade);
        String Juntar = segundaMetade + primeiraMetade;
        if (senhaMedico.length() < 9 && Juntar.matches(".*\\d.*")){
            String semNumero = Juntar.replaceAll("[0-2]", "l");
            String semNumero2 = semNumero.replaceAll("[3-5]", "f");
            String semNumero3 = semNumero2.replaceAll("[6-9]", "3");
            this.senhaMedico = semNumero3;
        }
        else{
            String substituto = Juntar.replaceAll("[A-D]", "rg");
            String substituto2 = substituto.replaceAll("[F-J]", "s");
            String substituto3 = substituto2.replaceAll("[P-U]", "c");
            this.senhaMedico = substituto3;
        }

    }

    public String getSenhaMedico(){
        return senhaMedico;
    }




    public String getNomeCompleto(){
        return nome + " " + sobrenome;
    }
    public int getCrm(){
        return crm;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public double getCustoDaConsulta(){
        return custoDaConsulta;
    }

    public double getCustoDaConsulta2(){
        return custoDaConsulta2;
    }

    public double getCustoDaConsulta3(){
        return custoDaConsulta3;
    }

    public String[][] getAgenda_de_horarios(){
        return agenda_de_horarios;
    }

}
