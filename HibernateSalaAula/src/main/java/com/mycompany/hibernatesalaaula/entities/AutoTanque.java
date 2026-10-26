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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "AutoTanque")
public class AutoTanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Integer id;
    @Column(name = "aut_litragem")
    private Integer litragem;
    @OneToOne
    @JoinColumn(name = "via_id")
    private Viatura viatura;

    public AutoTanque() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLitragem() {
        return litragem;
    }

    public void setLitragem(Integer litragem) {
        this.litragem = litragem;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AutoTanque) {
            AutoTanque aux = (AutoTanque) obj;
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
