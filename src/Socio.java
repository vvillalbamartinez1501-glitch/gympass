public class Socio {
    private final int numeroSocio;
    private String nombre;

    // constructor

    public Socio(int numeroSocio, String nombre) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
    }

    // getters
    public int getNumeroSocio() {
        return this.numeroSocio;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString(){
        return
                String.format("[%d] %s", this.numeroSocio, this.nombre);

    }
}
