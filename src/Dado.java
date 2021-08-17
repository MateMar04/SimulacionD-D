public class Dado {

    private final int caras;

    public Dado(int caras) {
        this.caras = caras;
    }

    public int rollear() {
        int resultado = (int) Math.floor(Math.random() * caras) + 1;
        return resultado;
    }
}
