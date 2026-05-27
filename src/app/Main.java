package app;

import modelo.Administrativo;
import modelo.Empleado;
import modelo.Medico;
import servicio.EmpleadoServicio;
import util.Validador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpleadoServicio servicio = new EmpleadoServicio();

        int opcion = 0;

        while (opcion != 9) {

            try {

                System.out.println("\n===== CLINICA SALUD TOTAL =====");
                System.out.println("1. Registrar medico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar por cedula");
                System.out.println("5. Reemplazar informacion");
                System.out.println("6. Eliminar registro");
                System.out.println("7. Calcular pagos");
                System.out.println("8. Mostrar estadisticas");
                System.out.println("9. Salir");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:

                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();

                        if (servicio.existeCedula(cedula)) {
                            System.out.println("Cedula repetida.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        if (!Validador.esTextoValido(nombre)) {
                            System.out.println("Nombre invalido.");
                            break;
                        }

                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());

                        if (!Validador.esEdadValida(edad)) {
                            System.out.println("Edad invalida.");
                            break;
                        }

                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        if (!Validador.esTelefonoValido(telefono)) {
                            System.out.println("Telefono invalido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        if (!Validador.esCorreoValido(correo)) {
                            System.out.println("Correo invalido.");
                            break;
                        }

                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();

                        System.out.print("Pacientes atendidos: ");
                        int pacientes =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Valor consulta: ");
                        double valorConsulta =
                                Double.parseDouble(sc.nextLine());

                        Medico medico = new Medico(
                                cedula,
                                nombre,
                                edad,
                                telefono,
                                correo,
                                especialidad,
                                pacientes,
                                valorConsulta
                        );

                        servicio.agregarEmpleado(medico);

                        System.out.println("Medico registrado.");
                        break;

                    case 2:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        if (servicio.existeCedula(cedula)) {
                            System.out.println("Cedula repetida.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        edad = Integer.parseInt(sc.nextLine());

                        System.out.print("Telefono: ");
                        telefono = sc.nextLine();

                        System.out.print("Correo: ");
                        correo = sc.nextLine();

                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();

                        System.out.print("Horas trabajadas: ");
                        int horas =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Valor hora: ");
                        double valorHora =
                                Double.parseDouble(sc.nextLine());

                        Administrativo administrativo =
                                new Administrativo(
                                        cedula,
                                        nombre,
                                        edad,
                                        telefono,
                                        correo,
                                        departamento,
                                        horas,
                                        valorHora
                                );

                        servicio.agregarEmpleado(administrativo);

                        System.out.println("Administrativo registrado.");
                        break;

                    case 3:

                        servicio.mostrarEmpleados();
                        break;

                    case 4:

                        System.out.print("Cedula a buscar: ");
                        cedula = sc.nextLine();

                        Empleado encontrado =
                                servicio.buscarPorCedula(cedula);

                        if (encontrado != null) {

                            encontrado.mostrarInformacion();

                        } else {

                            System.out.println(
                                    "Registro no encontrado."
                            );
                        }

                        break;

                    case 5:

                        System.out.print(
                                "Cedula del registro a reemplazar: "
                        );

                        cedula = sc.nextLine();

                        Empleado empleado =
                                servicio.buscarPorCedula(cedula);

                        if (empleado == null) {

                            System.out.println(
                                    "Registro no encontrado."
                            );

                            break;
                        }

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();

                        empleado.setNombre(nuevoNombre);

                        System.out.println(
                                "Informacion actualizada."
                        );

                        break;

                    case 6:

                        System.out.print(
                                "Cedula a eliminar: "
                        );

                        cedula = sc.nextLine();

                        if (servicio.eliminarEmpleado(cedula)) {

                            System.out.println(
                                    "Registro eliminado."
                            );

                        } else {

                            System.out.println(
                                    "Registro no encontrado."
                            );
                        }

                        break;

                    case 7:

                        servicio.calcularPagos();
                        break;

                    case 8:

                        servicio.mostrarEstadisticas();
                        break;

                    case 9:

                        System.out.println("Fin del programa.");
                        break;

                    default:

                        System.out.println(
                                "Error: opcion invalida."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un valor numerico valido."
                );

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }

        sc.close();
    }
}