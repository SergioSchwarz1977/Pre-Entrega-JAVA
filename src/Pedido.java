import java.util.ArrayList;

public class Pedido extends Producto{
    private int IdPedido;
    Producto producto;
    private int cantidad;
    private double precioFinal;


    public Pedido(){}


    public Pedido(int idPedido, Producto producto, int cantidad, double precioFinal) {
        IdPedido = idPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
    }


    public Pedido(int id, String nombre, double precio, int stock, int idPedido, Producto producto, int cantidad,
            double precioFinal) {
        super(id, nombre, precio, stock);
        IdPedido = idPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
    }


    public int getIdPedido() {
        return IdPedido;
    }


    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }


    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
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
    private ArrayList<Pedido>pedido = new ArrayList<>();
    public void agregarPedido(String nombrePedido, int cantidad){
        //producto.buscarPorNombre(nombrePedido);
        if (super.getNombre().equalsIgnoreCase(nombrePedido)) {
            if (producto.getStock()>cantidad) {
                producto.setStock(getStock()-cantidad);
                precioFinal = producto.getPrecio() * cantidad;
                pedido.add(new Pedido(cantidad, producto, cantidad, precioFinal));
            }            
        }
    }
}
