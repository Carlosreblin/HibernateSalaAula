/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatesalaaula.entities;

import java.time.LocalDate;

/**
 *
 * @author aluno
 */
public class Bombeiro {
    private Integer id;
    private String cpf;
    private LocalDate dataNascimento;
    private String nomeCompleto;
    private String nomeGuerra;
    
    public Bombeiro() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bombeiro) {
            return (((Bombeiro) obj).getId().equals(this.id) && ((Bombeiro) obj).getCpf().equals(this.cpf));
        } else {
            return false;
        }
    }
    
}