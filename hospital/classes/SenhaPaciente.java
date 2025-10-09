package hospital.classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SenhaPaciente {

    private String senhaHashFinal;

    public static String verificarSenhaHash(String senhaHash){
        boolean verificar = true;
        if (senhaHash == null || senhaHash.isBlank()) {
            return null;
        }
        String tudoMaiusculo = senhaHash.substring(0).toUpperCase();
        int tamanho = tudoMaiusculo.length();
        int metade = tamanho / 2;
        String primeiraMetade = tudoMaiusculo.substring(0, metade);
        String segundaMetade = tudoMaiusculo.substring(metade);
        String Juntar = segundaMetade + primeiraMetade;
        String senhaHashFinal;
        if (senhaHash.length() < 9 && Juntar.matches(".*\\d.*")){
            String semNumero = Juntar.replaceAll("[0-2]", "l");
            String semNumero2 = semNumero.replaceAll("[3-5]", "f");
            String semNumero3 = semNumero2.replaceAll("[6-9]", "3");
            senhaHashFinal = semNumero3;
        }
        else{
            String substituto = Juntar.replaceAll("[A-D]", "rg");
            String substituto2 = substituto.replaceAll("[F-J]", "s");
            String substituto3 = substituto2.replaceAll("[P-U]", "c");
            senhaHashFinal = substituto3;
        }
        return senhaHashFinal;
    }


    public static boolean verificarLogin(String loginDigitado, String senhaHashFinal) {



        String chaveCompleta = "| Login: " + loginDigitado + " | Senha: " + senhaHashFinal;

        try (BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linha;


            while ((linha = reader.readLine()) != null) {



                if (linha.contains(chaveCompleta)) {

                    return false;
                }
            }

        } catch (IOException e) {
            System.err.println("❌ Erro ao ler o arquivo de pacientes: " + e.getMessage());

            return true;
        }


        return true;
    }
}

