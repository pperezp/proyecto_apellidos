package proyectoapellidos;

import java.util.Random;

public class ProyectoApellidos {

    public static void main(String[] args) {
        Random r = new Random();
        
        for (int i = 0; i < 2500; i++) {
            System.out.println(Letra.getApellido(3));
        }
    }

}
