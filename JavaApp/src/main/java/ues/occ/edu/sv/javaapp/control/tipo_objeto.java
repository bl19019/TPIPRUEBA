/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.javaapp.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.javaapp.entity.TipoObjeto;

/**
 *
 * @author bryan
 */
public class tipo_objeto {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("TPI_PERSITENCIA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        
        public boolean crear(TipoObjeto crear){
        
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
        
        public boolean actualizar(TipoObjeto actualizar){
        
            try {
                et.begin();
                em.find(TipoObjeto.class, actualizar.getIdTipoObjeto());
                em.merge(actualizar);
                et.commit();
                return true;
            } catch (Exception e) {
                et.rollback();
            }
            return false;
        }
        
        public boolean borrar (Integer Id){
        
            TipoObjeto borrar;
            borrar  = em.getReference(TipoObjeto.class, Id);
            
            try {
            et.begin();
            borrar.getIdTipoObjeto();
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
            em.createQuery("SELECT * FROM estado WHERE tipo_objeto="+Id);
            et.commit();
            System.out.println("Registo con Id"+Id+" Encontado con Exito");
            return true;
            } catch (Exception e) {
                et.rollback();
                
            }
            return false;
        
        }
        
    
}
