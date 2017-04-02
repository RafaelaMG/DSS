
package BusinessLayer;

import java.util.*;


public class Eleicao {
   
    private String tipodeeleicao;
    private Date datadeinicio;
    private Date datadefim;
    private int estado;
    private int codEleicao;

    
    public Eleicao(String tipodeeleicao,  Date datadeinicio, Date datadefim,int estado ,int codEleicao) {
        this.tipodeeleicao = tipodeeleicao;
        this.datadeinicio = datadeinicio;
        this.datadefim = datadefim;
        this.estado = estado;
        this.codEleicao = codEleicao;
        
    }
    
    public Eleicao (Eleicao e){
        this.tipodeeleicao = e.getTipodeeleicao();
        this.datadeinicio = e.getDatadeinicio();
        this.datadefim = e.getDatadefim();
        this.estado = e.getEstado();
        this.codEleicao = e.getCodEleicao();
        
    }

    public String getTipodeeleicao() {
        return tipodeeleicao;
    }

   
    public Date getDatadeinicio() {
        return datadeinicio;
    }

    public Date getDatadefim() {
        return datadefim;
    }

    public int getEstado() {
        return estado;
    }

      public int getCodEleicao() {
        return codEleicao;
    }
      
   

    public void setTipodeeleicao(String tipodeeleicao) {
        this.tipodeeleicao = tipodeeleicao;
    }

    public void setDatadeinicio(Date datadeinicio) {
        this.datadeinicio = datadeinicio;
    }

    public void setDatadefim(Date datadefim) {
        this.datadefim = datadefim;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setCodEleicao(int codEleicao) {
        this.codEleicao = codEleicao;
    }

   @Override
         public boolean equals(Object o){
        
   if(this == o) return true;
   
   if((o==null)||(this.getClass() != o.getClass()))
   return false;
   else { Eleicao v = (Eleicao) o;
       return ( this.getTipodeeleicao().equals(v.getTipodeeleicao()) && this.getDatadeinicio().equals(v.getDatadeinicio())
               && this.getDatadefim().equals(v.getDatadefim()) && this.getEstado()== (v.getEstado()) 
               && this.getCodEleicao() == (v.getCodEleicao()));
    }}

    @Override
    public String toString() {
    StringBuilder s = new StringBuilder("-----Eleitor-----\n");
    
    s.append(" Tipo de Eleição: " + this.getTipodeeleicao()+"\n");
    s.append(" Data de Inicio:" + this.getDatadeinicio()+"\n");
    s.append(" Data de Encerramento:" + this.getDatadefim()+"\n");
    s.append(" Estado:" + this.getEstado()+"\n");
    s.append(" Código Eleição:"+this.getCodEleicao()+"\n");
 
    return s.toString();
    }   
    
    public Eleicao Clone() {
     return new Eleicao(this);
    }  
 
    
}
