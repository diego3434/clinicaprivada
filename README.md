Este proyecto fue desarrollado en Java aplicando los principios de Programación Orientada a Objetos (POO), manejo de excepciones, conversiones de datos y estructuras dinámicas mediante ArrayList.

El sistema permite gestionar el personal de una clínica privada, registrando médicos y personal administrativo, realizando operaciones CRUD, búsquedas, cálculos de pagos y generación de estadísticas.

Funcionalidades
Registrar médicos.
Registrar personal administrativo.
Mostrar empleados registrados.
Buscar empleados por cédula.
Actualizar información de empleados.
Eliminar registros.
Calcular pagos.
Mostrar estadísticas generales.
Validar datos ingresados por el usuario.
Manejar excepciones para evitar errores durante la ejecución.
Conceptos de Programación Orientada a Objetos Aplicados
Herencia

Se implementó una clase padre llamada Empleado, de la cual heredan las clases Medico y Administrativo.

Esto permite reutilizar atributos y métodos comunes, evitando duplicación de código.

Encapsulamiento

Todos los atributos fueron declarados como privados y se accede a ellos mediante métodos getters y setters, garantizando la protección de los datos.

Polimorfismo

Se utilizó un ArrayList<Empleado> para almacenar tanto objetos de tipo Medico como de tipo Administrativo.

Gracias al polimorfismo, ambos tipos de empleados pueden ser tratados como objetos de la clase padre Empleado.

Manejo de Excepciones

El proyecto utiliza bloques try-catch para controlar errores producidos por entradas incorrectas del usuario.

Ejemplos:

NumberFormatException
InputMismatchException
Exception

Esto evita que el programa finalice inesperadamente cuando se ingresan datos inválidos.

Conversiones Utilizadas
Conversión String a int
int edad = Integer.parseInt(textoEdad);
Conversión String a double
double salario = Double.parseDouble(textoSalario);

Estas conversiones permiten transformar los datos ingresados desde teclado en valores numéricos utilizables por el programa.

Validaciones Implementadas

El sistema realiza validaciones para garantizar la integridad de los datos:

Cédula no repetida.
Edad válida.
Campos obligatorios.
Correo electrónico válido.
Teléfono numérico.
Valores positivos para horas, consultas y pagos.
Control de opciones incorrectas en el menú.
