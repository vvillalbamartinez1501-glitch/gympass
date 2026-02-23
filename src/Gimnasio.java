public class Gimnasio {
    private int numeroSocio;
    private String nombre;

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
