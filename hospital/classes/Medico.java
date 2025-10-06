package hospital.classes;

public class Medico{
    private String nome;
    private String sobrenome;
    private String nomeCompleto;
    private int crm;
    private String especialidade;
    private double custo_da_consulta;
    private String[][] agenda_de_horarios;

    public Medico(String nome, String sobrenome, int crm, String especialidade, double custo_da_consulta, String[][] agenda_de_horarios){
        this.setNome(nome);
        this.setSobrenome(sobrenome);
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
            String nomeFormatado = nome.substring(0, 1).toUpperCase();
            String restante = nome.substring(1).toLowerCase();
            this.nome = nomeFormatado + restante;
        }
    }

    public void setSobrenome(String sobrenome){
        if(sobrenome.isBlank()){
            throw new IllegalArgumentException("Nome Inválido!!");
        }
        else{
            String sobrenomeFormatado = sobrenome.substring(0, 1).toUpperCase();
            String restante2 = sobrenome.substring(1).toLowerCase();
            this.sobrenome = sobrenomeFormatado + restante2;
        }
    }


    public void setEspecialidade(String especialidade){
        if (especialidade.isBlank()){
            throw new IllegalArgumentException("Especialidade Inválida!!");
        }
        else{
            String especialidadeFormatada = especialidade.substring(0, 1).toUpperCase();
            String restante = especialidade.substring(1).toLowerCase();
            this.especialidade = especialidadeFormatada + restante;
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



    public String getNomeCompleto(){
        return nome + sobrenome;
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
