package com.example.minhasfinancas;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Locale;

public class GastoAdapter extends ArrayAdapter<Gasto> {

    private Context context;
    private List<Gasto> gastos;

    public GastoAdapter(@NonNull Context context, @NonNull List<Gasto> gastos) {
        super(context, 0, gastos);
        this.context = context;
        this.gastos = gastos;
        Log.d("GastoAdapter", "Adapter criado com " + (gastos != null ? gastos.size() : 0) + " itens");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Gasto gasto = gastos.get(position);
        Log.d("GastoAdapter", "getView chamado para a posição: " + position + ", Gasto: " + gasto.toString());

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gasto, parent, false);
        }

        TextView descricao = convertView.findViewById(R.id.textDescricao);
        TextView valor = convertView.findViewById(R.id.textValor);
        TextView categoria = convertView.findViewById(R.id.textCategoria);
        TextView data = convertView.findViewById(R.id.textData);

        descricao.setText(gasto.getDescricao());
        valor.setText(String.format(Locale.getDefault(), "R$ %.2f", Double.parseDouble(gasto.getValor())));
        categoria.setText(gasto.getCategoria());
        data.setText(gasto.getData());

        return convertView;
    }

    @Override
    public int getCount() {
        return gastos != null ? gastos.size() : 0;
    }

    @Nullable
    @Override
    public Gasto getItem(int position) {
        return gastos != null && position >= 0 && position < gastos.size() ? gastos.get(position) : null;
    }
}

