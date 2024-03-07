package com.matomaylla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static class Nodo {
        int valor;
        Nodo izquierdo, derecho;
        public Nodo(int item) {
            valor = item;
            izquierdo = null;
            derecho = null;
        }

    }

    public static class ArbolBinarioBusqueda {
        Nodo raiz;
        void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        Nodo insertarRec(Nodo raiz, int valor) {
            if (raiz == null) {
                raiz = new Nodo(valor);
                return raiz;
            }

            if (valor < raiz.valor)
                raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
            else if (valor > raiz.valor)
                raiz.derecho = insertarRec(raiz.derecho, valor);

            return raiz;
        }

        boolean buscar(int valor) {
            return  buscarRec(raiz, valor);
        }

        boolean buscarRec(Nodo raiz, int valor) {
            if (raiz == null)
                return false;

            if (raiz.valor == valor)
                return true;

            if (valor < raiz.valor)
                return buscarRec(raiz.izquierdo, valor);
            else
                return buscarRec(raiz.derecho, valor);
        }

        boolean buscarLineal(List<Integer> lista, int valor){
            boolean encontro = false;
            for (int i = 1; i <= lista.size(); i++) {
                if(lista.get(i) == valor){
                    encontro = true;
                    break;
                }
            }
            return encontro;
        }


    }

    public static void main(String[] args) {
        System.out.println("Inicio: Carga de lista");
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            lista.add(i);
        }
        Collections.shuffle(lista);

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        for (int num : lista) {
            arbol.insertar(num);
        }
        System.out.println("Fin: Carga de lista");
        // Valor a buscar
        int valorABuscar = 1000001;
        long inicio = System.nanoTime();
        boolean encontro = arbol.buscarLineal(lista, valorABuscar);
        long fin = System.nanoTime();
        long tiempoDeEjecucion = fin - inicio;
        System.out.println("Tiempo de ejecución busqueda lineal: " + tiempoDeEjecucion + " nanosegundos");
        if (encontro) {
            System.out.println("El valor " + valorABuscar + " se encontró en el árbol.");
        } else {
            System.out.println("El valor " + valorABuscar + " no se encontró en el árbol.");
        }



        inicio = System.nanoTime();
        boolean resultado = arbol.buscar(valorABuscar);
        fin = System.nanoTime();
        tiempoDeEjecucion = fin - inicio;
        System.out.println("Tiempo de ejecución busqueda arbol binario: " + tiempoDeEjecucion + " nanosegundos");

        // Realizar la búsqueda e imprimir el resultado
        if (resultado) {
            System.out.println("El valor " + valorABuscar + " se encontró en el árbol.");
        } else {
            System.out.println("El valor " + valorABuscar + " no se encontró en el árbol.");
        }
    }

}

