package Agenda;


public class Agenda {

    //Atributos
    private Contacto[] contactos;

    //Constructores
    public Agenda() {
        this.contactos = new Contacto[10]; 
    }

    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio]; 
    }

    
    public void aniadirContacto(Contacto c) {

        if (existeContacto(c)) { 
            System.out.println("El contacto con ese nombre ya existe");
        } else if (agendaLlena()) { 
            System.out.println("La agenda esta llena, no se pueden meter mas contactos");
        } else {

            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) { 
                    contactos[i] = c; 
                    encontrado = true; 
                }
            }

            if (encontrado) {
                System.out.println("Se ha añadido");
            } else {
                System.out.println("No se ha podido añadir");
            }
        }

    }

    
    public boolean existeContacto(Contacto c) {

        for (int i = 0; i < contactos.length; i++) {
            
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }
        }
        return false;

    }

   
    public void listarContactos() {

        if (huecosLibre() == contactos.length) {
            System.out.println("No hay contactos que mostrar");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) { 
                    System.out.println(contactos[i]);
                }
            }
        }

    }

    
    public void buscarPorNombre(String nombre) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            
            if (contactos[i] != null && contactos[i].getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                System.out.println("Su telefono es " + contactos[i].getTelefono()); 
                encontrado = true; 
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado el contacto");
        }

    }

   
    public boolean agendaLlena() {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { 
                return false; 
            }
        }

        return true; 

    }

    
    public void eliminarContacto(Contacto c) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null; 
                encontrado = true; 
            }
        }

        if (encontrado) {
            System.out.println("Se ha eliminado el contacto");
        } else {
            System.out.println("No se ha eliminado el contacto");

        }

    }

    
    public int huecosLibre() {

        int contadorLibres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contadorLibres++; 
            }
        }

        return contadorLibres;

    }

}
