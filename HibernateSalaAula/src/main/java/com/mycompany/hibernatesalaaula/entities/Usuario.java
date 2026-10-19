/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatesalaaula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(name = "usu_id")
    private Integer id;
    @Column(name = "usu_login", unique = true, nullable = false, length = 20)
    private String login;
    @Column(name = "usu_senha", unique = false, nullable = false, length = 20)
    private String senha;
    @OneToOne
    @JoinColumn(name = "bom_id", unique = true)
    private Bombeiro bombeiro;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Bombeiro getBombeiro() {
        return bombeiro;
    }

    public void setBombeiro(Bombeiro bombeiro) {
        this.bombeiro = bombeiro;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Usuario) {
            Usuario aux = (Usuario) obj;
            return (aux.getLogin() == null || aux.getId() == null) ? false : (aux.getLogin().equals(this.login) && aux.getId().equals(this.id));
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
