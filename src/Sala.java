public class Sala {
    private final int NUMERO_SOCIO;
    private String nombre;

    // constructor


    public Sala(int numeroSocio, String nombre) {
        this.NUMERO_SOCIO = numeroSocio;
        this.nombre = nombre;
    }

    // getters
    public int getNumeroSocio() {
        return this.NUMERO_SOCIO;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString(){
        return
                String.format("[%d] %s", this.NUMERO_SOCIO, this.nombre);

    }
}
