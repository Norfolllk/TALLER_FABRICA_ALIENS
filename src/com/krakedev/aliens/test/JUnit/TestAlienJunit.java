package com.krakedev.aliens.test.JUnit;

import com.krakedev.aliens.Alien;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAlienJunit {

    @Test
    public void testAtributosAsignadosCorrectamente() {
        Alien alien = new Alien(15, "Verde");
        assertEquals(15, alien.getTamanio());
        assertEquals("Verde", alien.getColor());
    }

    @Test
    public void testTamanioMenorAlMinimo() {
        Alien alien = new Alien(2, "Azul");
        assertEquals(5, alien.getTamanio());
    }

    @Test
    public void testTamanioMayorAlMaximo() {
        Alien alien = new Alien(50, "Rojo");
        assertEquals(30, alien.getTamanio());
    }

    @Test
    public void testCalculoDePrecios() {
        Alien alien = new Alien(20, "Amarillo");
        assertEquals(4.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(2.0, alien.getPrecioExtremidad(), 0.001);
        assertEquals(1.0, alien.getPrecioOjo(), 0.001);
    }
    
    @Test
    public void testAgregarBrazosCasoValido() {
        Alien alien = new Alien(15, "Verde");
        assertTrue(alien.agregarBrazos(4));
        assertEquals(4, alien.getNumeroBrazos());
    }

    @Test
    public void testAgregarBrazosCasoLimite() {
        Alien alien = new Alien(15, "Verde");
        assertTrue(alien.agregarBrazos(10));
        assertFalse(alien.agregarBrazos(1));
    }

    @Test
    public void testAgregarBrazosYPiernasCombinado() {
        Alien alien = new Alien(15, "Verde");
        assertTrue(alien.agregarBrazos(6));
        assertTrue(alien.agregarPiernas(4));
        assertFalse(alien.agregarPiernas(1));
    }
    
    @Test
    public void testAgregarOjosCasoValidoTamanioPequenio() {
        Alien alien = new Alien(8, "Verde");
        assertTrue(alien.agregarOjos(3));
        assertFalse(alien.agregarOjos(1));
    }

    @Test
    public void testAgregarOjosTamanioMedio() {
        Alien alien = new Alien(15, "Verde");
        assertTrue(alien.agregarOjos(5));
        assertFalse(alien.agregarOjos(1));
    }

    @Test
    public void testAgregarOjosTamanioGrande() {
        Alien alien = new Alien(25, "Verde");
        assertTrue(alien.agregarOjos(7));
        assertFalse(alien.agregarOjos(1));
    }
    
    @Test
    public void testCalculoPrecioTotalDespuesDeAgregarElementos() {
        Alien alien = new Alien(20, "Verde");
        alien.agregarBrazos(2);
        alien.agregarPiernas(2);
        alien.agregarOjos(3);

        double esperado = alien.getPrecioCuerpo()
                + (4 * alien.getPrecioExtremidad())
                + (3 * alien.getPrecioOjo());

        assertEquals(esperado, alien.getPrecioTotal(), 0.001);
    }

    @Test
    public void testPrecioTotalInicialEsCero() {
        Alien alien = new Alien(20, "Verde");
        assertEquals(0, alien.getPrecioTotal(), 0.001);
    }

    @Test
    public void testPrecioTotalNoCambiaSiSeExcedeLimiteDeExtremidades() {
        Alien alien = new Alien(20, "Verde");
        alien.agregarBrazos(10);
        double precioConDiez = alien.getPrecioTotal();
        alien.agregarPiernas(5); // excede el limite de 10, no debe agregarse
        assertEquals(precioConDiez, alien.getPrecioTotal(), 0.001);
    }

    @Test
    public void testPrecioTotalNoCambiaSiSeExcedeLimiteDeOjos() {
        Alien alien = new Alien(20, "Verde");
        alien.agregarOjos(5); // maximo para tamaño 20
        double precioConCincoOjos = alien.getPrecioTotal();
        alien.agregarOjos(1); // excede el maximo, no debe agregarse
        assertEquals(precioConCincoOjos, alien.getPrecioTotal(), 0.001);
    }

    @Test
    public void testComportamientoCompletoAlAgregarElementosEnPasos() {
        Alien alien = new Alien(25, "Verde");

        assertTrue(alien.agregarBrazos(3));
        assertTrue(alien.agregarPiernas(2));
        assertTrue(alien.agregarOjos(4));

        assertEquals(3, alien.getNumeroBrazos());
        assertEquals(2, alien.getNumeroPies());
        assertEquals(4, alien.getNumeroOjos());

        double esperado = alien.getPrecioCuerpo()
                + (5 * alien.getPrecioExtremidad())
                + (4 * alien.getPrecioOjo());

        assertEquals(esperado, alien.getPrecioTotal(), 0.001);
    }
}