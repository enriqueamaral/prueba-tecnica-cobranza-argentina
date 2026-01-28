# Inventario API – Prueba Técnica

Este proyecto corresponde a una **API REST de Inventario** desarrollada como parte de una **prueba técnica**.  
La aplicación implementa un **CRUD completo de productos**, protegido mediante **Spring Security**, autenticación con **JWT** y control de acceso basado en **roles**.

---

## Tecnologías utilizadas

- Java 21  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  

---

##  Descripción general del sistema

La aplicación expone una API REST que permite administrar un inventario de productos.  
El acceso a los endpoints está protegido por autenticación y autorización mediante JWT.

Características principales:
- CRUD completo de productos
- Autenticación con usuario y contraseña
- Generación y validación de JWT
- Control de acceso por roles
- Usuarios precargados automáticamente
- Contraseñas cifradas en base de datos

---

##  Seguridad y autenticación

La seguridad se implementó usando **Spring Security + JWT**, manteniendo la API **stateless**.

### Flujo de autenticación
1. El cliente envía credenciales al endpoint de login.
2. El backend valida el usuario usando `CustomUserDetailsService`.
3. Si las credenciales son correctas:
   - Se genera un JWT
   - Se devuelve el token junto con el usuario y su rol
4. El cliente debe enviar el token en cada petición protegida:

Authorization: Bearer <JWT>

---

##  Roles del sistema

| Rol | Descripción |
|----|------------|
| ROLE_ADMIN | Crear, actualizar y eliminar productos |
| ROLE_USER | Consultar productos |

---

##  Endpoint de autenticación

### Login
POST `/api/v1/auth/login`

Request:
```json
{
  "username": "admin",
  "password": "admin123"
}
```

Response:
```json
{
  "username": "admin",
  "role": "ROLE_ADMIN",
  "token": "jwt_generado"
}
```

---

##  Endpoints de productos

Base URL:
http://localhost:8080/api/v1/products

### Obtener todos los productos
GET `/api/v1/products`  
Roles: USER, ADMIN

### Obtener producto por ID
GET `/api/v1/products/{id}`  
Roles: USER, ADMIN

### Crear producto
POST `/api/v1/products`  
Rol: ADMIN

### Actualizar producto
PUT `/api/v1/products/{id}`  
Rol: ADMIN

### Eliminar producto
DELETE `/api/v1/products/{id}`  
Rol: ADMIN

---

## Usuarios precargados (DataLoader)

| Usuario | Contraseña | Rol |
|-------|-----------|-----|
| admin | admin123 | ROLE_ADMIN |
| user | user123 | ROLE_USER |

Las contraseñas se almacenan cifradas con BCrypt.

---

##  Base de datos

- MySQL
- La base de datos debe existir previamente
- Las tablas se generan automáticamente con JPA/Hibernate
- Configuración en `application.properties`

---

##  Ejecución

```bash
mvn spring-boot:run
```

---

##  Notas finales

- API stateless
- JWT para seguridad
- No se incluyó Swagger
- Se priorizó claridad, seguridad y cumplimiento de requisitos
