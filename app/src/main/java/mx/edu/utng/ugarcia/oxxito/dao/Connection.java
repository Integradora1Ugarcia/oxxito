package mx.edu.utng.ugarcia.oxxito.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connection {
    private Context context;

    public Connection(Context contexto){
        this.context = contexto;
    }

    private SQLiteDatabase abrirConexion(){
        SQLiteDatabase conexion = context.openOrCreateDatabase(
                "oxxito.db", SQLiteDatabase.OPEN_READWRITE, null

        );
        return conexion;
    }

    /**
     *
     * @param conexion
     * **/

    private void cerrarConexion(SQLiteDatabase conexion){
        if(conexion!=null){
            conexion.close();
        }
    }

    public boolean ejectSentencia(String sentencia) throws Exception {
        SQLiteDatabase conexion = abrirConexion();
        try {
            conexion.execSQL(sentencia);

            conexion.close();
        }catch (Exception e){
            throw new Exception("Error en la sentencia:"+e.getMessage());
        }
        return true;
    }

    public List<HashMap<String, String>> ejectConsulta(String tabla, String[] campos, String condicion) throws Exception{
        List<HashMap<String, String>> datos = new ArrayList<HashMap<String, String>>();
        try {
            SQLiteDatabase conexion = abrirConexion();

            Cursor result = conexion.query(tabla, campos, condicion, null, null, null, null);
            HashMap<String, String> registro;

            while (result.moveToNext()){

                registro = new HashMap<String, String>();
                for (int i = 0 ; i<campos.length; i++){
                    registro.put(campos [1], result.getString(i));
                }
                datos.add(registro);
            }
            conexion.close();

        }catch (Exception e){
            throw  new Exception("Error al executar consulta"+e.getMessage());
        }
        return datos;

    }

    public void initBD(){
        SQLiteDatabase conn = abrirConexion();
        conn.execSQL("Drop table if exists productos");
        conn.execSQL("Create table productos (codigo TEXT, " + " nombre TEXT, " + " precio REAL, " + "existencia INTEGER, " + "fecha_caducidad TEXT)");
    }
}
