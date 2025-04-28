package com.example.minhasfinancas;

import android.os.AsyncTask;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaResumoTask extends AsyncTask<Void, Void, String> {

    private TextView resultadoTextView;

    public CategoriaResumoTask(TextView resultadoTextView) {
        this.resultadoTextView = resultadoTextView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            Thread.sleep(3000); // Simula processamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Gasto> listaGastos = GastoRepository.getListaGastos();
        Map<String, Double> gastosPorCategoria = new HashMap<>();
        double gastoTotal = 0;
        String categoriaMaiorGasto = "";
        double maiorValor = 0;

        for (Gasto gasto : listaGastos) {
            gastoTotal += Double.parseDouble(gasto.getValor());
            gastosPorCategoria.put(gasto.getCategoria(),
                    gastosPorCategoria.getOrDefault(gasto.getCategoria(), 0.0) + Double.parseDouble(gasto.getValor()));

            if (gastosPorCategoria.get(gasto.getCategoria()) > maiorValor) {
                maiorValor = gastosPorCategoria.get(gasto.getCategoria());
                categoriaMaiorGasto = gasto.getCategoria();
            }
        }

        StringBuilder resumo = new StringBuilder();
        for (String categoria : gastosPorCategoria.keySet()) {
            resumo.append(categoria).append(": R$ ").append(String.format("%.2f", gastosPorCategoria.get(categoria))).append("\n");
        }
        resumo.append("\nTotal do mês: R$ ").append(String.format("%.2f", gastoTotal));
        resumo.append("\nCategoria com maior gasto: ").append(categoriaMaiorGasto).append(" (R$ ").append(String.format("%.2f", maiorValor)).append(")");

        return resumo.toString();
    }

    @Override
    protected void onPostExecute(String resultado) {
        super.onPostExecute(resultado);
        resultadoTextView.setText(resultado);
    }
}
