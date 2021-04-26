package app;

public class DistanzaMax{

    //attributi
    private Punto p1 = new Punto();
    private Punto p2 = new Punto();
    private double distanza =  0.0;

    //costruttore master
    public DistanzaMax(Punto p1, Punto p2, double distanza){
        setP1(new Punto(p1));
        setP2(new Punto(p2));
        setDistanza(distanza);
    }

    //costruttore con VettorePunti come parametro formale  
    public DistanzaMax(VettorePunti vp){
        
        double distMax = 0.0;
        int posP1 = 0;
        int posP2 = 2;
        
        //getELementi restituisce un vettore di punti
        for (int i = 0; i < vp.getElementi().length; i++) {

            if (vp.getElementi()[i] != null && vp.getElementi()[i+1] != null){

                if (vp.getElementi()[i].distanza(vp.getElementi()[i+1]) > distMax){
                    distMax = vp.getElementi()[i].distanza(vp.getElementi()[i+1]);
                    posP1 = i;
                    posP2 = i+1;
                }
            }
        }
        setP1(new Punto(vp.getElementi()[posP1]));
        setP2(new Punto(vp.getElementi()[posP2]));
        setDistanza(distMax);
    }

    //costruttore default
    public DistanzaMax(){}

    //getter e setter
    public void setP1(Punto p1){
        this.p1 = new Punto(p1);
    }
    public void setP2(Punto p2){
        this.p2 = new Punto(p2);
    }
    public void setDistanza(double distanza){
        this.distanza = distanza;
    }
    public Punto getP1(){
        return p1;
    }
    public Punto getP2(){
        return p2;
    }
    public double getDistanza(){
        return distanza;
    }

    //to string
    public String toString(){
        return p1.toString()+" | "+p2.toString()+" | Distanza: "+distanza;
    }
}