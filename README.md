## Tarea Programada:
**Facturación de Componentes**

## Curso
**Diseño y Construcción de Componentes**

## Universidad
**Universidad Latina de Costa Rica**

## Profesor
**Bernal Fernandez Bonilla**

## Estudiante
**David Cerdas Perez**

---

## Descripción del Proyecto
Este proyecto es una tarea programada cuyo objetivo es implementar **JPA con Hibernate** para poner en práctica conceptos de persistencia, herencia y relaciones entre entidades en una aplicación de facturación.

---

## Tecnologías

- Java
- JPA / Hibernate
- MySQL
- Eclipse IDE
- GitHub
- WSL / Ubuntu

---

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/djcerdas/facturacionComponentes.git
cd facturacionComponentes
```

### 2. Iniciar MySQL

```bash
sudo service mysql start
```

### 3. Crear la base de datos

```bash
mysql -u root < artifact/sql/schema.sql
```

Este script elimina la base de datos si existe y la crea nuevamente.  
Las tablas serán generadas automáticamente por Hibernate al ejecutar la aplicación.

### 4. Importar el proyecto en Eclipse

- Abrir Eclipse
- Ir a **File → Import**
- Seleccionar **Existing Projects into Workspace**
- Seleccionar la carpeta del proyecto
- Finalizar

### 5. Importar librerías

- Click derecho sobre el proyecto
- Ir a **Build Path → Configure Build Path**
- Abrir la pestaña **Libraries**
- Click en **Add External JARs**
- Seleccionar todos los archivos `.jar` ubicados en:

```text
artifact/lib/
```

### 6. Ejecutar la aplicación

- Click derecho sobre el proyecto
- Seleccionar **Run As → Java Application**
- Ejecutar la clase principal:

```text
presentacion.MainApp
```

---

## Funcionalidad Principal

El sistema permite:

- Registrar clientes
- Registrar productos
- Crear órdenes con múltiples items
- Calcular automáticamente el total
- Aplicar impuestos únicamente a productos de tipo hardware
- Generar una factura en consola con formato estructurado

---

## Estructura General

- `entidades/` → clases JPA del modelo
- `accesoDatos/` → DAOs y utilidad JPA
- `logicaNegocio/` → generación de factura
- `presentacion/` → clase principal
- `artifact/sql/` → scripts SQL
- `artifact/lib/` → librerías del proyecto


