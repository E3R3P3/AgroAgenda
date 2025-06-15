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

    // Método para vaciar completamente la tabla
    public void resetDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USUARIOS);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_USUARIOS + "'");
        db.close();
    }

    // Método para insertar datos de ejemplo (moverlo aquí)
    public void insertarDatosEjemplo() {
        agregarUsuario(new Usuario("N/A", "N/A", "34021", "Gerente", "Higuey", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34022", "Sub-gerente", "Higuey", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34023", "Contable", "Higuey", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34024", "Oficial de Negocios", "Higuey", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34025", "Oficial de Negocios", "Higuey", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34031", "Gerente", "San Cristobal", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34032", "Sub-gerente", "San Cristobal", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34033", "Contable", "San Cristobal", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34034", "Oficial de Negocios", "San Cristobal", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34035", "N/A", "San Cristobal", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34041", "Gerente", "Barahona", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34042", "Sub-gerente", "Barahona", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34043", "Contable", "Barahona", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34044", "Oficial de Negocios", "Barahona", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34045", "Oficial de Negocios", "Barahona", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34051", "Gerente", "San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34052", "Sub-gerente", "San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34053", "Contable", "San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34054", "Analista", "San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34055", "Oficial de Negocios", "San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34061", "Contable", "San Frnacisco", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34062", "Director Regional", "San Frnacisco", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34063", "Gerente", "San Frnacisco", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34064", "Sub-gerente", "San Frnacisco", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34065", "Oficial de Negocios", "San Frnacisco", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34071", "Gerente", "Comendador", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34072", "Sub-gerente", "Comendador", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34073", "Contable", "Comendador", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34074", "Oficial de Negocios", "Comendador", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34075", "Agente de Desarrollo", "Comendador", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34081", "Sub-gerente", "Cotui", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34082", "Oficial de Negocios", "Cotui", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34083", "Contable", "Cotui", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34084", "Analista", "Cotui", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34085", "Gerente", "Cotui", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34091", "Gerente", "La Vega", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34092", "Director Regional", "La Vega", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34093", "Contable", "La Vega", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34094", "Oficial de Negocios", "La Vega", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34095", "Analista", "La Vega", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34101", "Gerente", "Santiago Rodriguez", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34102", "Oficial de Negocios", "Santiago Rodriguez", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34103", "Analista", "Santiago Rodriguez", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34104", "Sub-gerente", "Santiago Rodriguez", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34105", "Contable", "Santiago Rodriguez", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34111", "Gerente", "Montecristi", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34112", "Sub-gerente", "Montecristi", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34113", "Oficial de Negocios", "Montecristi", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34114", "Contable", "Montecristi", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34115", "Analista", "Montecristi", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34121", "Gerente", "Puerto Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34122", "Sub-gerente", "Puerto Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34123", "Oficial de Negocios", "Puerto Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34124", "Oficial de Negocios", "Puerto Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34125", "Contable", "Puerto Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34131", "Oficial de Negocios", "Nagua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34132", "Contable", "Nagua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34133", "Gerente", "Nagua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34134", "Sub-gerente", "Nagua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34135", "Oficial de Negocios", "Nagua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34151", "Gerente", "Seybo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34152", "Sub-gerente", "Seybo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34153", "Analista", "Seybo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34154", "Oficial de Negocios", "Seybo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34155", "Contable", "Seybo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34161", "Gerente", "Santiago", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34162", "sub-gerente", "Santiago", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34163", "Contable", "Santiago", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34164", "Analista", "Santiago", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34165", "Oficial de Negocios", "Santiago", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34171", "Gerente", "Ocoa", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34172", "Sub-gerente", "Ocoa", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34173", "Contable", "Ocoa", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34174", "Oficial de Negocios", "Ocoa", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34175", "Oficial de Negocios", "Ocoa", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34181", "Gerente", "Azua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34182", "Sub-gerente", "Azua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34183", "Contable", "Azua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34184", "Oficial de Negocios", "Azua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34185", "Oficial de Negocios", "Azua", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34191", "Gerente", "Bani", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34192", "Sub-gerente", "Bani", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34193", "Contable", "Bani", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34194", "Analista", "Bani", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34195", "Oficial de Negocios", "Bani", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34201", "Gerente", "Mao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34202", "Sub-gerente", "Mao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34203", "Contable", "Mao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34204", "oficial de Negocios", "Mao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34205", "Agente de Desarrollo", "Mao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34211", "Gerente", "Arenoso", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34212", "Sub-gerente", "Arenoso", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34213", "Contable", "Arenoso", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34214", "Oficial de Negocios", "Arenoso", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34215", "Agente de Desarrollo", "Arenoso", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34221", "Gerente", "Hato Mayor", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34222", "Contable", "Hato Mayor", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34223", "Analista", "Hato Mayor", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34224", "Sub-gerente", "Hato Mayor", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34225", "Agente de Desarrollo", "Hato Mayor", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34231", "Agente de Desarrollo", "Moca", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34232", "Contable", "Moca", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34233", "Gerente", "Moca", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34234", "Sub-gerente", "Moca", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34235", "Oficial de Negocios", "Moca", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34241", "Oficial de Negocios", "Samana", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34242", "Oficial de Negocios", "Samana", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34243", "Contable", "Samana", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34244", "Sub-gerente", "Samana", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34245", "Gerente", "Samana", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34251", "Oficial de Negocios", "Bonao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34252", "Analista", "Bonao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34253", "Contable", "Bonao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34254", "Sub-gerente", "Bonao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34255", "Gerente", "Bonao", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34261", "Gerente", "Neyba", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34262", "Sub-gerente", "Neyba", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34263", "Contable", "Neyba", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34264", "Analista", "Neyba", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34265", "Oficial de Negocios", "Neyba", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34271", "Gerente", "Dahabon", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34272", "Sub-gerente", "Dahabon", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34273", "Analista", "Dahabon", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34274", "Oficial de Negocios", "Dahabon", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34275", "Oficial de Negocios", "Dahabon", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34281", "Gerente", "Sajoma", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34282", "Oficial de Negocios", "Sajoma", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34283", "Contable", "Sajoma", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34284", "Analista", "Sajoma", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34285", "Sub-gerente", "Sajoma", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34291", "Oficial de Negocios", "Rio San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34292", "Sub-gerente", "Rio San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34293", "Contable", "Rio San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34294", "Oficial de Negocios", "Rio San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34295", "Gerente", "Rio San Juan", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34311", "Gerente", "Salcedo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34312", "Sub-gerente", "Salcedo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34313", "Contable", "Salcedo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34314", "Oficial de Negocios", "Salcedo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34315", "Oficial de Negocios", "Salcedo", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34321", "Analista", "Monte Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34322", "Oficial de Negocios", "Monte Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34323", "Contable", "Monte Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34324", "Gerente", "Monte Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34325", "Oficial de Negocios", "Monte Plata", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34331", "Oficial de Negocios", "Constanza", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34332", "Contable", "Constanza", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34333", "Gerente", "Constanza", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34334", "Sub-gerente", "Constanza", "N/A"));
        agregarUsuario(new Usuario("N/A", "N/A", "34335", "Oficial de Negocios", "Constanza", "N/A"));
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