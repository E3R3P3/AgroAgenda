package com.example.agroagenda;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUsuarios;
    private UsuarioAdapter adapter;
    private List<Usuario> listaUsuarios;
    private UsuarioDBHelper dbHelper;
    private EditText editTextFiltro;
    private Button btnFiltrar, btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new UsuarioDBHelper(this);

        // Insertar datos de ejemplo si la base de datos está vacía
        if (dbHelper.getUsuariosCount() == 0) {
            insertarDatosEjemplo();
        }

        listaUsuarios = dbHelper.getAllUsuarios();

        recyclerViewUsuarios = findViewById(R.id.recyclerViewUsuarios);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UsuarioAdapter(listaUsuarios);
        recyclerViewUsuarios.setAdapter(adapter);

        editTextFiltro = findViewById(R.id.editTextFiltro);
        //btnFiltrar = findViewById(R.id.btnFiltrar);
        btnAgregar = findViewById(R.id.btnAgregar);

        adapter.setOnItemClickListener(new UsuarioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Usuario usuarioSeleccionado = listaUsuarios.get(position);
                Intent intent = new Intent(MainActivity.this, AgregarEditarUsuarioActivity.class);
                intent.putExtra("usuario_id", usuarioSeleccionado.getId());
                startActivity(intent);
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgregarEditarUsuarioActivity.class);
                startActivity(intent);
            }
        });

        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoFiltro = editTextFiltro.getText().toString();
                List<Usuario> listaFiltrada = dbHelper.filtrarUsuarios(textoFiltro);
                listaUsuarios.clear();
                listaUsuarios.addAll(listaFiltrada);
                adapter.actualizarLista(listaFiltrada);
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

    private void insertarDatosEjemplo() {
        dbHelper.agregarUsuario(new Usuario("Ana", "Pérez", "1001", "Analista", "Central", "IT"));
        dbHelper.agregarUsuario(new Usuario("Carlos", "López", "2005", "Gerente", "Norte", "Finanzas"));
        dbHelper.agregarUsuario(new Usuario("Sofía", "Gómez", "1010", "Desarrollador", "Central", "IT"));
        dbHelper.agregarUsuario(new Usuario("Javier", "Vargas", "3022", "Cajero", "Sur", "Operaciones"));
        dbHelper.agregarUsuario(new Usuario("Elena", "Ruiz", "2015", "Asistente", "Norte", "Legal"));
        dbHelper.agregarUsuario(new Usuario("Martín", "Castro", "1015", "DBA", "Central", "IT"));
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