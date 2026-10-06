/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatesalaaula;

import com.mycompany.hibernatesalaaula.entities.Bombeiro;
import com.mycompany.hibernatesalaaula.util.HibernateUtil;
import java.time.LocalDate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class GerenciarBombeiro {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        System.out.println("Sessão estabelecida");
        Transaction transaction = null;
        
        Bombeiro bombeiro = new Bombeiro();
        bombeiro.setCpf("12345678");
        bombeiro.setDataNascimento(LocalDate.of(1990, 2, 2));
        bombeiro.setNome("Fulano da Silva");
        bombeiro.setNomeGuerra("Silva");
        
        try {
            transaction = session.beginTransaction();
            session.persist(bombeiro);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        
        HibernateUtil.shutdown();
    }
}