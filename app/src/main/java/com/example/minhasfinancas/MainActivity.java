// MainActivity.java
package com.example.minhasfinancas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAdicionarGasto, btnResumoCategoria;
    private ListView listViewGastos;
    private GastoAdapter gastoAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume chamado");
        // Recria o adapter sempre que a tela volta ao foreground para garantir dados atualizados
        gastoAdapter = new GastoAdapter(this, GastoRepository.getListaGastos());
        Log.d("MainActivity", "onResume: Tamanho da lista ao criar adapter: " + GastoRepository.getListaGastos().size());
        listViewGastos.setAdapter(gastoAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdicionarGasto = findViewById(R.id.btnAdicionarGasto);
        btnResumoCategoria = findViewById(R.id.btnResumoCategoria);
        listViewGastos = findViewById(R.id.listViewGastos);

        btnAdicionarGasto.setOnClickListener(view -> {
            Log.d("MainActivity", "Botão Adicionar Gasto clicado");
            startActivity(new Intent(MainActivity.this, CadastroGastoActivity.class));
        });

        btnResumoCategoria.setOnClickListener(view -> {
            Log.d("MainActivity", "Botão Resumo por Categoria clicado");
            startActivity(new Intent(MainActivity.this, ResumoCategoriaActivity.class));
        });
    }
}