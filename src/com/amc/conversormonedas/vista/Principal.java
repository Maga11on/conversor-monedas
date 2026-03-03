package com.amc.conversormonedas.vista;

import com.amc.conversormonedas.modelo.Moneda;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Moneda peso = new Moneda("MXN", "Peso Méxicano");
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda("USD", "Dólar americano"));
        monedas.add(new Moneda("EUR", "Euro"));
        monedas.add(new Moneda("GBP", "Libra"));

        Aplicativo sistema = new Aplicativo(peso, monedas);
        sistema.generarMenu();
        sistema.iniciar();
    }
}
