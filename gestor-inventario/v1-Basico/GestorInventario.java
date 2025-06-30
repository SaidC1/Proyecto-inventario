import java.util.ArrayList;
import java.util.Scanner;

public class GestorInventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n === GESTOR DE INVENTARIO ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Nombre del producto:");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("❌ El nombre no puede estar vacío.");
                        break;
                    }

                    boolean existe = false;
                    for (Producto p : inventario) {
                        if (p.getNombre().equalsIgnoreCase(nombre)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("❌ Ya existe un producto con ese nombre.");
                        break;
                    }
                    System.out.println("Precio: ");
                    double precio;
                    try {
                        precio = Double.parseDouble(scanner.nextLine());
                        if (precio < 0) {
                            System.out.println("❌ El precio no puede ser negativo. ");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida para el precio.");
                        break;
                    }
                    System.out.println("Cantidad: ");
                    int cantidad;
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine());
                        if (cantidad < 0) {
                            System.out.println("❌La cantidad no puede ser negativa.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida para la cantidad.");
                        break;
                    }

                case "2":
                    System.out.println("\n Producto en inventario:");
                    if (inventario.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Producto p : inventario) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "3":
                    System.out.println("🔍Nombre del producto a buscar:");
                    String nombreBuscar = scanner.nextLine().trim();
                    boolean encontrado = false;
                    for (Producto p : inventario) {
                        if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("✅ Producto encontrado: " + p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("❌ Producto no encontrado.");
                    }
                    break;

                case "4":
                    System.out.println("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    Producto productoEliminar = null;
                    for (Producto p : inventario) {
                        if (p.getNombre().equalsIgnoreCase(nombreEliminar)) {
                            productoEliminar = p;
                            break;
                        }
                    }
                    if (productoEliminar != null) {
                        inventario.remove(productoEliminar);
                        System.out.println("✅ Producto eliminado.");
                    } else {
                        System.out.println("❌ Producto no encontrado.");

                    }
                    break;

                case "5":
                    continuar = false;
                    System.out.println("👋 ¡Hasta luego!");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo");
            }
        }

        scanner.close();
    }
}
