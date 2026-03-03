package com.amc.conversormonedas.modelo;

public class Opcion {
    private int numero;
    private Moneda base;
    private Moneda target;
    private boolean salir;

    public Opcion(int numero, Moneda base, Moneda target) {
        this.numero = numero;
        this.base = base;
        this.target = target;
        this.salir = false;
    }

    public Opcion(int numero) {
        this.numero = numero;
        this.salir = true;
    }

    public int getNumero() {
        return numero;
    }

    public Moneda getBase() {
        return base;
    }

    public Moneda getTarget() {
        return target;
    }

    public boolean salir() {
        return salir;
    }
}
