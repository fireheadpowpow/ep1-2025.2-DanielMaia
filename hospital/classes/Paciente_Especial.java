package hospital.classes;

public class Paciente_Especial extends Paciente{
    private String planoDeSaude;
    private String tipoDePrioridade;

    public Paciente_Especial(String nome, String cpf, int idade, String senha, String planoDeSaude, String tipoDePrioridade){
        super(nome, cpf, idade, senha);
        this.planoDeSaude = planoDeSaude;
        this.tipoDePrioridade = tipoDePrioridade;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }
    public String getTipodeprioridade() {
        return tipoDePrioridade;
    }

}
