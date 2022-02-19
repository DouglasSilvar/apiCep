package com.cep.api.client;

import com.cep.api.model.CepResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepClient {

    //Esse metodo vai ser usado para buscar o CEP e retornar um Objeto CepResponse.

    public CepResponse clientBuscaCep(String cep) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        CepResponse cepResponse = mapper.readValue(response.body(),CepResponse.class);

        return cepResponse;

    }
}
