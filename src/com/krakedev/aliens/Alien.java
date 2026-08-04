package com.krakedev.aliens;

public class Alien {

    private static final int TAMANIO_MIN = 5;
    private static final int TAMANIO_MAX = 30;

    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPies;
    private double precioExtremidad;
    private double precioOjo;
    private double precioCuerpo;

    public Alien(int tamanio, String color) {
        if (tamanio < TAMANIO_MIN) {
            tamanio = TAMANIO_MIN;
        } else if (tamanio > TAMANIO_MAX) {
            tamanio = TAMANIO_MAX;
        }
        this.tamanio = tamanio;
        this.color = color;
        this.numeroOjos = 0;
        this.numeroBrazos = 0;
        this.numeroPies = 0;

        this.precioCuerpo = this.tamanio * 0.20;
        this.precioExtremidad = this.tamanio * 0.10;
        this.precioOjo = this.tamanio * 0.05;
    }

    public int getTamanio() {
        return tamanio;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroOjos() {
        return numeroOjos;
    }

    public int getNumeroBrazos() {
        return numeroBrazos;
    }

    public int getNumeroPies() {
        return numeroPies;
    }

    public double getPrecioExtremidad() {
        return precioExtremidad;
    }

    public double getPrecioOjo() {
        return precioOjo;
    }

    public double getPrecioCuerpo() {
        return precioCuerpo;
    }

    public void imprimir() {
        System.out.println("----- ALIEN -----");
        System.out.println("Tamanio: " + tamanio);
        System.out.println("Color: " + color);
        System.out.println("Numero de ojos: " + numeroOjos);
        System.out.println("Numero de brazos: " + numeroBrazos);
        System.out.println("Numero de pies: " + numeroPies);
        System.out.println("Precio cuerpo: " + precioCuerpo);
        System.out.println("Precio extremidad: " + precioExtremidad);
        System.out.println("Precio ojo: " + precioOjo);
    }
    
    public boolean agregarBrazos(int cantidad) {
        int totalExtremidades = numeroBrazos + numeroPies + cantidad;
        if (totalExtremidades > 10) {
            return false;
        }
        numeroBrazos += cantidad;
        return true;
    }

    public boolean agregarPiernas(int cantidad) {
        int totalExtremidades = numeroBrazos + numeroPies + cantidad;
        if (totalExtremidades > 10) {
            return false;
        }
        numeroPies += cantidad;
        return true;
    }
    
    public boolean agregarOjos(int cantidad) {
        int maximoOjos;
        if (tamanio <= 10) {
            maximoOjos = 3;
        } else if (tamanio <= 20) {
            maximoOjos = 5;
        } else {
            maximoOjos = 7;
        }

        if (numeroOjos + cantidad > maximoOjos) {
            return false;
        }
        numeroOjos += cantidad;
        return true;
    }
}