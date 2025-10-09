package hospital.classes;

import java.util.List;
import java.util.ArrayList;



public class Paciente{
    private String nome;
    private String sobrenome;
    private String cpf;
    private int idade;
    private String login;
    private String senhaHash;
    private List<Consultas> historicoConsultas = new ArrayList<>();
    private List<Internacao> historicoInternacoes = new ArrayList<>();

    public Paciente(String nome, String sobrenome, String cpf, int idade, String senhaHash){
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setSenhaHash(senhaHash);
        this.setLogin();
    }


    public void addConsulta(Consultas consulta) {
        this.historicoConsultas.add(consulta);
    }

    public void addInternacao(Internacao internacao) {
        this.historicoInternacoes.add(internacao);
    }


    public List<Consultas> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public List<Internacao> getHistoricoInternacoes(){
        return historicoInternacoes;
    }


    private void setLogin(){
        this.login = criandoLogin(cpf);
    }


    private String criandoLogin(String cpf) {
        if(!cpf.isBlank()){
            String login_1parte = cpf.substring(0, 3);
            String login_2parte = cpf.substring(4, 7);
            return  login_1parte + login_2parte;

        }
        else{
            return  "";
        }
    }

    public String getLogin(){
        return login;
    }


    //Criptografando
    public void setSenhaHash(String senhaHash){
        if (senhaHash.isBlank()) {
            this.senhaHash = "";
        }
            String tudoMaiusculo = senhaHash.substring(0).toUpperCase();
            int tamanho = tudoMaiusculo.length();
            int metade = tamanho / 2;
            String primeiraMetade = tudoMaiusculo.substring(0, metade);
            String segundaMetade = tudoMaiusculo.substring(metade);
            String Juntar = segundaMetade + primeiraMetade;
        if (senhaHash.length() < 9 && Juntar.matches(".*\\d.*")){
                String semNumero = Juntar.replaceAll("[0-2]", "l");
                String semNumero2 = semNumero.replaceAll("[3-5]", "f");
                String semNumero3 = semNumero2.replaceAll("[6-9]", "3");
                this.senhaHash = semNumero3;
            }
            else{
                String substituto = Juntar.replaceAll("[A-D]", "rg");
                String substituto2 = substituto.replaceAll("[F-J]", "s");
                String substituto3 = substituto2.replaceAll("[P-U]", "c");
                this.senhaHash = substituto3;
            }

        }

    public String getSenhaHash(){
        return senhaHash;
    }


    public void setNome(String nome){
        if(nome.isBlank()){
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
            this.sobrenome = "";
        }
        else{
            String sobrenomeFormatado = sobrenome.substring(0, 1).toUpperCase();
            String restante = sobrenome.substring(1).toLowerCase();
            this.sobrenome = sobrenomeFormatado + restante;

        }
    }

    //Verificação IDADE
    public void setIdade(int idade){
        if (idade >= 0 && idade < 130){
            this.idade = idade;
        }
        else{
            this.idade = 0;

        }
    }
    public int getIdade() {
        return idade;
    }

    //Verificação simples CPF
    public void setCpf(String cpf){
        if(cpf.length() == 14){
            this.cpf = cpf;
         }
        else{
            this.cpf = "";
        }
    }
      public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    private boolean verificarSenhaPaciente(String loginP, String senhaP){
        boolean verifica = true;
        if(loginP.equals(getLogin()) && senhaP.equals(getSenhaHash())){
            verifica = false;
        }
        return verifica;
    }




}