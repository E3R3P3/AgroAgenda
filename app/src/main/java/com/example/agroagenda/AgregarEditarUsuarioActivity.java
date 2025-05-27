package com.example.agroagenda;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AgregarEditarUsuarioActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido, editTextExtension, editTextPuesto, editTextSucursal, editTextDepartamento;
    private Button btnGuardar, btnCancelar;
    private UsuarioDBHelper dbHelper;
    private Integer usuarioId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_editar_usuario);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextExtension = findViewById(R.id.editTextExtension);
        editTextPuesto = findViewById(R.id.editTextPuesto);
        editTextSucursal = findViewById(R.id.editTextSucursal);
        editTextDepartamento = findViewById(R.id.editTextDepartamento);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);
        dbHelper = new UsuarioDBHelper(this);

        if (getIntent().hasExtra("usuario_id")) {
            usuarioId = getIntent().getIntExtra("usuario_id", -1);
            if (usuarioId != -1) {
                cargarDatosUsuario(usuarioId);
            }
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String apellido = editTextApellido.getText().toString();
                String extension = editTextExtension.getText().toString();
                String puesto = editTextPuesto.getText().toString();
                String sucursal = editTextSucursal.getText().toString();
                String departamento = editTextDepartamento.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || extension.isEmpty() || puesto.isEmpty() || sucursal.isEmpty() || departamento.isEmpty()) {
                    Toast.makeText(AgregarEditarUsuarioActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Usuario usuario = new Usuario(nombre, apellido, extension, puesto, sucursal, departamento);

                if (usuarioId != null) {
                    usuario.setId(usuarioId);
                    dbHelper.actualizarUsuario(usuario);
                    Toast.makeText(AgregarEditarUsuarioActivity.this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
                } else {
                    long id = dbHelper.agregarUsuario(usuario);
                    if (id > 0) {
                        Toast.makeText(AgregarEditarUsuarioActivity.this, "Usuario guardado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AgregarEditarUsuarioActivity.this, "Error al guardar el usuario", Toast.LENGTH_SHORT).show();
                    }
                }
                finish(); // Volver a la MainActivity
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Volver a la MainActivity
            }
        });
    }

    private void cargarDatosUsuario(int id) {
        Usuario usuario = dbHelper.getUsuario(id);
        if (usuario != null) {
            editTextNombre.setText(usuario.getNombre());
            editTextApellido.setText(usuario.getApellido());
            editTextExtension.setText(usuario.getExtension());
            editTextPuesto.setText(usuario.getPuesto());
            editTextSucursal.setText(usuario.getSucursal());
            editTextDepartamento.setText(usuario.getDepartamento());
        } else {
            Toast.makeText(this, "Error al cargar los datos del usuario", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}