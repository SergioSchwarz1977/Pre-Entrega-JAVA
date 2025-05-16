import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private static int contadorId = 0;
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }


    public Producto(int id, String nombre, double precio, int stock) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID = " + id + ", Nombre del producto = " + nombre + ", Precio del producto $: = " + precio
                + ", Stock = " + stock + "";
    }

    ArrayList<Producto> producto = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void agregarProductos(String nombre, double precio, int stock) {
        producto.add(new Producto(id, nombre, precio, stock));

        System.out.println("Producto agregado correctamente..");

    }

    public void listarProducto() {
        if (producto.isEmpty()) {
            System.out.println("No hay Productos en stock..");
        } else {
            System.out.println("********  Lista de Productos  **********");
            for (Producto p : producto) {
                System.out.println(p.toString());
            }
        }
    }

    public void buscarPorNombre(String nombreBuscar) {
        for (Producto p : producto) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("**********  Producto encontrado:   **********");
                System.out.println(p.toString());

            } else {
                System.out.println("No se encontró Producto con nombre: " + nombreBuscar);
            }
        }
    }

    public void buscarPorID(int id) {
        try {
            for (Producto p : producto) {
                if (p.getId()==id) {
                    System.out.println("************  Producto encontrado: *************");
                    System.out.println(p.toString());
                }else{
                    System.out.println("Producto no encontrado");
                }                
            }          
            
        } catch (Exception e) {
            System.out.println("No se encontró el producto..");
        }
    }

    public void eliminarProducto(String nombre) {
        for (Producto p : producto) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Desea eliminar el producto ? : S/N");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.println("Producto eliminado: " + nombre);
                    producto.remove(p);
                    return;   
                }
            }else{
                System.out.println("No se encontro producto: " + nombre);
            }

        }
       
    }

}