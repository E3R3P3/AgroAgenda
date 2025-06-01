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
    private Button btnAgregar;

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
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34021", "Gerente", "Higuey", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34022", "Sub-gerente", "Higuey", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34023", "Contable", "Higuey", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34024", "Oficial de Negocios", "Higuey", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34025", "Oficial de Negocios", "Higuey", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34031", "Gerente", "San Cristobal", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34032", "Sub-gerente", "San Cristobal", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34033", "Contable", "San Cristobal", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34034", "Oficial de Negocios", "San Cristobal", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34035", "N/A", "San Cristobal", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34041", "Gerente", "Barahona", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34042", "Sub-gerente", "Barahona", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34043", "Contable", "Barahona", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34044", "Oficial de Negocios", "Barahona", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34045", "Oficial de Negocios", "Barahona", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34051", "Gerente", "San Juan", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34052", "Sub-gerente", "San Juan", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34053", "Contable", "San Juan", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34054", "Analista", "San Juan", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34055", "Oficial de Negocios", "San Juan", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34061", "Contable", "San Frnacisco", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34062", "Director Regional", "San Frnacisco", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34063", "Gerente", "San Frnacisco", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34064", "Sub-gerente", "San Frnacisco", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34065", "Oficial de Negocios", "San Frnacisco", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34071", "Gerente", "Comendador", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34072", "Sub-gerente", "Comendador", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34073", "Contable", "Comendador", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34074", "Oficial de Negocios", "Comendador", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34075", "Agente de Desarrollo", "Comendador", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34081", "Sub-gerente", "Cotui", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34082", "Oficial de Negocios", "Cotui", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34083", "Contable", "Cotui", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34084", "Analista", "Cotui", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34091", "Gerente", "La Vega", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34092", "Director Regional", "La Vega", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34093", "Contable", "La Vega", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34094", "Oficial de Negocios", "La Vega", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34095", "Analista", "La Vega", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34101", "Gerente", "Santiago Rodriguez", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34102", "Oficial de Negocios", "Santiago Rodriguez", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34103", "Analista", "Santiago Rodriguez", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34104", "Sub-gerente", "Santiago Rodriguez", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34105", "Contable", "Santiago Rodriguez", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34111", "Gerente", "Montecristi", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34112", "Sub-gerente", "Montecristi", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34113", "Oficial de Negocios", "Montecristi", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34114", "Contable", "Montecristi", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34115", "Analista", "Montecristi", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34121", "Gerente", "Puerto Plata", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34122", "Sub-gerente", "Puerto Plata", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34123", "Oficial de Negocios", "Puerto Plata", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34124", "Oficial de Negocios", "Puerto Plata", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34125", "Contable", "Puerto Plata", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34131", "Oficial de Negocios", "Nagua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34132", "Contable", "Nagua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34133", "Gerente", "Nagua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34134", "Sub-gerente", "Nagua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34135", "Oficial de Negocios", "Nagua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34151", "Gerente", "Seybo", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34152", "Sub-gerente", "Seybo", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34153", "Analista", "Seybo", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34154", "Oficial de Negocios", "Seybo", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34161", "Gerente", "Santiago", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34162", "us", "Santiago", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34163", "Contable", "Santiago", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34164", "Analista", "Santiago", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34165", "Oficial de Negocios", "Santiago", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34171", "Gerente", "Ocoa", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34172", "Sub-gerente", "Ocoa", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34173", "Contable", "Ocoa", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34174", "Oficial de Negocios", "Ocoa", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34175", "Oficial de Negocios", "Ocoa", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34181", "Gerente", "Azua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34182", "Sub-gerente", "Azua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34183", "Contable", "Azua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34184", "Oficial de Negocios", "Azua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34185", "Oficial de Negocios", "Azua", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34191", "Gerente", "Bani", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34192", "Sub-gerente", "Bani", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34193", "Contable", "Bani", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34194", "Analista", "Bani", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34195", "Oficial de Negocios", "Bani", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34201", "Gerente", "Mao", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34202", "Sub-gerente", "Mao", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34203", "Contable", "Mao", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34204", "oficial de Negocios", "Mao", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34205", "Agente de Desarrollo", "Mao", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34211", "Gerente", "Arenoso", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34212", "Sub-gerente", "Arenoso", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34213", "Contable", "Arenoso", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34214", "Oficial de Negocios", "Arenoso", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34215", "Agente de Desarrollo", "Arenoso", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34221", "Gerente", "Hato Mayor", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34222", "Contable", "Hato Mayor", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34223", "Analista", "Hato Mayor", "N/A"));
        dbHelper.agregarUsuario(new Usuario("N/A", "N/A", "34224", "Sub-gerente", "Hato Mayor", "N/A"));
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