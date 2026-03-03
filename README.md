💱 Conversor de Monedas – Java Console Application






Aplicación de consola desarrollada en Java que permite convertir valores entre distintas monedas utilizando una API externa de tipo de cambio en tiempo real.

El sistema genera dinámicamente un menú de conversiones basado en una moneda principal y una lista configurable de monedas.

📌 Descripción

Este proyecto implementa un Conversor de Monedas interactivo por consola, el cual:

Genera automáticamente las opciones de conversión.

Solicita una opción válida al usuario.

Solicita un valor positivo a convertir.

Realiza la conversión mediante una API externa.

Muestra el resultado formateado.

Permite múltiples conversiones hasta seleccionar “Salir”.

🏗️ Arquitectura

El proyecto está organizado en dos capas principales:

📦 Modelo

Encapsula la lógica y datos del sistema:

Moneda → Representa una moneda (código y nombre).

Opcion → Representa una opción del menú de conversión.

Constantes → Contiene textos y mensajes del sistema.

Exchangerate → Se encarga de consumir la API externa para realizar la conversión.

🖥 Vista

Responsable de la interacción con el usuario:

Aplicativo → Controla el flujo del programa, genera el menú y ejecuta las conversiones.

🔑 se necesita API Key ¿De dónde se obtiene?

Generalmente el proceso es:

Registrarte en la página del proveedor.

Crear una cuenta gratuita.

Generar una API Key desde el panel de usuario.

Copiar esa clave y usarla en tu aplicación.

🌍 APIs comunes para tipo de cambio

Aquí tienes algunas opciones populares:

1️⃣ ExchangeRate-API

🌐 https://www.exchangerate-api.com

Pasos:

Crear cuenta gratuita.

Confirmar correo.

En el dashboard encontrarás tu API Key.

Usarla en tu URL:

📂 Estructura del Proyecto
com.amc.conversormonedas
│
├── modelo
│   ├── Constantes.java
│   ├── Exchangerate.java
│   ├── Moneda.java
│   └── Opcion.java
│
└── vista
    └── Aplicativo.java
🛠️ Tecnologías Utilizadas

Java 17

API HTTP de tipo de cambio

Scanner para entrada por consola

Manejo de Excepciones

Programación Orientada a Objetos

⚙️ Instalación
1️⃣ Clonar el repositorio
git clone https://github.com/Maga11on/conversor-monedas.git
cd conversor-monedas
2️⃣ Compilar el proyecto

Si es un proyecto Java simple:

javac com/amc/conversormonedas/**/*.java

Si utilizas Maven:

mvn clean install
3️⃣ Ejecutar la aplicación
java com.amc.conversormonedas.Main
▶️ Uso

Al iniciar la aplicación se mostrará un menú similar a:

===============================
Bienvenido al Conversor
===============================

[1] USD -> MXN
[2] MXN -> USD
[3] USD -> EUR
[4] EUR -> USD
[5] Salir
Flujo de ejecución

Ingresar número de opción.

Ingresar valor a convertir.

Visualizar resultado.

Repetir o salir.

Ejemplo

Entrada:

1
100

Salida esperada:

100.00 USD equivale a 1700.50 MXN
✅ Validaciones Implementadas

✔ Opción fuera de rango
✔ Entrada no numérica
✔ Valor negativo
✔ Manejo de errores en consumo de API
✔ Reintentos automáticos ante entrada inválida

🧯 Manejo de Errores

La aplicación maneja:

InputMismatchException

Errores de conexión con la API

Validaciones de límites del menú

Control de flujo seguro hasta que el usuario ingrese datos correctos

🔮 Posibles Mejoras Futuras

Cacheo de tasas de cambio

Interfaz gráfica (JavaFX / Swing)

Tests unitarios

Registro de historial de conversiones

Dockerización

📄 Licencia

Este proyecto está bajo la Licencia MIT.

👨‍💻 Autor

Alberto Magallon
Backend Java Developer

Proyecto desarrollado como práctica de consumo de APIs y manejo de entrada por consola en Java.
