package app;

public class VettorePunti {

    //attributi
    private Punto[] punti;
    private int x = 0; //posti occupati

    //costruttore default
    public VettorePunti(){
        punti = new Punto[10];
    }

    //costruttore master1
    public VettorePunti(int lunghezza){
        punti = new Punto[lunghezza];
    }

    //costruttore master2
    public VettorePunti(Punto[] p){
        punti = new Punto[p.length];
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null){
                punti[i] = new Punto(p[i]);
                x++;
            }
        }
    }

    //costruttore di copia
    public VettorePunti(VettorePunti vp){
        this();
        for (int i = 0; i < vp.punti.length; i++) {
            if (vp.punti[i] == null){
                punti[i] = new Punto(vp.punti[i]);
            }  
        }
    }

    //to string
    public String toString(){
        String s = "";
        for (int i = 0; i < punti.length; i++) {
            if (punti[i] != null){
                s += "|Punto ["+i+"]: "+punti[i].getX()+", "+punti[i].getY();
            }
        }
        return s;
    }

    //get Punto
    public Punto getPunto(int pos){
        return punti[pos];
    }

    //getElementi
    public Punto[] getElementi(){
        Punto[] p = new Punto[punti.length];
        for (int i = 0; i < punti.length; i++) {
            if (punti[i] != null){
                p[i] = new Punto(punti[i]);
            }
        }
        return p;
    }
    
    //add punto
    public void addPunto(Punto p){
        int i = x;
        boolean done = false;

        while ((i<punti.length)&&(done == false)){
            if (punti[i] == null){
                punti[i] = new Punto(p);
                x++;
                done = true;
            }else{
                System.out.println("Il vettore è pieno");
            }
            i++;
        }
    }

    

    //kill punto
    public void killPunto(int pos){
        if (punti[pos] != null){
            punti[pos] = null;
        }else{
            System.out.println("La posizione è già vuota.");
        }
    }

    //conta punti
    public int contaPunti(){
        int cont = 0;
        for (int i = 0; i < punti.length; i++) {
            if (punti[i] != null){
                cont++;
            }
        }
        return cont;
    }

    //equals
    public boolean equals(VettorePunti vp){
        boolean cond = true;
        int i = 0;
        do{
            if ((punti[i] != null) && (vp.punti[i] != null)){
                if (!(punti[i].equals(vp.punti[i]))){
                    cond = false;
                }
            }
            i++;
        }while ((i < punti.length) && (i < vp.punti.length));


        return cond;
    }

    //distanza massima tra due punti non consecutivi
    public double distMaxNonConsecutivi(){

        double distMax = 0.0;

        for (int i=0; i<punti.length; i++){
            
            for (int j=0; j<punti.length; j++){

                if ((punti[i] != null) && (punti[j] != null)){
                    if (punti[i].distanza(punti[j]) > distMax){
                    distMax = punti[i].distanza(punti[j]);
                    }
                }
            }
        }

        return distMax;
    }

    //percorso totale
    //questo metodo funziona se i punti sono già in ordine
    public double percorsoTotale(){
        
        double tot = 0.0;

        for (int i=0; i<punti.length-1; i++){
            tot += punti[i].distanza(punti[i+i]);
        }

        return tot;
    }
    
    //compito-----------------------------------------------------------------------------
    //distanza max tra due punti consecutivi
    public DistanzaMax distMax(){

        double distMax = 0.0;
        int posP1 = 0;
        int posP2 = 2;

        for (int i = 0; i < punti.length-1; i++) {

            if (punti[i] != null && punti[i+1] != null){

                if (punti[i].distanza(punti[i+1]) > distMax){

                    distMax = punti[i].distanza(punti[i+1]);
                    posP1 = i;
                    posP2 = i+1;
                }
            }
        }
        //a questo punto in posP1/P2 ci sono gli indici dei due punti 
        //consecutivi con la distanza maggiore. Utilizzo quindi la classe Distanza
        return new DistanzaMax(punti[posP1], punti[posP2], distMax);
    }

    //MEDIA PERCORSO TOTALE
    public double distmed(){
        return percorsoTotale()/punti.length-1;
    }
    //-----------------------------------------------------------------------------
    
    //trovo colore più vicino da due punti
    public String colorevicino(Punto p){
        String s=punti[0].getColore();
        double distMin=punti[0].distanza(p);
            for (int i = 1; i < punti.length; i++) {
                if(punti[i]!=null){
                    if(punti[i].distanza(p)<distMin){
                        distMin=punti[i].distanza(p);
                        s=punti[i].getColore();
                    }
                }
            }


        return s;
    }
    //ordina punti 
    public void ordinaPunti(){

        int indexP = 0;
        double distMin = 0.0;
        Punto p0 = new Punto(0.0, 0.0, "blu"); //punto coordinate 00

        //questo for trova il punto più vicino a 00, quindi quello che va inserito per primo nel vettore
        for (int i = 0; i < punti.length; i++) {
            if (p0.distanza(punti[i]) < distMin){
                distMin = p0.distanza(punti[i]);
                indexP = i;
            }
        }

        double distMin2 = 0.0;

        for (int i = 0; i < punti.length; i++) {
            //scambio
            Punto provv = new Punto(punti[i]);
            punti[i] = new Punto(punti[indexP]);
            punti[indexP] = new Punto(provv);

            //questa parte va rivista
            for (int j = 0; j < punti.length; j++) {
                for (int j2 = 0; j2 < punti.length; j2++) {
                    if(punti[j].distanza(punti[j2]) < distMin2){
                        distMin2 = punti[j].distanza(punti[j2]);
                        indexP = j;
                    }
                }
            }
        }

    }
}
