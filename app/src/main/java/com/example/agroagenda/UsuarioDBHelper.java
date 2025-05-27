package com.example.agroagenda;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AgendaDB";
    private static final int DATABASE_VERSION = 1;

    // Nombre de la tabla
    private static final String TABLE_USUARIOS = "usuarios";

    // Columnas de la tabla
    private static final String KEY_ID = "id";
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_APELLIDO = "apellido";
    private static final String KEY_EXTENSION = "extension";
    private static final String KEY_PUESTO = "puesto";
    private static final String KEY_SUCURSAL = "sucursal";
    private static final String KEY_DEPARTAMENTO = "departamento";

    public UsuarioDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USUARIOS_TABLE = "CREATE TABLE " + TABLE_USUARIOS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOMBRE + " TEXT,"
                + KEY_APELLIDO + " TEXT,"
                + KEY_EXTENSION + " TEXT,"
                + KEY_PUESTO + " TEXT,"
                + KEY_SUCURSAL + " TEXT,"
                + KEY_DEPARTAMENTO + " TEXT" + ")";
        db.execSQL(CREATE_USUARIOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si hay cambios en la estructura de la base de datos
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        onCreate(db);
    }

    // Métodos CRUD

    // Agregar un nuevo usuario
    public long agregarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMBRE, usuario.getNombre());
        values.put(KEY_APELLIDO, usuario.getApellido());
        values.put(KEY_EXTENSION, usuario.getExtension());
        values.put(KEY_PUESTO, usuario.getPuesto());
        values.put(KEY_SUCURSAL, usuario.getSucursal());
        values.put(KEY_DEPARTAMENTO, usuario.getDepartamento());
        long newRowId = db.insert(TABLE_USUARIOS, null, values);
        db.close();
        return newRowId;
    }

    // Obtener un usuario por ID
    public Usuario getUsuario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USUARIOS, new String[]{KEY_ID, KEY_NOMBRE, KEY_APELLIDO, KEY_EXTENSION, KEY_PUESTO, KEY_SUCURSAL, KEY_DEPARTAMENTO},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Usuario usuario = new Usuario(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        usuario.setId(Integer.parseInt(cursor.getString(0)));
        cursor.close();
        db.close();
        return usuario;
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USUARIOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(cursor.getString(0)));
                usuario.setNombre(cursor.getString(1));
                usuario.setApellido(cursor.getString(2));
                usuario.setExtension(cursor.getString(3));
                usuario.setPuesto(cursor.getString(4));
                usuario.setSucursal(cursor.getString(5));
                usuario.setDepartamento(cursor.getString(6));
                listaUsuarios.add(usuario);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaUsuarios;
    }

    // Actualizar un usuario
    public int actualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMBRE, usuario.getNombre());
        values.put(KEY_APELLIDO, usuario.getApellido());
        values.put(KEY_EXTENSION, usuario.getExtension());
        values.put(KEY_PUESTO, usuario.getPuesto());
        values.put(KEY_SUCURSAL, usuario.getSucursal());
        values.put(KEY_DEPARTAMENTO, usuario.getDepartamento());
        int rowsAffected = db.update(TABLE_USUARIOS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(usuario.getId())});
        db.close();
        return rowsAffected;
    }

    // Eliminar un usuario
    public void eliminarUsuario(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USUARIOS, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    // Obtener la cantidad de usuarios
    public int getUsuariosCount() {
        String countQuery = "SELECT * FROM " + TABLE_USUARIOS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count;
    }

    // Filtrar usuarios
    public List<Usuario> filtrarUsuarios(String textoFiltro) {
        List<Usuario> listaFiltrada = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = KEY_NOMBRE + " LIKE ? OR " +
                KEY_APELLIDO + " LIKE ? OR " +
                KEY_EXTENSION + " LIKE ? OR " +
                KEY_PUESTO + " LIKE ? OR " +
                KEY_SUCURSAL + " LIKE ? OR " +
                KEY_DEPARTAMENTO + " LIKE ?";
        String[] selectionArgs = new String[]{"%" + textoFiltro + "%", "%" + textoFiltro + "%", "%" + textoFiltro + "%", "%" + textoFiltro + "%", "%" + textoFiltro + "%", "%" + textoFiltro + "%"};
        Cursor cursor = db.query(TABLE_USUARIOS, null, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(cursor.getString(0)));
                usuario.setNombre(cursor.getString(1));
                usuario.setApellido(cursor.getString(2));
                usuario.setExtension(cursor.getString(3));
                usuario.setPuesto(cursor.getString(4));
                usuario.setSucursal(cursor.getString(5));
                usuario.setDepartamento(cursor.getString(6));
                listaFiltrada.add(usuario);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaFiltrada;
    }
}