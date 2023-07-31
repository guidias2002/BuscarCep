package classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public Endereco buscarEndereco(String endereco) throws IOException, InterruptedException {
        URI urlEndereco = URI.create("https://viacep.com.br/ws/" + endereco + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlEndereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível encontrar esse cep.");
        }
    }
}
