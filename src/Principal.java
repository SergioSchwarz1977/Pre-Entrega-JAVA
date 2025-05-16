import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {

        Producto producto = new Producto();        
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        int opcion = 0;

        do {
            
            System.out.println("***************************");
            System.out.println("****  MENU PRINCIPAL  *****");
            System.out.println("***************************\n");

            System.out.println("1- Agregar Producto");
            System.out.println("2- Listar Producto");
            System.out.println("3- Buscar Producto por Nombre");
            System.out.println("4- Buscar Producto por ID");
            System.out.println("5- Eliminar Producto");
            System.out.println("6- Crear Pedido");
            System.out.println("7- Listar Pedido");
            System.out.println("8- Salir.\n");

            System.out.println("Elija una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                 case 1:
                //     System.out.println("Ingrese el ID del producto");
                //     while (!sc.hasNextInt()) {
                //         System.out.println("Tiene que ser numérico");
                //         System.out.println("Ingrese ID Numerico.");
                //     }
                //          int id = sc.nextInt();  
                    System.out.println("********   Agregar Producto:  ***********");
                    sc.nextLine();//limpiar buffer
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
                sc.nextLine();//limpiar buffer
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreBuscar = sc.nextLine();
                    producto.buscarPorNombre(nombreBuscar);                    
                    break;
                case 4:
                sc.nextLine();//limpiar buffer
                    System.out.println("Ingrese el ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    producto.buscarPorID(idBuscar);
                    break;
                case 5:
                sc.nextLine();//limpiar buffer
                    System.out.println("Ingrese el Nombre del producto a eliminar: ");
                    String idBuscarEliminar = sc.nextLine();
                    producto.eliminarProducto(idBuscarEliminar); 
                    break;
                case 6:
                    
                    break;
                case 8:
                    System.out.println("Saliendo del programa....");
                    salir = false;
                    sc.close();
                    break;    
                default:
                    System.out.println("Opcion invalida....");
                    break;
            }




        } while (salir);
    }
}
