public class Batalla {

    private final Personaje peleador1;
    private final Personaje peleador2;


    public Batalla(Personaje peleador1, Personaje peleador2) {
        this.peleador1 = peleador1;
        this.peleador2 = peleador2;
    }

    public void pelear() {
        peleador1.sumarBatalla();
        peleador2.sumarBatalla();

        while (peleador1.seguisVivo() && peleador2.seguisVivo()) {
            if (peleador1.getAgilidad() > peleador2.getAgilidad()) {
                peleador1.atacar(peleador2);
                peleador2.atacar(peleador1);
            } else {
                peleador2.atacar(peleador1);
                peleador1.atacar(peleador2);
            }
        }
        if (peleador1.seguisVivo()) {
            peleador1.sumarVictoria();
            Personaje ganador = peleador1;
            System.out.println("Gano " + peleador1.nombre);
        } else {
            peleador2.sumarVictoria();
            Personaje ganador = peleador2;
            System.out.println("Gano " + peleador2.nombre);
        }
    }
}
