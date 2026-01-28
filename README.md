# prueba-tecnica-cobranza-argentina
prueba tecnica para el puesto de desarrollador jr

📦 Backend - API Cobranza Argentina
📌 Descripción

Este proyecto es el backend de una aplicación para la gestión de cobranza, desarrollado con Spring Boot.
Ofrece una API REST segura con Spring Security + JWT para la autenticación y autorización de usuarios, y permite manejar recursos como productos, usuarios y roles.

🚀 Funcionalidades Principales

CRUD completo

Autenticación con JWT

Gestión de usuarios y roles

Autorización por roles para proteger rutas

CORS configurado para Angular

Persistencia de datos con Spring Data JPA

Carga de datos iniciales automática (DataLoader)

Manejo de DTOs para solicitudes y respuestas

🛠️ Tecnologías
Tecnología	Versión
Java	17+
Spring Boot	3.x
Spring Security	6.x
Spring Data JPA	-
JWT	-
Maven	-
Base de Datos	MySQL / PostgreSQL

⚙️ Cómo ejecutar

Clonar el repositorio

git clone https://github.com/enriqueamaral/prueba-tecnica-cobranza-argentina


Entrar al proyecto

cd prueba-tecnica-cobranza-argentina


Configurar la base de datos en application.properties

Construir y ejecutar

mvn clean install

mvn spring-boot:run

📂 Estructura del Proyecto

src/main/java/.../

├── controller/

├── service/

├── repository/

├── entity/

├── security/

├── dto/

├── config/

└── loader/

🧱 Entities (Tablas de BD)

Las entidades representan las tablas de base de datos y se anotan así:

@Entity

@Table(name = "products")

Explicación de anotaciones principales

@Entity: Marca la clase como una entidad JPA.

@Table(name = "..."): Define el nombre de la tabla.

@Id + @GeneratedValue: Define la llave primaria generada automáticamente.

@Column: Personaliza columnas (nullable, unique, etc).

Esto permite que Hibernate mapee cada clase a una tabla física en la BD.

📡 Controllers

Los controladores exponen los endpoints de la API.

Ejemplo: ProductController

Rutas principales:

Método	Ruta	Acción

GET	/api/products	Listar productos

POST	/api/products	Crear producto

PUT	/api/products/{id}	Actualizar

DELETE	/api/products/{id}	Eliminar

Usan anotaciones como:

@RestController

@RequestMapping

@GetMapping / @PostMapping / etc

⚙️ Services

La lógica de negocio está separada en servicios:

Interfaz

public interface ProductService

Implementación

@Service

public class ProductServiceImpl

Esto ayuda a mantener flexibilidad y permite implementar tests unitarios fácilmente.

💾 Repositories

Extienden de Spring Data JPA:

public interface ProductRepository extends JpaRepository<Product, Long>

Esto automáticamente te da métodos como:

findAll()

findById()

save()

deleteById()

Sin necesidad de escribir SQL manual.

🔐 Seguridad (Spring Security + JWT)
CORS y CSRF

CORS: Permite comunicación con el frontend Angular.

CSRF: Deshabilitado por ser API REST con tokens.

Se configura en SecurityConfig:

http.csrf().disable()
    .cors();

👥 Roles y Autorización

Se usan roles como:

ROLE_ADMIN

ROLE_USER

Y se configuran permisos con:

.hasRole("ADMIN")

Se dejó OPTIONS libre para facilidades de validación en navegadores.

El endpoint de login (/api/auth/login) está abierto para cualquier usuario con credenciales válidas.

🔁 Flujo de Autenticación JWT

El usuario envía user/password.

AuthController valida y genera un JWT.

El frontend guarda el token.

Cada petición incluye el token en el header.

JwtFilter valida el token en cada request.

Spring Security autoriza el acceso según roles.

🧠 Componentes de Seguridad

CustomUserDetailsService → Carga usuario desde la base de datos.

JwtUtil → Genera y valida tokens.

JwtFilter → Intercepta peticiones y extrae el token.

SecurityConfig → Configura filtros y reglas de acceso.

Estos trabajan en conjunto para aplicar autenticación en todas las rutas.

🧬 Entidades de Seguridad

User → Usuario de sistema.

Role → Roles asignados a cada usuario.

Pueden tener relaciones ManyToMany para permitir múltiples roles por usuario.

📤 Data Loader

Se usa para generar usuarios iniciales automáticamente al iniciar la aplicación.
Esto es útil para pruebas y para no tener que crear usuarios manualmente.

🔑 AuthController

Exponer endpoint público para login:

POST /api/auth/login


Envía credenciales y devuelve:

JWT token

Información del usuario

📦 DTOs

DTOs (Data Transfer Objects) se usan para separar los modelos internos de los cuerpos de request/response.

Ejemplos:

LoginRequest

LoginResponse

ProductDTO

Ayudan a no exponer entidades directamente al cliente.

📄 Notas Finales

Proyecto estructurado con buenas prácticas de arquitectura, seguridad y separación de capas.
