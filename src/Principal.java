import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String AZUL = "\u001B[34m";

        Producto producto = new Producto();  
        Pedido pedido = new Pedido();      
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        int opcion = 0;

        do {
            
            System.out.println("***************************");
            System.out.println("****  MENU PRINCIPAL  *****");
            System.out.println("***************************\n" + RESET);

            System.out.println(AZUL + "1- Agregar Producto");
            System.out.println("2- Listar Producto");
            System.out.println("3- Buscar Producto por Nombre");
            System.out.println("4- Buscar Producto por ID");
            System.out.println("5- Eliminar Producto");
            System.out.println("6- Crear Pedido");
            System.out.println("7- Listar Pedido");
            System.out.println("8- Salir.\n");

            System.out.println(ROJO + "Elija una opcion: " + RESET);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(AZUL + "********   Agregar Producto:  ***********" + RESET);
                    sc.nextLine();// limpiar buffer
                    System.out.println("Ingrese Nombre del Producto: ");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese el Precio $ ");
                    double precio = sc.nextDouble();
                    while (precio <= 0) {
                        System.out.println("El precio tiene que ser mayor a 0.");
                        System.out.println("Ingrese el precio: ");
                        precio = sc.nextDouble();
                    }

                    System.out.println("Ingrese la cantidad de stock: ");
                    int stock = sc.nextInt();
                    while (stock <= 0) {
                        System.out.println("El stock tiene que ser mayor a 0.");
                        System.out.println("Ingrese stock: ");
                        stock = sc.nextInt();
                    }

                    producto.agregarProductos(nombre, precio, stock);
                    break;
                case 2:
                    producto.listarProducto();
                    break;
                case 3:
                    sc.nextLine();// limpiar buffer
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreBuscar = sc.nextLine();
                    producto.buscarPorNombre(nombreBuscar);
                    break;
                case 4:
                    sc.nextLine();// limpiar buffer
                    System.out.println("Ingrese el ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    producto.buscarPorID(idBuscar);
                    break;
                case 5:
                    sc.nextLine();// limpiar buffer
                    System.out.println("Ingrese el Nombre del producto a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    producto.eliminarProducto(nombreEliminar);
                    break;
                case 6:
                    sc.nextLine();// limpiar buffer
                    producto.listarProducto();
                    System.out.println(AZUL +"********   Agregar Pedido:  ***********"+RESET);
                    System.out.println("Ingrese el Nombre del produco: ");
                    String nombrePedido = sc.nextLine();
                    System.out.println("Ingrese la cantidad: ");
                    int cantidad = sc.nextInt();
                    pedido.agregarPedido(nombrePedido, cantidad);
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println(ROJO + "Saliendo del programa...." + RESET);
                    System.out.println(ROJO + "Sistema de Gestion, Autor Schwarz Sergio" + RESET);

                    salir = false;
                    sc.close();
                    break;
                default:
                    System.out.println(ROJO + "Opcion invalida...." + RESET);
                    break;
            }

        } while (salir);
    }
}
