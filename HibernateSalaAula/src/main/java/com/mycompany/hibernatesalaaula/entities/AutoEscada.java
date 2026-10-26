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
@Table(name = "AutoEscada")
public class AutoEscada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "aue_altura_max")
    private Integer alturaMax;
    @OneToOne
    @JoinColumn(name = "via_id")
    private Viatura viatura;

    public AutoEscada() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(Integer alturaMax) {
        this.alturaMax = alturaMax;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AutoEscada) {
            AutoEscada aux = (AutoEscada) obj;
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
