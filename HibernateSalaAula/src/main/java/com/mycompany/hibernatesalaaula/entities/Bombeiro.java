/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatesalaaula.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "Bombeiro")
public class Bombeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_id")
    private Integer id;
    @Column(name = "bom_cpf", unique = true, updatable = false, length = 11)
    private String cpf;
    @Column(name = "bom_data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "bom_nome_completo", nullable = false, length = 45)
    private String nome;
    @Column(name = "bom_nome_guerra", nullable = false, unique = true, length = 45)
    private String nomeGuerra;
    @ManyToOne
    @JoinColumn(name = "esp_id")
    private Especialidade especialidade;
    @ManyToOne
    @JoinColumn(name = "stb_id")
    private StatusBombeiro status;
    @OneToOne(mappedBy = "bombeiro")
    private Usuario usuario;
    @OneToMany(mappedBy = "bombeiro", fetch = FetchType.LAZY)
    private Set<TelefoneContato> telefone = new HashSet<TelefoneContato>();
    @ManyToMany
    @JoinTable(
            name = "Bombeiro_has_Patente", 
            joinColumns = @JoinColumn(name = "bom_id"),
            inverseJoinColumns = @JoinColumn(name = "pat_id")
    )
    private Set<Patente> patente = new HashSet<Patente>();
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public StatusBombeiro getStatus() {
        return status;
    }

    public void setStatus(StatusBombeiro status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<TelefoneContato> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<TelefoneContato> telefone) {
        this.telefone = telefone;
    }

    public Set<Patente> getPatente() {
        return patente;
    }

    public void setPatente(Set<Patente> patente) {
        this.patente = patente;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bombeiro aux) {
            return (aux.getCpf() == null || aux.getId() == null) ? false : (aux.getCpf().equals(this.cpf) && aux.getId().equals(this.id));
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}