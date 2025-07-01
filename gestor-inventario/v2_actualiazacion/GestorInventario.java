package v2_actualiazacion;

import java.util.ArrayList;
import java.util.Scanner;
public class GestorInventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== GESTOR DE INVENTARIO ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del producto: ");
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

                    System.out.print("Precio: ");
                    double precio;
                    try {
                        precio = Double.parseDouble(scanner.nextLine());
                        if (precio < 0) {
                            System.out.println("❌ El precio no puede ser negativo.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida para el precio.");
                        break;
                    }

                    System.out.print("Cantidad: ");
                    int cantidad;
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine());
                        if (cantidad < 0) {
                            System.out.println("❌ La cantidad no puede ser negativa.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida para la cantidad.");
                        break;
                    }

                    inventario.add(new Producto(nombre, precio, cantidad));
                    System.out.println("✅ Producto agregado.");
                    break;

                case "2":
                    System.out.println("\n📦 Productos en inventario:");
                    if (inventario.isEmpty()) {
                        System.out.println("⚠️ No hay productos registrados.");
                    } else {
                        for (Producto p : inventario) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "3":
                    System.out.print("🔍 Nombre del producto a buscar: ");
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
                    break;

                case "5":
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
                                    if (nuevoPrecio < 0) {
                                        System.out.println("❌ El precio no puede ser negativo.");
                                    } else {
                                        productoActualizar.setPrecio(nuevoPrecio);
                                        System.out.println("✅ Precio actualizado.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("❌ Entrada inválida.");
                                }
                                break;

                            case "2":
                                System.out.print("Nueva cantidad: ");
                                try {
                                    int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                                    if (nuevaCantidad < 0) {
                                        System.out.println("❌ La cantidad no puede ser negativa.");
                                    } else {
                                        productoActualizar.setCantidad(nuevaCantidad);
                                        System.out.println("✅ Cantidad actualizada.");
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

                                    if (nuevoPrecio < 0 || nuevaCantidad < 0) {
                                        System.out.println("❌ Ni el precio ni la cantidad pueden ser negativos.");
                                    } else {
                                        productoActualizar.setPrecio(nuevoPrecio);
                                        productoActualizar.setCantidad(nuevaCantidad);
                                        System.out.println("✅ Producto actualizado.");
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
                    break;

                case "6":
                    continuar = false;
                    System.out.println("👋 ¡Hasta luego!");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
