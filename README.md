# prueba-tecnica-cobranza-argentina
prueba tecnica para el puesto de desarrollador jr

📦 Backend - API Productos
📌 Descripción

Este proyecto corresponde al backend de una aplicación CRUD desarrollada con Spring Boot.
Proporciona una API REST segura mediante JWT para la gestión de productos y usuarios.

⚙️ Instalación

git clone repositorio

cd backend

mvn clean install

mvn spring-boot:run

🚀 Funcionalidades

CRUD de productos

Autenticación con JWT

Gestión de usuarios y roles

Autorización por roles

Protección con Spring Security

Persistencia con JPA

Validación de datos

Carga automática de usuarios

🛠️ Tecnologías

Java 17+

Spring Boot

Spring Data JPA

Spring Security

JWT

MySQL / PostgreSQL

Maven

Configurar application.properties con credenciales de BD.

📂 Estructura del Proyecto

controller/

service/

repository/

entity/

security/

dto/

config/

🏗️ Entities

Las entidades representan las tablas de la base de datos.

Ejemplo: Product
@Entity
@Table(name = "products")

📡 Controllers

Ejemplo: ProductController

Expone los endpoints REST:

Método	Endpoint	Descripción

GET	/api/products	Listar

POST	/api/products	Crear

PUT	/api/products/{id}	Actualizar

DELETE	/api/products/{id}	Eliminar

Usa:

@RestController

@RequestMapping

@GetMapping

@PostMapping

⚙️ Services

Implementan la lógica de negocio.

Interfaz
public interface ProductService

Implementación

@Service

public class ProductServiceImpl


Separar interfaz e implementación facilita mantenimiento y pruebas.

💾 Repositories (JPA)

Extienden:

JpaRepository<Product, Long>


Permite:

findAll()

save()

deleteById()

findById()

Sin escribir SQL manual.

🔐 Seguridad (Spring Security + JWT)
CORS y CSRF

CORS: Permite conexión desde Angular

CSRF: Deshabilitado para API REST con JWT

.csrf().disable()

.cors()

Roles y Autorización

ROLE_ADMIN

ROLE_USER

Configuración:

hasRole("ADMIN")

OPTIONS libre para validaciones del navegador.

Login público.

🔄 Flujo JWT

Usuario hace login

AuthController valida credenciales

Se genera JWT

Front lo guarda

Cada petición envía Authorization Header

JwtFilter valida token

Spring Security autoriza

🧩 Componentes de Seguridad
CustomUserDetailsService

Carga usuarios desde BD.

JwtUtil

Genera y valida tokens.

JwtFilter

Intercepta peticiones.

SecurityConfig

Configura filtros y permisos.

Trabajan juntos para autenticar usuarios.

🧠 Beans

Los Beans son objetos gestionados por Spring.

Ejemplo:

@Bean

public PasswordEncoder passwordEncoder()


Permiten inyección automática.

👥 Usuarios y Roles

Entidades:

User

Role

Relación ManyToMany.

Permite asignar permisos.

📥 DataLoader

Genera usuarios iniciales automáticamente.

Sirve para:

Pruebas

Evitar crear usuarios manualmente

Ambiente demo

🔑 AuthController

Endpoint de login:

POST /api/auth/login

Recibe credenciales y devuelve JWT.

📦 DTOs

Separan modelo interno y datos externos.

Ejemplo:

LoginRequest

LoginResponse

Evita exponer entidades directamente.

📄 Notas Finales

Proyecto enfocado en buenas prácticas, seguridad y arquitectura limpia.
