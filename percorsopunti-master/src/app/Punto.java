package app;

public class Punto{

    //attributi
    private double x;
    private double y;
    private String colore="";

    //costruttore
    public Punto(double x, double y, String s){
        setX(x);
        setY(y);
        setColore(s);
    }


    //costruttore copia
    public Punto(Punto p){
        this.x = p.getX();
        this.y = p.getY();
        setColore(p.getColore());
    }

    //costruttore default
    public Punto(){}

    //getter e setter
    public void setX(double x){
        this.x = x;
    }
    public double getX(){
        return x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double getY(){
        return y;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public String getColore() {
        return colore;
    }

    //distanza
    public double distanza(Punto p){
        return Math.sqrt(Math.pow(getX()-p.getX(),2)+Math.pow(getY()-p.getY(),2));
    }

    //equals
    public boolean equals(Punto p){
        return ((x==p.x)&&(y==p.y) &&(colore.equals(p.colore)));
    }

    //to string
    public String toString(){
        return "X: "+x+"Y: "+y+" Colore: "+colore;
    }
}


