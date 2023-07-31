import classes.ConsultaCep;
import classes.Endereco;
import classes.SalvaJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner res = new Scanner(System.in);
        List<Endereco> listaEnderecos = new ArrayList<>();
        String cep = "";

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Pesquisar cep:");
            cep = res.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                ConsultaCep consultaCep = new ConsultaCep();
                Endereco endereco = consultaCep.buscarEndereco(cep);
                listaEnderecos.add(endereco);
                System.out.println("Adicionado na lista de ceps");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        SalvaJson salvaJson = new SalvaJson();
        salvaJson.arquivoJson(listaEnderecos);

    }
}