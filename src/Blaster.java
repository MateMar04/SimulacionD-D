import java.util.List;

public class Blaster extends Arma {
    public Blaster(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean acerto(int valorDeAcierto) {
        return (List.of(1, 3, 5, 7, 9, 10, 12, 18, 20).contains(valorDado()));
    }

    @Override
    public String toString() {
        List<Integer> numerosDeAcierto = List.of(1, 3, 5, 7, 9, 10, 12, 18, 20);
        return "Numeros de acierto: " + numerosDeAcierto;
    }
}
