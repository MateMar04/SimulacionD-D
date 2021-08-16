import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        int opcion = in.scanOption("Batalla de Titanes", "Crear", "Elegir personaje");

        Personaje personaje;

        switch (opcion) {
            case 1:
                String nombre = in.scanString("Escriba el nombre del personaje");
                Arma arma = in.scanOption("Seleccione el arma para su personaje", blaster, desintegracion, lightsaber, maldicion);
                Raza raza = in.scanOption("Seleccione la Raza de su personaje", droide, duende, humano, sangheili);
                personaje = in.scanOption("Seleccione el tipo de personaje",
                        new Cazarecompenzas(nombre, d20, arma, raza),
                        new HermanaDeLaNoche(nombre, d20, arma, raza),
                        new Soldado(nombre, d20, arma, raza),
                        new Jedi(nombre, d20, arma, raza));
                personajes.add(personaje);
                break;
            case 2:
                personaje = in.scanOption("Seleccione el tipo de personaje", personajes.toArray(Personaje[]::new));

        }

        Batalla batalla = new Batalla(soldado, jedi);
    }

    private static class MyScanner {
        private final PrintStream out;
        private final Scanner sc;

        public MyScanner() {
            this.out = System.out;
            this.sc = new Scanner(System.in);
        }

        public <T> T scanOption(String mensaje, T... opciones) {
            return opciones[scanOption(mensaje, Arrays.stream(opciones).map(Object::getClass).map(Class::getSimpleName).toArray(String[]::new))];
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
            return opcion - 1;
        }

        private void printMensaje(String mensaje) {
            out.println("---" + mensaje + "---");
        }

        public String scanString(String mensaje) {
            printMensaje(mensaje);
            return sc.next();
        }
    }
}
