/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatesalaaula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "StatusBombeiro")
public class StatusBombeiro {
    @Id
    private Integer id;
    @Column(name = "stb_descricao", unique = false, nullable = false, length = 45)
    private String descricao;
    @Column(name = "stb_sigla", unique = false, nullable = false, length = 5)
    private String sigla;
    @OneToMany(mappedBy = "status")
    private List<Bombeiro> bombeiro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Bombeiro> getBombeiro() {
        return bombeiro;
    }

    public void setBombeiro(List<Bombeiro> bombeiro) {
        this.bombeiro = bombeiro;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StatusBombeiro aux) {
            return (aux.getId() == null) ? false : (aux.getId().equals(this.id));
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
