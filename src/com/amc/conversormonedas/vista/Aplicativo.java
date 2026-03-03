package com.amc.conversormonedas.vista;

import com.amc.conversormonedas.modelo.Constantes;
import com.amc.conversormonedas.modelo.Exchangerate;
import com.amc.conversormonedas.modelo.Moneda;
import com.amc.conversormonedas.modelo.Opcion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Aplicativo {
    private final Moneda monedaPrincipal;
    private final List<Moneda> configMonedas;
    private List<Opcion> menu;
    private final Scanner lectura;

    public Aplicativo(Moneda monedaPrincipal, List<Moneda> configMonedas) {
        this.monedaPrincipal = monedaPrincipal;
        this.configMonedas = configMonedas;
        this.menu = new ArrayList<>();
        this.lectura = new Scanner(System.in);
    }

    public void generarMenu() {
        int contador = 0;
        for(Moneda mon: this.configMonedas) {
            contador++;
            this.menu.add(new Opcion(contador, this.monedaPrincipal, mon));
            contador++;
            this.menu.add(new Opcion(contador, mon, this.monedaPrincipal));
        }
        contador++;
        this.menu.add(new Opcion(contador));
    }

    private void imprimirMenu() {
        System.out.println(Constantes.SEPARADOR);
        System.out.println(Constantes.TEXTO_BIENVENIDA + "\n");
        for(Opcion op: this.menu) {
            if(!op.salir())
                System.out.println("[" + op.getNumero() + "] " + op.getBase().getNombre() + " -> " + op.getTarget().getNombre());
            else
                System.out.println("[" + op.getNumero() + "] " + Constantes.TEXTO_SALIR);
        }
        System.out.println(Constantes.TEXTO_INGRESAR_OPCION);
        System.out.println(Constantes.SEPARADOR + "\n");
    }

    private int solicitarOpcion() {
        while(true) {
            try {
                int opcionElegida = this.lectura.nextInt();
                if(opcionElegida > 0 && opcionElegida <= this.menu.size())
                    return opcionElegida;
                else
                    System.out.println(Constantes.TEXTO_ERROR_OPCION_OUT_OF_BOUNDS);
            } catch (InputMismatchException e) {
                System.out.println(Constantes.TEXTO_ERROR_OPCION_NO_NUMERICA);
                this.lectura.next();
            }
        }
    }

    private double solicitarValor() {
        System.out.println(Constantes.TEXTO_INGRESAR_VALOR);
        while(true) {
            try {
                double valorIngresado = this.lectura.nextDouble();
                if(valorIngresado > 0)
                    return valorIngresado;
                else
                    System.out.println(Constantes.TEXTO_ERROR_VALOR_NEGATIVO);
            } catch (InputMismatchException e) {
                System.out.println(Constantes.TEXTO_ERROR_VALOR_NO_NUMERICO);
                this.lectura.next();
            }
        }
    }

    public void iniciar() {
        while(true) {
            this.imprimirMenu();
            int respuesta = this.solicitarOpcion();
            if(respuesta == this.menu.size()) break;
            double valor = this.solicitarValor();
            String base = "", target = "";
            for(Opcion op: this.menu) {
                if(op.getNumero() == respuesta) {
                    base = op.getBase().getCodigo();
                    target = op.getTarget().getCodigo();
                    break;
                }
            }
            this.convertir(base, target, valor);
        }
    }

    private void convertir(String base, String target, double valor) {
        Exchangerate api = new Exchangerate();
        try {
            double response = api.convertir(base, target, valor);
            String salida = Constantes.TEXTO_RESPUESTA
                    .replaceAll("INGRESAR_VALOR_BASE", String.format("%.2f", valor))
                    .replaceAll("INGRESAR_MONEDA_BASE", base)
                    .replaceAll("INGRESAR_VALOR_TARGET", String.format("%.2f", response))
                    .replaceAll("INGRESAR_MONEDA_TARGET", target);
            System.out.println(salida);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }


}
