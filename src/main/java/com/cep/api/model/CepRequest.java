package com.cep.api.model;

public class CepRequest {

    //Pojo resposavel pelo request da nossa API

    private String cep;

    public CepRequest(){}

    public CepRequest(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "CepRequest{" +
                "cep='" + cep + '\'' +
                '}';
    }
}
