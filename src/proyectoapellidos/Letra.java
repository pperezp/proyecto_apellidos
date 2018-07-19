package proyectoapellidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Letra {

    private static Random r;
    private static final List<String> CONSONANTES;

    static {
        CONSONANTES = new ArrayList<>();

        // init consonantes
        for (int i = 98; i <= 122; i++) {
            // si no es una vocal
            if (i != 101 && i != 105 && i != 111 && i != 117) { 
                if((char) i != 'x' && (char) i != 'w')
                    Letra.CONSONANTES.add(String.valueOf((char) i));
            }
        }
    }

    public static String getApellido(int silabas) {
        StringBuilder apellido = new StringBuilder();
        String consonante;
        String vocal;

        for (int i = 0; i < silabas; i++) {
            consonante = Letra.getConsonante();
            apellido.append(consonante);

            switch (consonante) {
                case "n":
                    if (r.nextBoolean()) {
                        apellido.append(Letra.getConsonante());
                    }
                    break;
                case "b":
                    if (r.nextBoolean()) {
                        apellido.append("r");
                    }
                    break;
                case "c":
                    if (r.nextBoolean()) {
                        apellido.append("h");
                    }
                    break;
                default:
                    break;
            }

            vocal = Letra.getVocal();
            apellido.append(vocal);

            switch (vocal) {
                case "u":
                    if (r.nextBoolean()) {
                        apellido.append("i");
                    }else if(r.nextBoolean()){
                        apellido.append("e");
                    }
                    break;
                case "i":
                    if (r.nextBoolean()) {
                        apellido.append("a");
                    }else if(r.nextBoolean()){
                        apellido.append("e");
                    }else if(r.nextBoolean()){
                        apellido.append("o");
                    }
                    break;
            }
        }

        if (r.nextBoolean()) {
            apellido.append(Letra.getConsonante());
        }

        return apellido.toString();
    }

    private static String getConsonante() {
        r = new Random();
        int index = r.nextInt(Letra.CONSONANTES.size());
        return Letra.CONSONANTES.get(index);
    }

    private static String getVocal() {
        r = new Random();

        switch (r.nextInt(5)) {
            case 0:
                return "a";
            case 1:
                return "e";
            case 2:
                return "i";
            case 3:
                return "o";
            default:
                return "u";
        }
    }
}
