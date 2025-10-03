package hospital.classes;


public class Paciente{
    private String nome;
    private String cpf;
    private int idade;

    public Paciente(String nome, String cpf, int idade){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setIdade(idade);
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