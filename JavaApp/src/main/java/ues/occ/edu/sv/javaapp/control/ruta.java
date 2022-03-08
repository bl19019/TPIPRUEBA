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
import ues.occ.edu.sv.javaapp.entity.Ruta;

/**
 *
 * @author bryan
 */
public class ruta {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("TPI_PERSITENCIA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et=em.getTransaction();  
        
        
        public boolean crear(Ruta nuevo){
        
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
        
        public boolean actualizar(Ruta actualizar){
            try {
            et.begin();
            em.find(Estado.class, actualizar.getIdRuta());
            em.merge(actualizar);
            et.commit();
            return true;
            } catch (Exception e) {
                et.rollback();
            }
            return false;
        
        }
        
        public boolean borrar(Long Id){
        
            Ruta borrar;
            borrar =  em.getReference(Ruta.class, Id);
            
            try {
            et.begin();
            borrar.getIdRuta();
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
            em.createQuery("SELECT * FROM ruta WHERE id_ruta="+Id);
            et.commit();
            System.out.println("Registo con Id"+Id+" Encontado con Exito");
            return true;
            } catch (Exception e) {
                et.rollback();
                
            }
            return false;
        }
}
