import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {


        Dado d20 = new Dado(20);

        Arma blaster = new Blaster("Blaster");
        Arma desintegracion = new Desintegracion("Desintegracion");
        Arma lightsaber = new Lightsaber("Lightsaber");
        Arma maldicion = new Maldicion("Maldicion");

        Raza droide = new Droide();
        Raza duende = new Duende();
        Raza humano = new Humano();
        Raza sangheili = new Sangheili();


        Personaje soldado = new Soldado("Finn", d20, blaster, droide);
        Personaje jedi = new Jedi("Anakin Skywalker", d20, lightsaber, humano);

        List<Personaje> personajes = new ArrayList<>(Arrays.asList(soldado, jedi));

        MyScanner in = new MyScanner();

        Personaje personaje;

        Personaje peleador1;
        Personaje peleador2;

        boolean seguir = true;


        do {
            int opcion = in.scanOption("Batalla de Titanes", "Crear", "Batalla", "Salir");

            switch (opcion) {
                case 1:
                    String nombre = in.scanString("Escriba el nombre del personaje");
                    Arma arma = in.scanOption("Seleccione el arma para su personaje", blaster, desintegracion, lightsaber, maldicion);
                    Raza raza = in.scanOption("Seleccione la raza de su personaje", droide, duende, humano, sangheili);
                    personaje = in.scanOption("Seleccione el tipo de personaje",
                            new Cazarecompenzas(nombre, d20, arma, raza),
                            new HermanaDeLaNoche(nombre, d20, arma, raza),
                            new Soldado(nombre, d20, arma, raza),
                            new Jedi(nombre, d20, arma, raza));
                    personajes.add(personaje);
                    break;
                case 2:
                    peleador1 = in.scanOption("Seleccione el peleador 1", personajes.toArray(Personaje[]::new));
                    peleador2 = in.scanOption("Seleccione el peleador 2", personajes.toArray(Personaje[]::new));
                    Batalla simulacion = new Batalla(peleador1, peleador2);
                    simulacion.pelear();
                    break;
                case 3:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (seguir);

    }

    private static class MyScanner {
        private final PrintStream out;
        private final Scanner sc;

        public MyScanner() {
            this.out = System.out;
            this.sc = new Scanner(System.in);
        }

        public <T> T scanOption(String mensaje, T... opciones) {
            return opciones[scanOption(mensaje, Arrays.stream(opciones).map(o -> o.getClass().getSimpleName() + " ---> " + o).toArray(String[]::new)) - 1];
        }

        public int scanOption(String mensaje, String... opciones) {
            printMensaje(mensaje);
            int opcion;
            boolean opcionValida;
            do {
                for (int i = 0; i < opciones.length; i++) {
                    out.println((i + 1) + ". " + opciones[i]);
                }
                opcion = sc.nextInt();
                opcionValida = opcion >= 1 && opcion <= opciones.length;
                if (!opcionValida) {
                    out.println("Opcion " + opcion + " no valida.");
                }
            } while (!opcionValida);
            return opcion;
        }

        private void printMensaje(String mensaje) {
            out.println("---" + mensaje + "---");
        }

        public String scanString(String mensaje) {
            printMensaje(mensaje);
            Pattern delimiter = sc.delimiter();
            sc.useDelimiter("\\r\\n|[\\n\\x0B\\x0C\\r\\u0085\\u2028\\u2029]"); // https://stackoverflow.com/questions/4058912/scanner-doesnt-read-whole-sentence-difference-between-next-and-nextline-o
            String s = sc.next();
            sc.useDelimiter(delimiter);
            return s;
        }
    }
}
