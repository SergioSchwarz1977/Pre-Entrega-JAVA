import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private static final String AMARILLO = "\u001B[33m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String RESET = "\u001B[0m";
    private static int contadorId = 0;
    protected int id;
    protected String nombre;
    protected double precio;
    protected int stock;

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

    static ArrayList<Producto> productos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void agregarProductos(String nombre, double precio, int stock) {
        productos.add(new Producto(id, "Monitor", 1000, 10));
        productos.add(new Producto(id, "Micrófono", 2000, 10));
        productos.add(new Producto(id, "Teclado mecánico", 1500, 15));
        productos.add(new Producto(id, "Mouse gamer", 1200, 20));
        productos.add(new Producto(id, "Laptop", 15000, 5));
        productos.add(new Producto(id, "Tablet", 8000, 7));
        productos.add(new Producto(id, "Disco duro externo", 2500, 12));
        productos.add(new Producto(id, "Memoria USB 64GB", 500, 25));
        productos.add(new Producto(id, "Router Wi-Fi", 1800, 10));
        productos.add(new Producto(id, "Smartphone", 12000, 8));
        productos.add(new Producto(id, "Audífonos Bluetooth", 2200, 18));
        productos.add(new Producto(id, "Cámara Web HD", 1300, 10));
        productos.add(new Producto(id, "Impresora", 4000, 6));
        productos.add(new Producto(id, "Estabilizador de voltaje", 1100, 10));
        productos.add(new Producto(id, "Cable HDMI", 300, 30));
        productos.add(new Producto(id, "Panel táctil USB", 2000, 5));
        productos.add(new Producto(id, nombre, precio, stock));
        
        System.out.println(MAGENTA + "Producto agregado correctamente.." + RESET);

    }

    // public void listarProducto() {
    // if (productos.isEmpty()) {
    // System.out.println("No hay Productos en stock..");
    // } else {
    // System.out.println(AMARILLO + "******** Lista de Productos **********" +
    // RESET);
    // for (Producto p : productos) {
    // System.out.println(p.toString());
    // }
    // }
    // }

    public void buscarPorNombre(String nombreBuscar) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println(AMARILLO + "**********  Producto encontrado:   **********" + RESET);
                System.out.println(p.toString());

            } else {
                System.out.println("No se encontró Producto con nombre: " + nombreBuscar);
            }
        }
    }

    public void buscarPorID(int id) {
        try {
            for (Producto p : productos) {
                if (p.getId() == id) {
                    System.out.println(AMARILLO + "************  Producto encontrado: *************" + RESET);
                    System.out.println(p.toString());
                }
            }

        } catch (Exception e) {
            System.out.println("No se encontró el producto..");
        }
    }

    public void eliminarProducto(int id) {
        int contador = 0;
        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.println(AMARILLO + "************  Producto encontrado: *************" + RESET);
                System.out.println(p.toString());
                System.out.println(MAGENTA + "********   Eliminar Producto:  ***********" + RESET);
                System.out.println("Desea eliminar el producto ? : S/N");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.println("Producto eliminado: " + p.getNombre());
                    productos.remove(p);
                    contador++;
                    return;
                }
            }
        }
        if (contador == 0) {
            System.out.println("No se encontró el producto con ID: " + id);
        } else {
            System.out.println("Producto eliminado correctamente.");
        }
    }

    public void listarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en stock.");
        } else {
            for (Producto p : productos) {
                System.out.println("#########################");
                System.out.printf("""
                        Id: %s
                        Nombre: %s
                        Precio: %s
                        Stock: %s
                        """, p.id, p.nombre, p.precio, p.stock);
                System.out.println("#########################");
            }

        }

    }
}