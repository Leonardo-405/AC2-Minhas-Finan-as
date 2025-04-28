// ResumoCategoriaActivity.java
package com.example.minhasfinancas;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResumoCategoriaActivity extends AppCompatActivity {

    private TextView resumoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_categoria);

        resumoTextView = findViewById(R.id.textViewResumo);

        new CategoriaResumoTask(resumoTextView).execute();
    }
}