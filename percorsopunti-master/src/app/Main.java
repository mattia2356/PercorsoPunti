package app;

public class Main {
    public static void main(String[] args) {
        
        //creazione punti
        Punto p1 = new Punto(1, 1,"rosso");
        Punto p2 = new Punto(2, 3, "giallo");
        Punto p3 = new Punto(p2);

        //creazione di un vettore (no classe VettorePunti)
        Punto[] vett = new Punto[3];

        //inserimento dei punti nel vettore (deep copy)
        vett[0] = new Punto(p1.getX(), p1.getY(), p1.getColore());
        vett[1] = new Punto(p2.getX(), p2.getY(), p2.getColore());
        vett[2] = new Punto(p3.getX(), p3.getY(), p3.getColore());
    
        //utilizzo costruttore master1 (VettorePunti)
        VettorePunti punti1 = new VettorePunti(3);

        //utilizzo la addPunto
        punti1.addPunto(p1);
        punti1.addPunto(p2);
        punti1.addPunto(p3);

        //utilizzo costruttore master2 (VettorePunti)
        VettorePunti punti2 = new VettorePunti(vett);

        //utilizzo costruttore di copia(VettorePunti)
        VettorePunti punti3 = new VettorePunti(punti2);

        //utilizzo il metodo "equals"
        if (punti2.equals(punti1)){
            System.out.println("'punti1' e 'punti2' sono uguali\n");
        }else{
            System.out.println("'punti1' e 'punti2' non sono uguali\n");
        }

        //Distanza media
        System.out.println("Distanza media: "+punti1.distmed());
        //utilizzo contaPunti
        System.out.println("'punti1' contiene "+punti1.contaPunti()+" punti\n");

        System.out.println("Punto Colore Vicino: "+punti1.colorevicino(p2));
        //utilizzo killPunto
        punti1.killPunto(2);
        System.err.println("è stato eliminato un elemento di 'punti1':");
        System.out.println("'punti1' contiene "+punti1.contaPunti()+" punti\n");

        //utilizzo punti3 
        System.out.println(punti3.toString());

        //creo un oggetto dm
        System.out.println(punti1.distMax().toString());
        
        //utilizzo costruttore secondario
        DistanzaMax dm = new DistanzaMax(punti1);
        System.out.println(dm.toString());


    }
}