package com.cep.api.service;

import com.cep.api.client.CepClient;
import com.cep.api.model.CepRequest;
import com.cep.api.model.CepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CepService {

    @Autowired
    private CepClient client;


    public CepResponse cepResponse(CepRequest cepRequest) throws IOException, InterruptedException {
        return client.clientBuscaCep(cepRequest.getCep());

    }
}
