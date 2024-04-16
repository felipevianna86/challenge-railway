package com.example.challengerailway.model;

import jakarta.persistence.*;

@Entity
public class PessoaFisica extends Pessoa {
    @Column(unique = true, length = 11)
    private String cpf;
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
