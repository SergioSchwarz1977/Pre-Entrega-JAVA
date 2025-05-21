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
        productos.add(new Producto(id, nombre, precio, stock));

        System.out.println(MAGENTA + "Producto agregado correctamente.." + RESET);

    }

    public void listarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay Productos en stock..");
        } else {
            System.out.println(AMARILLO + "********  Lista de Productos  **********" + RESET);
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

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
                } else {
                    System.out.println("Producto no encontrado");
                }
            }

        } catch (Exception e) {
            System.out.println("No se encontró el producto..");
        }
    }

    public void eliminarProducto(String nombre) {

        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Desea eliminar el producto ? : S/N");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.println("Producto eliminado: " + nombre);
                    productos.remove(p);
                    return;
                }
            } else {
                System.out.println("No se encontro producto: " + nombre);
            }

        }

    }

    // public void agregarPedido(String nombrePedido, int cantidad) {
    //     ArrayList<String>pedido=new ArrayList<>();
    //     for (Producto p : producto) {
    //         if (p.getNombre().equalsIgnoreCase(nombrePedido)) {
    //             if (p.getStock() >= cantidad) {
    //                 double precioFinal = p.getPrecio() * cantidad;
    //                 p.setStock(p.getStock() - cantidad);
    //                 System.out.println("Pedido realizado con exito...");
    //                 System.out.println("Nombre Producto: " + p.getNombre() + " Cantidad: " + cantidad
    //                 + " Precio Final $: " + precioFinal);
    //                 pedido.add(nombrePedido + p.getNombre() + cantidad + precioFinal);
    //                 System.out.println(AMARILLO + "************  Lista de Pedidos:  *************" + RESET);
    //                 System.out.println("Nombre del Producto: " + p.getNombre());
    //                 System.out.println("Precio Final $: " + precioFinal);
                            
    //             } else {
    //                 System.out.println("No hay suficiente Stock..");
    //             }
    //         }else{

    //             System.out.println("Producto no encontrado..");
    //         }
    //     }
        
    // }
    
    // public void listarPedido(){
        
    // }

}