/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.javaapp.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.javaapp.entity.Estado;


/**
 *
 * @author bryan
 */
public class estadoBen {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("TPI_PERSITENCIA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
    
    public boolean crear (Estado nuevo){

        
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
    
    public boolean actualizar(Estado actualizar){
    
        try {
            et.begin();
            em.find(Estado.class, actualizar.getIdEstado());
            em.merge(actualizar);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
        }
        return false;
 
       
    }
    
    public boolean borrar(Integer Id){
        Estado borrar;
        borrar = em.getReference(Estado.class, Id);
        try {
            et.begin();
            borrar.getIdEstado();
            em.remove(borrar);
            et.commit();
            
            return true;
            
        } catch (Exception e) {
             et.rollback();
        }
        return false;

    }
    
    public boolean leer(Integer Id){
        
        try {
            et.begin();
            em.createQuery("SELECT * FROM estado WHERE id_estado="+Id);
            et.commit();
            System.out.println("Registo con Id"+Id+" Encontado con Exito");
            return true;
            
        } catch (Exception e) {
            et.rollback();
        }
        return false;
    }
}
