package com.example.minhasfinancas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CadastroGastoActivity extends AppCompatActivity {

    private EditText descricaoEditText;
    private EditText valorEditText;
    private Spinner categoriaSpinner;
    private EditText dataEditText;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_gasto);

        descricaoEditText = findViewById(R.id.editTextDescricao);
        valorEditText = findViewById(R.id.editTextValor);
        categoriaSpinner = findViewById(R.id.spinnerCategoria);
        dataEditText = findViewById(R.id.editTextData);
        btnSalvar = findViewById(R.id.btnSalvar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoriaSpinner.setAdapter(adapter);

        btnSalvar.setOnClickListener(view -> {
            String descricao = descricaoEditText.getText().toString().trim();
            String valorStr = valorEditText.getText().toString().trim();
            String categoria = categoriaSpinner.getSelectedItem().toString();
            String dataStr = dataEditText.getText().toString().trim();

            if (descricao.isEmpty() || valorStr.isEmpty() || dataStr.isEmpty()) {
                Toast.makeText(CadastroGastoActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double valor = Double.parseDouble(valorStr);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date data = sdf.parse(dataStr);
                if (data == null) {
                    Toast.makeText(CadastroGastoActivity.this, "Formato de data inválido (dd/MM/yyyy).", Toast.LENGTH_SHORT).show();
                    return;
                }
                String dataFormatada = sdf.format(data);
                Gasto novoGasto = new Gasto(descricao, String.valueOf(valor), categoria, dataFormatada);
                GastoRepository.adicionarGasto(novoGasto);
                Log.d("CadastroGastoActivity", "Gasto salvo: " + novoGasto.toString());

                Toast.makeText(CadastroGastoActivity.this, "Gasto salvo!", Toast.LENGTH_SHORT).show();
                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(CadastroGastoActivity.this, "Valor inválido.", Toast.LENGTH_SHORT).show();
            } catch (java.text.ParseException e) {
                Toast.makeText(CadastroGastoActivity.this, "Formato de data inválido (dd/MM/yyyy).", Toast.LENGTH_SHORT).show();
            }
        });
    }
}