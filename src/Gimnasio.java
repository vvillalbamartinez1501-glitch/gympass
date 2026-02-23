public class Gimnasio {
    private String codigo;
    private String nombre;
    private Socio[] listaSocios;
    private Sala[] listaSalas;
    private int responsableId;

    private final int MAX_SOCIOS = 12;
    private final int MAX_SALAS = 6;

    public Gimnasio(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaSocios = new Socio[MAX_SOCIOS];
        this.listaSalas = new Sala[MAX_SALAS];
        this.responsableId = -1;
    }

    public boolean registrarSocio(Socio socioNuevo){
        boolean socioRegistradoCorrectamente = true;
        int posicionNuevoSocio;

        posicionNuevoSocio = buscarHuecoLibreSocio();
        if (posicionNuevoSocio == -1){
            socioRegistradoCorrectamente = false;
        }
        if (socioRegistradoCorrectamente){
            if(buscarSiSocioRegistrado(socioNuevo) != null){
                socioRegistradoCorrectamente = false;
            }
        }
        if (socioRegistradoCorrectamente){
            this.listaSocios[posicionNuevoSocio] = socioNuevo;
        }

        return socioRegistradoCorrectamente;
    }

    public int buscarHuecoLibreSocio(){
        int huecoLibreSocio = -1;
        for (int i = 0 ; i < MAX_SOCIOS ; i++){
            if (this.listaSocios[i] == null){
                huecoLibreSocio = i;
            }
        }
        return huecoLibreSocio;
    }

    public Socio buscarSiSocioRegistrado(Socio socioBuscado){
        Socio socioEncontrado = null;
        for (int i = 0 ; i < MAX_SOCIOS && socioEncontrado == null ; i++){
            if (this.listaSocios[i].getNumeroSocio() == socioBuscado.getNumeroSocio()){
                socioEncontrado = this.listaSocios[i];
            }
        }
        return socioEncontrado;
    }

}
