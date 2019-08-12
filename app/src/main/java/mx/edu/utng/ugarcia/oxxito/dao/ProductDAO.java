package mx.edu.utng.ugarcia.oxxito.dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.edu.utng.ugarcia.oxxito.models.Product;

public class ProductDAO {
    private Context context;

    public ProductDAO(Context context) {
        this.context = context;
    }

    /**
     * Método para insertar un objeto Producto a la BD
     *
     * @param obj
     * @throws
     */
    public void insert(Product obj) throws Exception {
        // se crea la sentencia de SQL válida
        String command = "INSERT INTO products (codigo, nombre, precio, existencias, fechaCadu) " +
                "VALUES ('" + obj.getCodigo() + "', '" + obj.getNombre() + "', "
                + obj.getPrecio() + ", " + obj.getExistencias() + ", '"
                + obj.getFechaCadu() + "')";
        // se crea un objeto de conexion
        Connection conn = new Connection(context);
        try {
            // se ejecuta la sentencia
            conn.ejectSentencia(command);
        } catch (Exception e) {
            // lanzamos la excepcion
            throw new Exception("Error al insertar: " + e.getMessage());
        }
    }

    /**
     * Método para actualizar un objeto Producto en la BD
     *
     * @param obj
     */
    public void update(Product obj) throws Exception {
        // se crea la sentencia SQL a ejecutar
        String command = "UPDATE products SET " +
                "nombre='" + obj.getNombre() + "', " +
                "precio= " + obj.getPrecio() + ", " +
                "existencias= " + obj.getExistencias() + ",'" +
                "fechaCadu= '" + obj.getFechaCadu() + "' " +
                "WHERE codigo='" + obj.getCodigo() + "'";
        // se crea el objeto de conexion
        Connection conn = new Connection(context);
        try {
            // se intenta ejecutar la sentencia
            conn.ejectSentencia(command);
        } catch (Exception e) {
            // lanzamos la excepcion
            throw new Exception("Error al editar: " + e.getMessage());
        }
    }

    /**
     * Método para eliminar un objeto producto de la BD
     *
     * @param obj
     * @throws
     */
    public void delete(Product obj) throws Exception {
        // se crea la sentencia DELETE
        String command = "DELETE FROM products WHERE codigo = '" +
                obj.getCodigo() + "'";
        // se crea el objeto de conexion
        Connection conn = new Connection(context);
        try {
            // se intenta ejecutar la sentencia
            conn.ejectSentencia(command);
        } catch (Exception e) {
            // lanzamos la excepcion
            throw new Exception("Error al eliminar: " + e.getMessage());
        }
    }

    public List<Product> getAll() throws Exception {
        String table = "Products";
        String fields[] = new String[]{"codigo", "nombre", "precio", "existencias", "fechaCadu"};
        List<Product> listProducts = new ArrayList<Product>();
        Connection conn = new Connection(context);
        List<HashMap<String, String>> result = conn.ejectConsulta(table, fields, null);
        Product p1 = null;
        for (HashMap<String, String> reg : result) {
            p1 = new Product();
            p1.setCodigo(reg.get("codigo"));
            p1.setNombre(reg.get("nombre"));
            p1.setPrecio(Double.parseDouble(reg.get("precio")));
            p1.setExistencias(Integer.parseInt(reg.get("existencias")));
            p1.setFechaCadu(reg.get("fechaCadu"));
            listProducts.add(p1);
        }
        return listProducts;
    }

    public Product getById(Product obj) throws Exception {
        String table = "Products";
        String fields[] = new String[]{"codigo", "nombre", "precio", "existencias", "fechaCadu"};
        String condition = "codigo= '" + obj.getCodigo() + "'";
        Connection conn = new Connection(context);
        List<HashMap<String, String>> result = conn.ejectConsulta(table, fields, condition);
        Product p1 = null;
        for (HashMap<String, String> reg : result){
            p1 = new Product();
            p1.setCodigo(reg.get("codigo"));
            p1.setNombre(reg.get("nombre"));
            p1.setPrecio(Double.parseDouble(reg.get("precio")));
            p1.setExistencias(Integer.parseInt(reg
                    .get("existencias")));
            p1.setFechaCadu(reg.get("fechaCadu"));
        }
        return p1;
    }

}//End class
