import java.util.List;

public class Desintegracion extends Arma {
    public Desintegracion(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean acerto(int valorDeAcierto) {
        return (List.of(2, 4, 6, 8, 12, 14, 16, 18, 20).contains(valorDado()));
    }

    @Override
    public String toString() {
        List<Integer> numerosDeAcierto = List.of(2, 4, 6, 8, 12, 14, 16, 18, 20);
        return "Numeros de acierto: " + numerosDeAcierto;
    }
}
