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

    /**
     * Inserta en la primera posición libre al socio dado como parámetro en caso de haberlo
     * @param socioNuevo
     * @return true si se pudo false sino
     */

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

    //TODO: SI EL NUMERO DE SOCIO Y EL INDICE EN EL ARRAY DE SOCIOS COINCIDE O NO

    public Socio expulsarSocio(Socio socioAExpulsar){
        Socio socioEliminado = null;
        boolean socioFueEliminado;
        socioFueEliminado = existeSocio(socioAExpulsar.getNumeroSocio());

        if(socioFueEliminado){
            socioEliminado = this.listaSocios[socioEliminado.getNumeroSocio()];
            this.listaSocios[socioEliminado.getNumeroSocio()] = null;
        }

        return socioEliminado;
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

    private int buscarHuecoLibreSocio(){
        int huecoLibreSocio = -1;
        for (int i = 0 ; i < MAX_SOCIOS ; i++){
            if (this.listaSocios[i] == null){
                huecoLibreSocio = i;
            }
        }
        return huecoLibreSocio;
    }

    public boolean designarResponsable(int numeroDeSocioAAsignar){
        boolean responsableAsignado = true;
        /* TODO: QUITAR SI SE PUEDE DESTITUIR AL RESPONSABLE
        if (this.responsableId == -1){
            responsableAsignado = false;
        }
         */
        if (!existeSocio(numeroDeSocioAAsignar)){
            responsableAsignado = false;
        }
        if (responsableAsignado){
            this.responsableId = numeroDeSocioAAsignar;
        }
        return responsableAsignado;
    }

    // Gestión de salas TODO: NO SÉ SI LA GESTIÓN DE SALAS IRÁ EN EL GIMNASIO
    public boolean incorporarSala(Sala salaAIncorporar){
        boolean salaIncorporadaCorrectamente = true;
        int posicionSalaIncorporada = 0;

        if (!existeSala(salaAIncorporar.getCodigoSala())){
            salaIncorporadaCorrectamente = false;
        }
        if (salaIncorporadaCorrectamente){
            posicionSalaIncorporada= buscarHuecoLibreSala();
        }
        if (posicionSalaIncorporada < 0){
            salaIncorporadaCorrectamente = false;
        }
        if (salaIncorporadaCorrectamente){
            listaSalas[posicionSalaIncorporada] = salaAIncorporar;
        }
        return salaIncorporadaCorrectamente;
    }

    private boolean existeSala(int codigoDeSalaBuscada){
        boolean salaEncontrada = false;
        for (int i = 0 ; i < MAX_SALAS && !salaEncontrada  ; i++){
            if (this.listaSalas[i].getCodigoSala() == codigoDeSalaBuscada){
                salaEncontrada = true;
            }
        }
        return salaEncontrada;
    }

    private int buscarHuecoLibreSala(){
        int huecoLibreSala = -1;
        for (int i = 0 ; i < MAX_SALAS ; i++){
            if (this.listaSalas[i] == null){
                huecoLibreSala = i;
            }
        }
        return huecoLibreSala;
    }

    private int buscarIndiceDeSalaEnElArray(int codigoDeSalaBuscada){
        int posicionSalaEncontrada = -1;
        for (int i = 0 ; i < MAX_SOCIOS && posicionSalaEncontrada == -1  ; i++){
            if (this.listaSalas[i].getCodigoSala() == codigoDeSalaBuscada){
                posicionSalaEncontrada = i;
            }
        }
        return posicionSalaEncontrada;
    }

    public String obtenerInforme(){
        StringBuilder i = new StringBuilder("Informe completo:");
        int numeroDeSociosActuales;
        int numeroDeSalasActuales;

        numeroDeSociosActuales = contarNumeroDeSocios();
        numeroDeSalasActuales = contarNumeroDeSalas();

        i.append(this.codigo);
        i.append(" - ");
        i.append(this.nombre);
        i.append("\n");

        i.append("Socios");
        i.append(numeroDeSociosActuales);
        i.append("/");
        i.append(this.MAX_SOCIOS);
        i.append("\n");
        i.append("Listado de socios:");
        for (int p = 0 ; p < MAX_SOCIOS ; p++){
            if (listaSocios[p] != null){
                i.append(listaSocios[p].toString());
                i.append("\n");
            }
        }

        i.append("Responsable del gimnasio:");
        if (this.responsableId != -1){
            i.append(listaSocios[this.responsableId].getNombre());
            i.append("\n");
        }

        i.append("Salas del gimnasio:");
        i.append(numeroDeSalasActuales);
        i.append("/");
        i.append(this.MAX_SALAS);
        i.append("\n");
        i.append("Listado de salas:");
        for (int p = 0 ; p < MAX_SALAS ; p++){
            if (listaSalas[p] != null){
                i.append(listaSalas[p].toString());
                i.append("\n");
            }
        }

        return i.toString();
    }

    private int contarNumeroDeSocios(){
        int numeroDeSociosActuales = 0;
        for (int i = 0 ; i < MAX_SOCIOS ; i++){
            if (this.listaSocios[i] != null){
                numeroDeSociosActuales++;
            }
        }
        return numeroDeSociosActuales;
    }

    private int contarNumeroDeSalas(){
        int numeroDeSalasActuales = 0;
        for (int i = 0 ; i < MAX_SALAS ; i++){
            if (this.listaSalas[i] != null){
                numeroDeSalasActuales++;
            }
        }
        return numeroDeSalasActuales;
    }

    // todo esto también podria hacerse en el existe socio
    // metodo en caso de que no coincida el numero de socio con el indice en el array
    private int buscarIndiceDelSocioEnElArray(int numeroDelSocioBuscado){
        int posicionSocioEncontrado = -1;
        for (int i = 0 ; i < MAX_SOCIOS && posicionSocioEncontrado == -1  ; i++){
            if (this.listaSocios[i].getNumeroSocio() == numeroDelSocioBuscado){
                posicionSocioEncontrado = i;
            }
        }
        return posicionSocioEncontrado;
    }

    public Socio expulsarSocio_nsocioeindicenocoincidentes(Socio socioAExpulsar){
        Socio socioEliminado = null;
        boolean socioFueEliminado;
        int posicionSocioAEliminar;
        socioFueEliminado = existeSocio(socioAExpulsar.getNumeroSocio());

        if(socioFueEliminado){
            posicionSocioAEliminar = buscarIndiceDelSocioEnElArray(socioAExpulsar.getNumeroSocio());
            socioEliminado = this.listaSocios[posicionSocioAEliminar];
            this.listaSocios[posicionSocioAEliminar] = null;
        }

        return socioEliminado;
    }



}
