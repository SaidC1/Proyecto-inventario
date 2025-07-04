package v4_reportes;

import java.io.*;
import java.util.*;

public class GestorInventario {
    private static final String ARCHIVO = "inventario.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> inventario = cargarInventario();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== GESTOR DE INVENTARIO (v4) ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Mostrar valor total del inventario");
            System.out.println("7. Ordenar productos");
            System.out.println("8. Mostrar productos con bajo stock");
            System.out.println("9. Guardar y salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1": agregarProducto(scanner, inventario); break;
                case "2": mostrarProductos(inventario); break;
                case "3": buscarProducto(scanner, inventario); break;
                case "4": eliminarProducto(scanner, inventario); break;
                case "5": actualizarProducto(scanner, inventario); break;
                case "6": mostrarValorTotal(inventario); break;
                case "7": ordenarProductos(scanner, inventario); break;
                case "8": mostrarStockBajo(inventario); break;
                case "9":
                    guardarInventario(inventario);
                    continuar = false;
                    System.out.println("✅ Inventario guardado. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        }

        scanner.close();
    }

    public static ArrayList<Producto> cargarInventario() {
        ArrayList<Producto> inventario = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return inventario;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    double precio = Double.parseDouble(partes[1]);
                    int cantidad = Integer.parseInt(partes[2]);
                    inventario.add(new Producto(nombre, precio, cantidad));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("⚠️ Error al leer el archivo: " + e.getMessage());
        }

        return inventario;
    }

    public static void guardarInventario(ArrayList<Producto> inventario) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Producto p : inventario) {
                escritor.write(p.aFormatoArchivo());
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static void agregarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("❌ El nombre no puede estar vacío.");
            return;
        }
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("❌ Ya existe un producto con ese nombre.");
                return;
            }
        }

        System.out.print("Precio: ");
        double precio;
        try {
            precio = Double.parseDouble(scanner.nextLine());
            if (precio < 0) {
                System.out.println("❌ El precio no puede ser negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada inválida para el precio.");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(scanner.nextLine());
            if (cantidad < 0) {
                System.out.println("❌ La cantidad no puede ser negativa.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada inválida para la cantidad.");
            return;
        }

        inventario.add(new Producto(nombre, precio, cantidad));
        System.out.println("✅ Producto agregado.");
    }

    public static void mostrarProductos(ArrayList<Producto> inventario) {
        System.out.println("\n📦 Productos en inventario:");
        if (inventario.isEmpty()) {
            System.out.println("⚠️ No hay productos registrados.");
        } else {
            for (Producto p : inventario) {
                System.out.println(p);
            }
        }
    }

    public static void buscarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.print("🔍 Nombre del producto a buscar: ");
        String nombreBuscar = scanner.nextLine().trim();
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("✅ Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("❌ Producto no encontrado.");
    }

    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.print("🗑️ Nombre del producto a eliminar: ");
        String nombreEliminar = scanner.nextLine().trim();
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
    }

    public static void actualizarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.print("✏️ Nombre del producto a actualizar: ");
        String nombreActualizar = scanner.nextLine().trim();
        Producto productoActualizar = null;
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreActualizar)) {
                productoActualizar = p;
                break;
            }
        }

        if (productoActualizar != null) {
            System.out.println("¿Qué deseas actualizar?");
            System.out.println("1. Precio");
            System.out.println("2. Cantidad");
            System.out.println("3. Ambos");
            System.out.print("Elige una opción: ");
            String subopcion = scanner.nextLine();

            switch (subopcion) {
                case "1":
                    System.out.print("Nuevo precio: ");
                    try {
                        double nuevoPrecio = Double.parseDouble(scanner.nextLine());
                        if (nuevoPrecio >= 0) {
                            productoActualizar.setPrecio(nuevoPrecio);
                            System.out.println("✅ Precio actualizado.");
                        } else {
                            System.out.println("❌ El precio no puede ser negativo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida.");
                    }
                    break;

                case "2":
                    System.out.print("Nueva cantidad: ");
                    try {
                        int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                        if (nuevaCantidad >= 0) {
                            productoActualizar.setCantidad(nuevaCantidad);
                            System.out.println("✅ Cantidad actualizada.");
                        } else {
                            System.out.println("❌ La cantidad no puede ser negativa.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida.");
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nueva cantidad: ");
                        int nuevaCantidad = Integer.parseInt(scanner.nextLine());

                        if (nuevoPrecio >= 0 && nuevaCantidad >= 0) {
                            productoActualizar.setPrecio(nuevoPrecio);
                            productoActualizar.setCantidad(nuevaCantidad);
                            System.out.println("✅ Producto actualizado.");
                        } else {
                            System.out.println("❌ Ni el precio ni la cantidad pueden ser negativos.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida.");
                    }
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }

        } else {
            System.out.println("❌ Producto no encontrado.");
        }
    }

    // 🔢 NUEVA FUNCIÓN 6
    public static void mostrarValorTotal(ArrayList<Producto> inventario) {
        double total = 0;
        for (Producto p : inventario) {
            total += p.getPrecio() * p.getCantidad();
        }
        System.out.println("💰 Valor total del inventario: $" + total);
    }

    // 🔢 NUEVA FUNCIÓN 7
    public static void ordenarProductos(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("¿Cómo deseas ordenar los productos?");
        System.out.println("1. Por nombre (A-Z)");
        System.out.println("2. Por cantidad (mayor a menor)");
        System.out.print("Elige una opción: ");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                inventario.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));
                System.out.println("✅ Productos ordenados por nombre.");
                break;
            case "2":
                inventario.sort((p1, p2) -> Integer.compare(p2.getCantidad(), p1.getCantidad()));
                System.out.println("✅ Productos ordenados por cantidad.");
                break;
            default:
                System.out.println("❌ Opción inválida.");
        }
    }

    // 🔢 NUEVA FUNCIÓN 8
    public static void mostrarStockBajo(ArrayList<Producto> inventario) {
        System.out.println("📉 Productos con bajo stock (menos de 5 unidades):");
        boolean hayBajoStock = false;
        for (Producto p : inventario) {
            if (p.getCantidad() < 5) {
                System.out.println("⚠️ " + p);
                hayBajoStock = true;
            }
        }
        if (!hayBajoStock) {
            System.out.println("✅ Todos los productos tienen suficiente stock.");
        }
    }
}
