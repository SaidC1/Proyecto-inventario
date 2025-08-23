# 📊 Gestor de Inventario en Java - Versión 4: Reportes.
# 📊 Inventory Manager in Java - Version 4: Reports.

Versión extendida del proyecto de inventario, ahora con funciones de análisis y reportes.  
Extended version of the inventory project, now with analysis and reporting features.

---

## 🧠 ¿Qué se practicó? / What was practiced?.

- CRUD completo con persistencia en archivo `.txt`  
  Full CRUD with `.txt` file persistence  
- Programación Orientada a Objetos (POO) / Object-Oriented Programming (OOP)  
- Uso de `ArrayList`, `Comparator` y ordenamiento de listas  
- Análisis de datos en consola (reportes)  
- Validaciones sólidas y flujo lógico de menú

---

## 📄 Archivos / Files.

- `Producto.java`: Clase base con atributos, setters, `toString()` y formato para archivo  
  Product class with attributes, setters, `toString()`, and file format method  
- `GestorInventario.java`: Lógica completa del sistema con CRUD, archivo y reportes  
  Full system logic with CRUD, file I/O, and reports  
- `inventario.txt`: Archivo generado automáticamente donde se guarda el inventario  
  Auto-generated file used for saving inventory data

---

## ✅ Funcionalidades / Features.

1. Agregar producto / Add product  
2. Mostrar productos / Show all products  
3. Buscar por nombre / Search by name  
4. Eliminar producto / Delete product  
5. Actualizar precio o cantidad / Update price or quantity  
6. Mostrar valor total del inventario / Show total inventory value  
7. Ordenar productos por nombre o cantidad / Sort by name or quantity  
8. Mostrar productos con bajo stock / Show low-stock products  
9. Guardar y salir / Save and exit  

---

## 🧪 Requisitos / Requirements.

- Java 17 o superior / Java 17 or higher  
- Ejecutar desde consola o IDE como IntelliJ, Eclipse o VS Code

---

## 🚀 Ejecución / How to run

```bash
javac Producto.java GestorInventario.java
java GestorInventario
