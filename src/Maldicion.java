import java.util.List;

public class Maldicion extends Arma {
    public Maldicion(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean acerto(int valorDeAcierto) {
        return (List.of(3, 5, 7, 9, 13, 15, 17, 19, 20).contains(valorDado()));
    }

    @Override
    public String toString() {
        List<Integer> numerosDeAcierto = List.of(3, 5, 7, 9, 13, 15, 17, 19, 20);
        return "Numeros de acierto: " + numerosDeAcierto;
    }
}
