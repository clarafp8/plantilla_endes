package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;

    @BeforeEach
    @DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     */
   //@Disabled
    @Test
    @DisplayName("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero

        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    }
    
    @Test
    @DisplayName("No permite contratar")
    void testContratarEmpleado() throws Exception {
    	Exception excepcion= assertThrows(IllegalArgumentException.class, ()->plantilla.contratarEmpleado(null));
    	String mensajeEsperado="No se puede contratar un empleado nulo";
    	assertEquals(mensajeEsperado, excepcion.getMessage());
    }
    

    @Test
    @DisplayName("No permite contratar")
    void testGetEmpleadosPorNombre() {
        Empleado tecnico1 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); 
        Empleado tecnico2 = new Tecnico("53931996D", "María", "Gómez",300.0,3);
        plantilla.contratarEmpleado(tecnico1);
        plantilla.contratarEmpleado(tecnico2);

        List<Empleado> resultado = plantilla.getEmpleadosPorNombre("Carlos");
        assertEquals("Carlos", resultado.get(0).getNombre());

    }
}