/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ues.occ.edu.sv.javaapp.control;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ues.occ.edu.sv.javaapp.entity.Estado;

/**
 *
 * @author bryan
 */
public class estadoBenTest {
    
    public estadoBenTest() {
    }

    /**
     * Test of crear method, of class estadoBen.
     */
    @org.junit.jupiter.api.Test
    public void testCrear() {
        System.out.println("crear");
        Estado nuevo = new Estado();
        nuevo.setNombre("Hoyo");
        nuevo.setFechaCreacion(new Date());
        estadoBen instance = new estadoBen();
        boolean expResult = true;
        boolean result = instance.crear(nuevo);
        assertEquals(expResult, result);
    }
    
}
