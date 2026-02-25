public class Sala {
    private final int codigoSala;
    private String descripcion;

    public Sala(int codigoSala, String descripcion) {
        this.codigoSala = codigoSala;
        this.descripcion = descripcion;
    }

    public int getCodigoSala() {
        return codigoSala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Informe en versión toString
     * @return el informe
     */

    @Override
    public String toString() {
        return
                String.format("[%d] %s", this.codigoSala, this.descripcion);
    }
}
