package hospital.classes;

public class Paciente_Especial extends Paciente{
    private String planoDeSaude;
    private String tipoDePrioridade;



    public Paciente_Especial(String nome, String sobrenome, String cpf, int idade, String planoDeSaude, String tipoDePrioridade, String senha){
        super(nome, sobrenome, cpf, idade, senha);
        this.setPlanoDeSaude(planoDeSaude);
        this.setTipoDePrioridade(tipoDePrioridade);
    }

    public void setPlanoDeSaude(String planoDeSaude){
        if(planoDeSaude.isBlank()){
            this.planoDeSaude = "";
        }
    }

    public void setTipoDePrioridade(String tipoDePrioridade){
        if(tipoDePrioridade.isBlank()){
            this.tipoDePrioridade = "";
        }
    }


    public String getPlanoDeSaude() {
        return planoDeSaude;
    }
    public String getTipodeprioridade() {
        return tipoDePrioridade;
    }

}
