package servicio;

import modelo.Administrativo;
import modelo.Empleado;
import modelo.Medico;

import java.util.ArrayList;

public class EmpleadoServicio {

    private ArrayList<Empleado> empleados;

    public EmpleadoServicio() {
        empleados = new ArrayList<>();
    }

    public boolean existeCedula(String cedula) {

        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return true;
            }
        }

        return false;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {

        if (empleados.isEmpty()) {
            System.out.println("No existen registros.");
            return;
        }

        for (Empleado e : empleados) {
            e.mostrarInformacion();
        }
    }

    public Empleado buscarPorCedula(String cedula) {

        for (Empleado e : empleados) {

            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }

        return null;
    }

    public boolean eliminarEmpleado(String cedula) {

        Empleado empleado = buscarPorCedula(cedula);

        if (empleado != null) {
            empleados.remove(empleado);
            return true;
        }

        return false;
    }

    public boolean reemplazarEmpleado(String cedula, Empleado nuevoEmpleado) {

        for (int i = 0; i < empleados.size(); i++) {

            if (empleados.get(i).getCedula().equals(cedula)) {
                empleados.set(i, nuevoEmpleado);
                return true;
            }
        }

        return false;
    }

    public void calcularPagos() {

        if (empleados.isEmpty()) {
            System.out.println("No existen empleados.");
            return;
        }

        for (Empleado e : empleados) {

            System.out.println(
                    e.getNombre() +
                            " -> $" +
                            e.calcularPago()
            );
        }
    }

    public void mostrarEstadisticas() {

        int totalMedicos = 0;
        int totalAdministrativos = 0;

        double pagoTotalMedicos = 0;
        double pagoTotalAdministrativos = 0;

        Empleado mayorIngreso = null;

        for (Empleado e : empleados) {

            if (e instanceof Medico) {

                totalMedicos++;
                pagoTotalMedicos += e.calcularPago();

            } else if (e instanceof Administrativo) {

                totalAdministrativos++;
                pagoTotalAdministrativos += e.calcularPago();
            }

            if (mayorIngreso == null ||
                    e.calcularPago() > mayorIngreso.calcularPago()) {

                mayorIngreso = e;
            }
        }

        System.out.println("===== ESTADISTICAS =====");
        System.out.println("Total medicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdministrativos);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total medicos: $" + pagoTotalMedicos);
        System.out.println("Pago total administrativos: $" + pagoTotalAdministrativos);

        if (mayorIngreso != null) {

            System.out.println(
                    "Mayor ingreso: "
                            + mayorIngreso.getNombre()
                            + " ($"
                            + mayorIngreso.calcularPago()
                            + ")"
            );
        }
    }
}