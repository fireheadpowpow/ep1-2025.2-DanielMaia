package hospital.classes;

import java.util.List;
import java.util.ArrayList;



public class Paciente{
    private String nome;
    private String cpf;
    private int idade;
    private String senha;
    private List<Consultas> historicoConsultas = new ArrayList<>();
    private List<Internacao> historicoInternacoes = new ArrayList<>();

    public Paciente(String nome, String cpf, int idade, String senha){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setSenha(senha);
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


    public void setSenha(String senha) {
        if(!cpf.isBlank()){
            String senha_1parte = cpf.substring(0, 3);
            String senha_2parte = cpf.substring(4, 7);
            this.senha = senha_1parte + senha_2parte;

        }
    }

    public String getSenha(){
        return senha;
    }


    public void setNome(String nome){
        if(nome.isBlank()){
            this.nome = "";
        }
        else{
            this.nome = nome;
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

    public String getNome() {
        return nome;
    }



}