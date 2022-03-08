/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.javaapp.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.javaapp.entity.Objeto;

public class objetoBean {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("TPI_PERSITENCIA");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et=em.getTransaction();
    
    public boolean crear(Objeto nuevo){
    
        try {
            et.begin();
            em.persist(nuevo);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            
        }
        return false;
    
    }
    
    public boolean actualizar(Objeto actualizar){
        try {
            et.begin();
            em.find(Objeto.class,actualizar.getIdObjeto());
            em.merge(actualizar);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            
        }
        return false;
    
    }
    
    public boolean borrar(Long Id){
        Objeto borrar;
        borrar = em.getReference(Objeto.class, Id);
        
        try {
            et.begin();
            borrar.getIdObjeto();
            em.remove(borrar);
            et.commit();
            return true;

        } catch (Exception e) {
            et.rollback();
        }
        return false;
        
    }
    
    public boolean leer (Long Id){
    
        try {
            et.begin();
            em.createQuery("SELECT * FROM objeto Where id_objeto= "+Id);
            et.commit();
            System.out.println("Registo con Id"+Id+" Encontado con Exito");
            
            return true;
        } catch (Exception e) {
            et.rollback();
        }
        return false;
    
    }
    
}
