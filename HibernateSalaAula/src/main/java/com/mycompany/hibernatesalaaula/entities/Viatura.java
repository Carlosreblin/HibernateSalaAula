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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Viatura")
public class Viatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "via_id")
    private Integer id;
    @Column(name = "via_placa", length = 7, unique = true, nullable = false)
    private String placa;
    @Column(name = "via_combustivel", length = 45, nullable = false)
    private String combustivel;
    @Column(name = "via_ultima_revisao", nullable = false)
    private LocalDate ultimaRevisao;
    @Column(name = "via_km", nullable = false)
    private Integer km;
    @ManyToOne
    @JoinColumn(name = "stv_id")
    private StatusViatura status;
    @OneToOne(mappedBy = "viatura")
    private AutoTanque autoTanque;
    @OneToOne(mappedBy = "viatura")
    private UnidadeResgate unidadeResgate;
    @OneToOne(mappedBy = "viatura")
    private AutoEscada autoEscada;
    
    public Viatura() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public LocalDate getUltimaRevisao() {
        return ultimaRevisao;
    }

    public void setUltimaRevisao(LocalDate ultimaRevisao) {
        this.ultimaRevisao = ultimaRevisao;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public StatusViatura getStatus() {
        return status;
    }

    public void setStatus(StatusViatura status) {
        this.status = status;
    }

    public AutoTanque getAutoTanque() {
        return autoTanque;
    }

    public void setAutoTanque(AutoTanque autoTanque) {
        this.autoTanque = autoTanque;
    }

    public UnidadeResgate getUnidadeResgate() {
        return unidadeResgate;
    }

    public void setUnidadeResgate(UnidadeResgate unidadeResgate) {
        this.unidadeResgate = unidadeResgate;
    }

    public AutoEscada getAutoEscada() {
        return autoEscada;
    }

    public void setAutoEscada(AutoEscada autoEscada) {
        this.autoEscada = autoEscada;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Viatura) {
            Viatura aux = (Viatura) obj;
            return (aux.getPlaca()== null || aux.getId()== null) ? false : (aux.getPlaca().equals(this.placa) && aux.getId().equals(this.id));
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}
