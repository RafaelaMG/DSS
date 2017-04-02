
package BusinessLayer;

import java.util.Date;



public class Eleitor {
    String nome;
    int numerodeeleitor;
    int numerodoBI;
    Date datadenascimento;
    String morada;
    
  int cargo;
  
    public Eleitor() {
        this.nome = new String();
        this.numerodeeleitor = 0 ;
        this.numerodoBI = 0;
        this.datadenascimento = new Date();
        this.morada = new String ();
        this.cargo = 1;
    }
    public Eleitor(String nome, int numerodeeleitor, int numerodoBI, Date datadenascimento, String morada,int cargo) {
        this.nome = nome;
        this.numerodeeleitor = numerodeeleitor;
        this.numerodoBI = numerodoBI;
        this.datadenascimento = datadenascimento;
        this.morada = morada;
        this.cargo = cargo;
    }
    public Eleitor(Eleitor e) {
        this.nome = e.getNome();
        this.numerodeeleitor = e.getNumerodeeleitor();
        this.numerodoBI = e.getNumerodoBI();
        this.datadenascimento = e.getDatadenascimento();
        this.morada = e.getMorada();
        this.cargo = e.getCargo();
    }

    public String getNome() {
        return nome;
    }

    public int getNumerodeeleitor() {
        return numerodeeleitor;
    }

    public int getNumerodoBI() {
        return numerodoBI;
    }

    public Date getDatadenascimento() {
        return datadenascimento;
    }

    public String getMorada() {
        return morada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumerodeeleitor(int numerodeeleitor) {
        this.numerodeeleitor = numerodeeleitor;
    }

    public void setNumerodoBI(int numerodoBI) {
        this.numerodoBI = numerodoBI;
    }

    public void setDatadenascimento(Date datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
         public boolean equals(Object o){
        
   if(this == o) return true;
   
   if((o==null)||(this.getClass() != o.getClass()))
   return false;
   else { Eleitor v = (Eleitor) o;
       return ( this.getNome().equals(v.getNome()) && this.getMorada().equals(v.getMorada())
               && this.getNumerodeeleitor()==(v.getNumerodeeleitor()) && this.getNumerodoBI()== (v.getNumerodoBI()) 
               && this.getDatadenascimento().equals(v.getDatadenascimento()));
    }}

    @Override
    public String toString() {
    StringBuilder s = new StringBuilder("-----Eleitor-----\n");
    
    s.append(" Nome: " + this.getNome()+"\n");
    s.append(" Morada:" + this.getMorada()+"\n");
    s.append(" Numero de Eleitor:" + this.getNumerodeeleitor()+"\n");
    s.append(" Numero do BI:" + this.getNumerodoBI()+"\n");
    s.append(" Data de Nascimento:"+this.getDatadenascimento()+"\n");

    
    return s.toString();
    }
 
    public Eleitor Clone() {
     return new Eleitor(this);
    }

    public int getCargo() {
       return this.cargo;
    }
     public void setCargo(int c) {
        this.cargo = c;
    }
}
