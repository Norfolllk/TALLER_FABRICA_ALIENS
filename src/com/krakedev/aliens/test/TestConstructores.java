package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {
    public static void main(String[] args) {
        Alien alien1 = new Alien(15, "Verde");
        alien1.imprimir();

        System.out.println();

        // Tamanio fuera de rango (debe ajustarse a 30)
        Alien alien2 = new Alien(50, "Morado");
        alien2.imprimir();
    }
}
