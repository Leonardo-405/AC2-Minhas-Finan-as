package com.example.minhasfinancas;

import android.util.Log;

import java.util.ArrayList;
public class GastoRepository {
    private static ArrayList<Gasto> listaGastos = new ArrayList<>();

    public static void adicionarGasto(Gasto gasto) {
        Log.d("GastoRepository", "Gasto adicionado: " + gasto.toString());
        listaGastos.add(gasto);
    }

    public static ArrayList<Gasto> getListaGastos() {
        Log.d("GastoRepository", "getListaGastos chamado. Tamanho da lista: " + listaGastos.size());
        return listaGastos;
    }
}