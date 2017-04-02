
package BusinessLayer;

import java.util.*;


public class Circulo_Eleitoral {
   private String  sede ;
   private HashSet<Integer> jaVotaram;
   private HashMap<String,HashSet<Eleitor>> candidatos;
   private HashMap<String,Integer> votos;

    public Circulo_Eleitoral() {
    }

    public Circulo_Eleitoral(String sede, HashSet<Integer> jaVotaram, HashMap<String, HashSet<Eleitor>> candidatos, HashMap<String, Integer> votos) {
        this.sede = sede;
        this.jaVotaram = jaVotaram;
        this.candidatos = candidatos;
        this.votos = votos;
    }
    
    public Circulo_Eleitoral(Circulo_Eleitoral c) {
        this.sede = c.getSede();
        this.jaVotaram = c.getJaVotaram();
        this.candidatos = c.getCandidatos();
        this.votos = c.getVotos();
    }

    public String getSede() {
        return sede;
    }

    public HashSet<Integer> getJaVotaram() {
        return jaVotaram;
    }

    public HashMap<String, HashSet<Eleitor>> getCandidatos() {
        return candidatos;
    }

    public HashMap<String, Integer> getVotos() {
        return votos;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public void setJaVotaram(HashSet<Integer> jaVotaram) {
        this.jaVotaram = jaVotaram;
    }

    public void setCandidatos(HashMap<String, HashSet<Eleitor>> candidatos) {
        this.candidatos = candidatos;
    }

    public void setVotos(HashMap<String, Integer> votos) {
        this.votos = votos;
    }
    
       @Override
   public boolean equals(Object o){
        
   if(this == o) return true;
   
   if((o==null)||(this.getClass() != o.getClass()))
   return false;
   else { Circulo_Eleitoral c = (Circulo_Eleitoral) o;
       return ( this.getSede().equals(c.getSede()) && this.getJaVotaram().equals(c.getJaVotaram()) && this.getCandidatos().equals(c.getCandidatos())
               && this.getVotos().equals(c.getVotos()));
    }}
  
    public String toString() {
    StringBuilder s = new StringBuilder("-----Eleição-----\n");
    
    s.append(" Sede:" + this.getSede()+"\n");
    s.append(" Candidatos:" + this.getJaVotaram()+"\n");
    s.append(" Quantos já Votaram:" + this.getCandidatos()+"\n");
    s.append(" Número de Votos:" + this.getVotos()+"\n");
    return s.toString();
    }
    
    public Circulo_Eleitoral Clone() {
     return new Circulo_Eleitoral(this);
    }  
   
   
   
   
   
}
