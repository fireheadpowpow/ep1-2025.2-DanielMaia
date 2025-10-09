package hospital.classes;

public class Paciente_Especial extends Paciente{
    private String planoDeSaude;
    private String tipoDePrioridade;
    private String senhaHashEspecial;
    private String loginEspecial;



    public Paciente_Especial(String nome, String sobrenome, String cpf, int idade, String planoDeSaude, String tipoDePrioridade, String senhaHashEspecial){
        super(nome, sobrenome, cpf, idade, senhaHashEspecial);
        this.setPlanoDeSaude(planoDeSaude);
        this.setTipoDePrioridade(tipoDePrioridade);
        this.setSenhaHashEspecial(senhaHashEspecial);
        this.setLoginEspecial();
    }

    public void setPlanoDeSaude(String planoDeSaude){
        if(planoDeSaude.isBlank()){
            this.planoDeSaude = "";
        }
        else{
            this.planoDeSaude = planoDeSaude;
        }
    }

    public void setTipoDePrioridade(String tipoDePrioridade){
        if(tipoDePrioridade.isBlank()){
            this.tipoDePrioridade = "";
        }
        else{
            this.tipoDePrioridade = tipoDePrioridade;
        }
    }

    public void setSenhaHashEspecial(String senhaHashEspecial){
        if (senhaHashEspecial.isBlank()) {
            this.senhaHashEspecial = "";
        }
        String tudoMaiusculo = senhaHashEspecial.substring(0).toUpperCase();
        int tamanho = tudoMaiusculo.length();
        int metade = tamanho / 2;
        String primeiraMetade = tudoMaiusculo.substring(0, metade);
        String segundaMetade = tudoMaiusculo.substring(metade);
        String Juntar = segundaMetade + primeiraMetade;
        if (senhaHashEspecial.length() < 9 && Juntar.matches(".*\\d.*")){
            String semNumero = Juntar.replaceAll("[0-2]", "l");
            String semNumero2 = semNumero.replaceAll("[3-5]", "f");
            String semNumero3 = semNumero2.replaceAll("[6-9]", "3");
            this.senhaHashEspecial = semNumero3;
        }
        else{
            String substituto = Juntar.replaceAll("[A-D]", "rg");
            String substituto2 = substituto.replaceAll("[F-J]", "s");
            String substituto3 = substituto2.replaceAll("[P-U]", "c");
            this.senhaHashEspecial = substituto3;
        }

    }

    public String getSenhaHashEspecial(){
        return senhaHashEspecial;
    }

    private void setLoginEspecial(){
        this.loginEspecial = criandoLogin(getCpf());
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

    public String getLoginEspecial(){
        return loginEspecial;
    }


    public String getPlanoDeSaude() {
        return planoDeSaude;
    }
    public String getTipodeprioridade() {
        return tipoDePrioridade;
    }

}
