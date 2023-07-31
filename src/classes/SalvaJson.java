package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SalvaJson {
    public void arquivoJson(List<Endereco> listaEnderecos) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter("listaCep.json");
        escrita.write(gson.toJson(listaEnderecos));
        escrita.close();
    }
}
