package com.cep.api.service;

import com.cep.api.model.CepRequest;
import org.springframework.stereotype.Service;


@Service
public class FIlterServiceCep {

    public CepRequest recebeCep (CepRequest cepRequest){


       while (cepRequest.getCep().contains("-"))
       {
           cepRequest.setCep(cepRequest.getCep().replace("-",""));
       }

        while (cepRequest.getCep().contains(" "))
        {
            cepRequest.setCep(cepRequest.getCep().replace(" ",""));
        }


        return cepRequest;
    }
}
