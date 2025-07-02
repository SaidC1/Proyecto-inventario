# 🧾 Gestor de Inventario en Java - Versión 3  
# 🧾 Inventory Manager in Java - Version 3

Versión mejorada con lectura y guardado automático de productos desde un archivo `.txt`.  
Improved version with automatic loading and saving of products from a `.txt` file.

---

## 🧠 ¿Qué se practicó? / What was practiced?

- Programación Orientada a Objetos (POO)  
  Object-Oriented Programming (OOP)  
- Uso de `ArrayList`  
  Using `ArrayList`  
- CRUD completo con persistencia  
  Full CRUD with persistence  
- Lectura y escritura de archivos con `BufferedReader` y `BufferedWriter`  
  File reading/writing with `BufferedReader` and `BufferedWriter`  
- Validaciones sólidas  
  Strong validations  
- Menú interactivo con `Scanner`  
  Interactive menu using `Scanner`

---

## 📄 Archivos / Files

- `Producto.java`: Clase base con atributos, setters, `toString()` y formato para archivo  
  Class with attributes, setters, `toString()`, and file format method  
- `GestorInventario.java`: Lógica del programa con carga/guardado en archivo y menú CRUD  
  Program logic with file load/save and CRUD menu  
- `inventario.txt`: Archivo de texto donde se guardan automáticamente los productos  
  Text file where products are automatically saved

---

## ✅ Funcionalidades / Features

- Agregar productos  
  Add products  
- Mostrar todos los productos  
  Show all products  
- Buscar por nombre  
  Search by name  
- Eliminar producto  
  Delete product  
- Actualizar precio y/o cantidad  
  Update price and/or quantity  
- Guardar automáticamente en archivo `.txt`  
  Automatically save to `.txt` file  
- Cargar productos automáticamente al iniciar  
  Automatically load products on startup

---

## 🧪 Requisitos / Requirements

- Java 17 o superior / Java 17 or higher  
- Consola o IDE (Eclipse, IntelliJ, VS Code)

---

## 🚀 Ejecución / How to run

```bash
javac Producto.java GestorInventario.java
java GestorInventario
