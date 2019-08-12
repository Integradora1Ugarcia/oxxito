package mx.edu.utng.ugarcia.oxxito.models;

public class Product {
    private String codigo;
    private String nombre;
    private double precio;
    private int existencias;
    private String fechaCadu;

    public Product(){

    }

    public Product(String codigo, String nombre, double precio, int existencias, String fechaCadu) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.fechaCadu = fechaCadu;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setFechaCadu(String fechaCadu) {
        this.fechaCadu = fechaCadu;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public String getFechaCadu() {
        return fechaCadu;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                ", fechaCadu='" + fechaCadu + '\'' +
                '}';
    }


}
