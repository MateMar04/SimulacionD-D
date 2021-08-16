import java.util.Optional;

public abstract class Arma {

    private final String nombre;
    private final Dado d6 = new Dado(6);

    protected final int valorDado() {
        return d6.rollear();
    }

    public Arma(String nombre) {
        this.nombre = nombre;
    }


    protected abstract boolean acerto(int valorDeAcierto);

    public Optional<Integer> disparar(int valorDisparo) {
        if (acerto(valorDisparo)) {
            return Optional.of(valorDado());
        }
        return Optional.empty();
    }
}
