package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ComercialTest {
	
	Comercial comercial;

	@BeforeEach
	void setUp() throws Exception {
		comercial= new Comercial ("11111111H","Paco","Ruiz Gonzalez",1100.0,10.5);
	}
	
	@Test
	@DisplayName("Prueba excepcion ventas negativas constructor")
	void excepcionPrecioNegativo() throws Exception {
		Exception excepcion=assertThrows(IllegalArgumentException.class, ()->new Comercial ("11111111H","Julián","Perez López",1300.0,-40));
		String mensajeEsperado="Las ventas no pueden ser negativas";
		assertEquals(mensajeEsperado, excepcion.getMessage(), "Error en el mensaje de la excepción");
	}
	
	@Test
	@DisplayName("Debe devolver el total de ventas acumuladas")
	void testGetVentas() {
		double resultadoEsperado=10.5;
		double resultadoObtenido=comercial.getVentas();
		assertEquals(resultadoEsperado, resultadoObtenido, "No se ha obtenido las ventas correctas");
	}
	
	@Test
	@DisplayName("Debe devolver el total de ventas acumuladas")
	void testSetVentas() {
		double resultadoEsperado=20;
		comercial.setVentas(resultadoEsperado);
		double resultadoObtenido=comercial.getVentas();
		assertEquals(resultadoEsperado, resultadoObtenido, "No se ha obtenido las ventas correctas");
	}
	
	@Test
	@DisplayName("Test excepcion setVentas")
	void pruebaExcepcionSetVentas() {
		Exception excepcion=assertThrows(IllegalArgumentException.class,()->comercial.setVentas(-55.5));	
		String mensajeEsperado="Las ventas no pueden ser negativas";
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
	
	@Test
	@DisplayName("Debe devolver el monto extra calculado sobre las ventas")
	void testCalcularExtra() {
		double resultadoEsperado=1.05;
		double resultadoObtenido=comercial.getVentas()*0.1;
		assertEquals(resultadoEsperado, resultadoObtenido);
	
	}
	

	@Test
	@DisplayName("Debe devolver el sueldo total incluyendo el bono por ventas")
	void testGetSueldo() {
		double resultadoEsperado=1101.05;
		double resultadoObtenido=comercial.getSueldo();
		assertEquals(resultadoEsperado, resultadoObtenido);
	
	}

}
