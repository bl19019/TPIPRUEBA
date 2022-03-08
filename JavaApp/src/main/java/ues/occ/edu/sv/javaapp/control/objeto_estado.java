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
import ues.occ.edu.sv.javaapp.entity.ObjetoEstado;

/**
 *
 * @author bryan
 */
public class objeto_estado {
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("TPI_PERSITENCIA");
   EntityManager em = emf.createEntityManager();
   EntityTransaction et=em.getTransaction(); 
   
   public boolean crear(ObjetoEstado crear){
   
       try {
           et.begin();
           em.persist(crear);
           et.commit();
           return true;
       } catch (Exception e) {
           et.rollback();
       }
       return false;
   }
   
   public boolean actualizar(ObjetoEstado actualizar){
   
       try {
           et.begin();
            em.find(ObjetoEstado.class, actualizar.getIdObjetoEstado());
            em.merge(actualizar);
            et.commit();
            return true;
       } catch (Exception e) {
           et.rollback();
           return false;
       }
   
   }
   
   public boolean borrar(Long Id){
       ObjetoEstado borrar;
       borrar = em.getReference(ObjetoEstado.class, Id);
       
       try {
           et.begin();
            borrar.getIdObjetoEstado();
            em.remove(borrar);
            et.commit();
            return true;
       } catch (Exception e) {
           et.rollback();
                   
       }
       return false;
   }
   
   public boolean leer(Long Id){
   
       
       try {
           et.begin();
           em.createQuery("SELECT * FROM estado WHERE id_objeto_esatdo="+Id);
           et.commit();
           System.out.println("Registo con Id"+Id+" Encontado con Exito");
           return true;
       } catch (Exception e) {
           et.rollback();
       }
       return false;
   }
}
