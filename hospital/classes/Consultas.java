package hospital.classes;

import java.util.List;

public class Consultas {
    private String paciente;
   private List<String> informacoes;
    private String status;

    public Consultas(String paciente, List<String> informacoes, String status){
        this.setPaciente(paciente);
        this.setInformacoes(informacoes);
        this.setStatus(status);
    }
    public void setPaciente(String paciente){
        if(paciente.isBlank()){
            this.paciente = "";
        }
        else{
            this.paciente = paciente;
        }
    }

    public void setInformacoes(List<String> informacoes){
        if(informacoes.isEmpty()){
            this.informacoes = null;
        }
        else{
            this.informacoes = informacoes;
        }
    }

    public void setStatus(String status){
        if(status.isBlank()){
            this.status = "";
        }
        else{
            this.status = status;
        }
    }

    public String getPaciente(){
        return paciente;
    }
    public String getStatus(){
        return status;
    }
    public List<String> getInformacoes(){
        return informacoes;
    }





}
