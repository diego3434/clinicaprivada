package util;

public class Validador {

    public static boolean esCorreoValido(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean esTelefonoValido(String telefono) {
        return telefono.matches("\\d+");
    }

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esEdadValida(int edad) {
        return edad > 0 && edad < 150;
    }

    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }
}