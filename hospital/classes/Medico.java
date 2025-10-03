package hospital.classes;

public class Medico{
    private String nome;
    private int crm;
    private String especialidade;
    private double custo_da_consulta;
    private String[][] agenda_de_horarios;

    public Medico(String nome, int crm, String especialidade, double custo_da_consulta, String[][] agenda_de_horarios){
        this.setNome(nome);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
        this.setCusto_da_consulta(custo_da_consulta);
        this.agenda_de_horarios = agenda_de_horarios;
    }

    public void setNome(String nome){
        if(nome.isBlank()){
            throw new IllegalArgumentException("Nome Inválido!!");
        }
        else{
            this.nome = nome;
        }
    }

    public void setEspecialidade(String especialidade){
        if (especialidade.isBlank()){
            throw new IllegalArgumentException("Especialidade Inválida!!");
        }
        else{
            this.especialidade = especialidade;
        }
    }

    public void setCrm(int crm){
        if (crm <= 0){
            throw new IllegalArgumentException("CRM Inválido!!");
        }
        else{
            this.crm = crm;
        }
    }

    public void setCusto_da_consulta(double custo_da_consulta){
        if (custo_da_consulta <= 0){
            throw new IllegalArgumentException("Custo da Consulta Inválido!!");
        }
        else{
            this.custo_da_consulta = custo_da_consulta;
        }
    }


    public String getNome(){
        return nome;
    }
    public int getCrm(){
        return crm;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public double getCusto_da_consulta(){
        return custo_da_consulta;
    }
    public String[][] getAgenda_de_horarios(){
        return agenda_de_horarios;
    }

}
