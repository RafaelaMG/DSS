
package BusinessLayer;


import java.util.Objects;
import java.util.TreeMap;


public class Partido {
    private int lider;
    private int secretario;
    private TreeMap<Integer,Eleitor> elementos;
 
    private String nomedopartido;

   public Partido(){
   this.elementos = new TreeMap<Integer,Eleitor>();
   lider = 0;
   lider = 0;
   nomedopartido = "OLA";
   }

    public Partido(int lider,int sec, TreeMap<Integer, Eleitor> elementos,  String nomedopartido) {
        this.lider = lider;
        this.secretario = sec;
        this.elementos = elementos;
        
        this.nomedopartido = nomedopartido;
    }

    public Partido(Partido p) {
        this.lider = p.getLider();
        this.secretario = p.getSecretario();
        this.elementos = p.getElementos();
       
        this.nomedopartido = p.getNomedopartido();
    }

    public int getLider() {
        return lider;
    }

    public int getSecretario() {
        return secretario;
    }
    
    public TreeMap<Integer, Eleitor> getElementos() {
        return elementos;
    }

 

    public String getNomedopartido() {
        return nomedopartido;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

    public void setSecretario(int secretario) {
        this.secretario = secretario;
    }

    public void setElementos(TreeMap<Integer, Eleitor> elementos) {
        this.elementos = elementos;
    }

   

    public void setNomedopartido(String nomedopartido) {
        this.nomedopartido = nomedopartido;
    }

    public void addMembro(Eleitor a){
       
        this.elementos.put(a.getNumerodeeleitor(), a);
    }
     public void killMembro(Eleitor a){
        this.elementos.remove(a.getNumerodeeleitor());
    }
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

   

    @Override
    public String toString() {
    StringBuilder s = new StringBuilder("-----Partido-----\n");
    
    s.append(" Nome: " + this.getNomedopartido()+"\n");
    
    s.append(" Líder do Partido:" + this.getLider()+"\n");
    s.append(" Secretário Geral:" + this.getSecretario()+"\n");
    s.append(" Elementos do Partido:" + this.getElementos()+"\n");
   
    
    return s.toString();
    }
 
    public Partido Clone() {
     return new Partido(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        if (this.lider != other.lider) {
            return false;
        }
        if (this.secretario != other.secretario) {
            return false;
        }
        
        if (!Objects.equals(this.nomedopartido, other.nomedopartido)) {
            return false;
        }
        return true;
    }
    
    
}
