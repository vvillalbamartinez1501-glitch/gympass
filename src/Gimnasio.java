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
            if(!existeSocio(socioNuevo.getNumeroSocio())){
                socioRegistradoCorrectamente = false;
            }
        }
        if (socioRegistradoCorrectamente){
            this.listaSocios[posicionNuevoSocio] = socioNuevo;
        }

        return socioRegistradoCorrectamente;
    }

    public Socio expulsarSocio(Socio socioAExpulsar){

    }

    private boolean existeSocio(int numeroDelSocioBuscado){
        boolean socioEncontrado = false;
        for (int i = 0 ; i < MAX_SOCIOS && !socioEncontrado  ; i++){
            if (this.listaSocios[i].getNumeroSocio() == numeroDelSocioBuscado){
                socioEncontrado = true;
            }
        }
        return socioEncontrado;
    }

    public boolean designarResponsable(int numeroDeSocioADesignar){

    }

    public String obtenerInforme(){
        /*codigo y nombre
        n de socios / capacidad de socios
        responsable actual
        listado de socios
        numero de salas ocupadas / capacidad
        listado de salas
         */
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



}
