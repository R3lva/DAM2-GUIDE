package model;

public class Persona {
    private String Usuario;
    private  String Correo;
    private  String Contraseña;
    
    public Persona(String usuario, String correo, String contraseña) {
        Usuario = usuario;
        Correo = correo;
        Contraseña = contraseña;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    
}
