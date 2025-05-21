import java.util.ArrayList;

public class Pedido extends Producto {
    private static final String AMARILLO = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    private static int contadorId = 1;
    private int id;
    private int cantidad;
    private double precioFinal;
    Producto producto;

    public Pedido() {
    }

    public Pedido(int id, int cantidad, double precioFinal, Producto producto) {
        this.id = ++contadorId;
        this.cantidad = 0;
        this.precioFinal = 0;
        this.producto = producto;
    }

    public Pedido(int id, String nombre, double precio, int stock) {
        super(id, nombre, precio, stock);
        this.id = contadorId;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Pedido.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = contadorId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Producto getProductos() {
        return producto;
    }

    public void setProductos(Producto producto) {
        this.producto = producto;
    }

    // @Override
    // public String toString() {
    // return "Pedido:" + producto;
    // }

    ArrayList<Pedido> pedido = new ArrayList<>();

    @Override
    public String toString() {
        return "Pedido:" + "Nombre Producto: " + getProductos() + ", Cantidad: " + cantidad
                + ", Precio Final: " + precioFinal;
    }

    public void agregarPedido(String nombrePedido, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombrePedido)) {
                if (p.getStock() >= cantidad) {
                    p.setStock(p.getStock() - cantidad);
                    precioFinal = p.getPrecio() * cantidad;
                    pedido.add(new Pedido(id, cantidad, precioFinal, p));
                    System.out.println("Pedido agregado con exito.");
                } else {
                    System.out.println("No hay suficiente stock.");
                }
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
        for (Pedido p : pedido) {
            if (pedido.isEmpty()) {
                System.out.println("No hay pedidos.");
            } else
                System.out.println(AMARILLO + "************  Lista de Pedidos:  *************" + RESET);
            System.out.println("Nombre del Producto: " + p.getProductos().getNombre());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Final $: " + precioFinal);
        }
    }

    public void listarPedido() {
        if (pedido.isEmpty()) {
            System.out.println("No hay pedidos.");

        } else {
            System.out.println(AMARILLO + "************  Lista de Pedidos:  *************" + RESET);
            for (Pedido pedidos : pedido) {
                // System.out.println(pedido.toString());
                System.out.println("Nombre del Producto: " + pedidos.getProductos().getNombre());
                System.out.println("Cantidad: " + pedidos.getCantidad());
                System.out.println("Precio Final $: " + precioFinal);
            }

        }
    }

}
