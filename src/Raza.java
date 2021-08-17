public abstract class Raza {

    protected String nombreRaza;
    protected int modFuerza;
    protected int modAgilidad;
    protected int modConstitucion;


    public int getModFuerza() {
        return modFuerza;
    }

    public int getModAgilidad() {
        return modAgilidad;
    }

    public int getModConstitucion() {
        return modConstitucion;
    }

    @Override
    public String toString() {
        return "Fuerza: " + modFuerza +
                ", Agilidad: " + modAgilidad +
                ", Constitucion: " + modConstitucion;
    }
}
