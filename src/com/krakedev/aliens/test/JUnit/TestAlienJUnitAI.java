package com.krakedev.aliens.test.JUnit;

import com.krakedev.aliens.Alien;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAlienJUnitAI {

    // --- Constructor y validaciones de tamaño ---

    @Test
    public void testTamanioDentroDelRangoNoSeAjusta() {
        Alien alien = new Alien(18, "Negro");
        assertEquals(18, alien.getTamanio());
    }

    @Test
    public void testTamanioExactoEnLimiteMinimo() {
        Alien alien = new Alien(5, "Blanco");
        assertEquals(5, alien.getTamanio());
    }

    @Test
    public void testTamanioExactoEnLimiteMaximo() {
        Alien alien = new Alien(30, "Blanco");
        assertEquals(30, alien.getTamanio());
    }

    @Test
    public void testTamanioNegativoSeAjustaAlMinimo() {
        Alien alien = new Alien(-5, "Gris");
        assertEquals(5, alien.getTamanio());
    }

    @Test
    public void testTamanioUnPocoPorEncimaDelMaximo() {
        Alien alien = new Alien(31, "Naranja");
        assertEquals(30, alien.getTamanio());
    }

    @Test
    public void testColorSeAsignaCorrectamente() {
        Alien alien = new Alien(10, "Fucsia");
        assertEquals("Fucsia", alien.getColor());
    }

    // --- Valores iniciales (numero de ojos, brazos y pies en cero) ---

    @Test
    public void testValoresInicialesEnCero() {
        Alien alien = new Alien(15, "Verde");
        assertEquals(0, alien.getNumeroOjos());
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    // --- Calculo de precios segun el tamaño ---

    @Test
    public void testCalculoDePreciosConTamanioMinimo() {
        Alien alien = new Alien(5, "Verde");
        assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
        assertEquals(0.25, alien.getPrecioOjo(), 0.001);
    }

    @Test
    public void testCalculoDePreciosConTamanioMaximo() {
        Alien alien = new Alien(30, "Verde");
        assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
        assertEquals(1.5, alien.getPrecioOjo(), 0.001);
    }

    @Test
    public void testCalculoDePreciosSeAjustaAlTamanioCorregido() {
        // tamaño pedido 50 -> se ajusta a 30, los precios deben calcularse sobre 30, no sobre 50
        Alien alien = new Alien(50, "Rojo");
        assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
        assertEquals(1.5, alien.getPrecioOjo(), 0.001);
    }
}
