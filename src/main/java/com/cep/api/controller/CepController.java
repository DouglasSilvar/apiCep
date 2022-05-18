package com.cep.api.controller;

import com.cep.api.model.CepRequest;
import com.cep.api.model.CepResponse;
import com.cep.api.service.CepService;
import com.cep.api.service.FIlterServiceCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RestController
@RequestMapping(value = "/cep")
public class CepController {

    final private CepService service;
    final private FIlterServiceCep filter;

    public CepController(CepService service, FIlterServiceCep filter) {
        this.service = service;
        this.filter = filter;
    }

    @PostMapping
    public ResponseEntity<CepResponse> cepRequest(@RequestBody CepRequest request) throws IOException, InterruptedException {

       var filterResponses =  filter.recebeCep(request);
        var responses = service.cepResponse(filterResponses);

        return ResponseEntity.ok(responses);
    }
}
