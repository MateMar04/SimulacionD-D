import java.util.List;

public class Lightsaber extends Arma {

    public Lightsaber(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean acerto(int valorDeAcierto) {
        return (List.of(3, 5, 7, 9, 12, 14, 16, 18, 20).contains(valorDado()));
    }

    @Override
    public String toString() {
        List<Integer> numerosDeAcierto = List.of(3, 5, 7, 9, 12, 14, 16, 18, 20);
        return "Numeros de acierto: " + numerosDeAcierto;
    }
}
