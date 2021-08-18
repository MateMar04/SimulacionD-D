public abstract class Personaje {

    private final Arma arma;
    private String nombre;
    private int vida;
    private final int fuerza;
    private final int agilidad;
    private final int constitucion;
    private int numVictorias;
    private int numBatallas;
    private final int habilidadFuerza;
    private final int habilidadAgilidad;

    public Personaje(String nombre, Dado dado, Arma arma, Raza raza) {
        this.nombre = nombre;
        this.fuerza = dado.rollear() + raza.getModFuerza();
        this.agilidad = dado.rollear() + raza.getModAgilidad();
        this.constitucion = dado.rollear() + raza.getModConstitucion();
        this.arma = arma;

        habilidadFuerza = habilidades(fuerza);
        habilidadAgilidad = habilidades(agilidad);

        this.vida = 15 + habilidades(constitucion);

    }

    public int getAgilidad() {
        return agilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarVictoria() {
        numVictorias++;
    }

    public void sumarBatalla() {
        numBatallas++;
    }

    public boolean seguisVivo() {
        return vida > 0;
    }

    private static int habilidades(int n) {
        return (n - 10) / 2;
    }


    public void atacar(Personaje otro) {
        Dado d20 = new Dado(20);
        Dado d4 = new Dado(4);

        int valord20 = d20.rollear();
        boolean esCritico = valord20 == 20;
        int danioCritico = esCritico ? d4.rollear() : 0;

        var danio = arma.disparar(valord20)
                .map(i -> i + habilidadFuerza)
                .map(i -> i + danioCritico)
                .orElse(0);

        if (esCritico) {
            System.out.println("+++Daño critico+++");
        }


        otro.vida -= danio;
        System.out.println(this.nombre + " le hizo " + danio + " de daño a " + otro.nombre);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Vida: " + vida +
                ", Fuerza: " + habilidadFuerza +
                ", Agilidad: " + habilidadAgilidad +
                " ---> Batallas: " + numBatallas +
                "/Victorias: " + numVictorias;
    }

    public int vidaReset() {
        return this.vida = 15 + habilidades(constitucion);
    }

}
