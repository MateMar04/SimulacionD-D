public class Batalla {

    private final Personaje peleador1;
    private final Personaje peleador2;


    public Batalla(Personaje peleador1, Personaje peleador2) {
        this.peleador1 = peleador1;
        this.peleador2 = peleador2;
    }

    public Personaje pelear() {
        peleador1.sumarBatalla();
        peleador2.sumarBatalla();

        while (peleador1.seguisVivo() && peleador2.seguisVivo()) {
            peleador1.atacar(peleador2);
        }
        if (peleador1.seguisVivo()) {
            peleador1.sumarVictoria();
            Personaje ganador = peleador1;
            return ganador;
        } else {
            peleador2.sumarVictoria();
            Personaje ganador = peleador2;
            return ganador;
        }
    }
}
