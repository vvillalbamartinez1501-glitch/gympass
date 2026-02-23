
public class Main {
    public static void main(String[] args) {

        // crear 2 socios + info.
        Socio pingu = new Socio(1,"Pingu");
        Socio venus = new Socio(2,"Venus Emilio");

        //crear 2 salas  + info.
        Sala crossfit = new Sala(1,"Sala de crossfit");
        Sala maquinas = new Sala(2,"Sala de máquinas");


        System.out.print(pingu.toString());
        System.out.print(venus.toString());
        System.out.print(crossfit.toString());
        System.out.print(maquinas.toString());
    }

}
