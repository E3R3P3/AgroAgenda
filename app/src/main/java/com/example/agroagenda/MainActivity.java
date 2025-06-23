package com.example.agroagenda;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUsuarios;
    private UsuarioAdapter adapter;
    private List<Usuario> listaUsuarios;
    private UsuarioDBHelper dbHelper;
    private EditText editTextFiltro;
    private Button btnAgregar, btnNumpad;
    private static final boolean DEVELOPER_MODE = false; // Cambiar a false en producción
    private static final boolean EDITABLE_MODE = false; // Cambiar a false en producción
    // Nueva variable para almacenar el InputType original del EditText
    private int originalEditTextFiltroInputType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new UsuarioDBHelper(this);

        // Resetear BD si es necesario (solo para desarrollo)
        if (DEVELOPER_MODE) {
            resetearBaseDatos();
        }
        // Lógica normal de producción
        else if (dbHelper.getUsuariosCount() == 0) {
            dbHelper.insertarDatosEjemplo();
        }

        listaUsuarios = dbHelper.getAllUsuarios();

        recyclerViewUsuarios = findViewById(R.id.recyclerViewUsuarios);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UsuarioAdapter(listaUsuarios);
        recyclerViewUsuarios.setAdapter(adapter);

        editTextFiltro = findViewById(R.id.editTextFiltro);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnNumpad = findViewById(R.id.btnNumpad); // Inicializa el nuevo botón

        // *** Guarda el InputType original del EditText al inicio ***
        originalEditTextFiltroInputType = editTextFiltro.getInputType();

        if(EDITABLE_MODE){
            adapter.setOnItemClickListener(new UsuarioAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Usuario usuarioSeleccionado = listaUsuarios.get(position);
                    Intent intent = new Intent(MainActivity.this, AgregarEditarUsuarioActivity.class);
                    intent.putExtra("usuario_id", usuarioSeleccionado.getId());
                    startActivity(intent);
                }
            });
        }else {
            Toast.makeText(this, "Edición de contenido deshabitada", Toast.LENGTH_SHORT).show();
        }


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgregarEditarUsuarioActivity.class);
                startActivity(intent);
            }
        });

        // Listener para el botón "123" que abre el teclado numérico
        btnNumpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumpad(v); // Llama a la función que ya creaste
            }
        });

        // *** Nuevo Listener para el EditTextFiltro para restaurar el teclado normal ***
        editTextFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Solo si el tipo de entrada actual es numérico, lo volvemos a cambiar a texto
                // Esto evita cambios innecesarios si ya está en modo texto
                if ((editTextFiltro.getInputType() & InputType.TYPE_CLASS_NUMBER) == InputType.TYPE_CLASS_NUMBER) {
                    editTextFiltro.setInputType(originalEditTextFiltroInputType); // Restaura el tipo original
                    // Forzar la actualización del teclado
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(editTextFiltro.getWindowToken(), 0); // Oculta el actual
                        imm.showSoftInput(editTextFiltro, InputMethodManager.SHOW_IMPLICIT); // Muestra el nuevo
                    }
                }
            }
        });

        editTextFiltro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se necesita implementación aquí
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String textoFiltro = s.toString();
                List<Usuario> listaFiltrada = dbHelper.filtrarUsuarios(textoFiltro);
                listaUsuarios.clear();
                listaUsuarios.addAll(listaFiltrada);
                adapter.actualizarLista(listaFiltrada);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se necesita implementación aquí
            }
        });
    }

    // Método para forzar el reinicio
    private void resetearBaseDatos() {
        dbHelper.resetDatabase();
        dbHelper.insertarDatosEjemplo();
        Toast.makeText(this, "Base de datos restablecida", Toast.LENGTH_SHORT).show();
    }

    // Nuevo método para abrir el teclado numérico
    public void openNumpad(View view) {
        editTextFiltro.requestFocus(); // Enfoca el EditText
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            // Establece el tipo de entrada a numérico si no lo está ya.
            // Esto asegura que el teclado numérico sea el que aparezca.
            editTextFiltro.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            imm.showSoftInput(editTextFiltro, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recargar la lista cuando se vuelve a la actividad para reflejar cambios
        listaUsuarios.clear();
        listaUsuarios.addAll(dbHelper.getAllUsuarios());
        adapter.actualizarLista(listaUsuarios);
    }
}