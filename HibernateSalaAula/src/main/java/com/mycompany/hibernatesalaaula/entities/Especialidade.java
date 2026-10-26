/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatesalaaula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author aluno
 */

@Entity
@Table(name = "Especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esp_id")
    private Integer id;
    @Column(name = "descricao", unique = false, nullable = false, length = 20)
    private String descricao;
    @OneToMany(mappedBy = "especialidade")
    private List<Bombeiro> bombeiro;

    public Especialidade() {
    }

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

    public List<Bombeiro> getBombeiro() {
        return bombeiro;
    }

    public void setBombeiro(List<Bombeiro> bombeiro) {
        this.bombeiro = bombeiro;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Especialidade aux) {
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
