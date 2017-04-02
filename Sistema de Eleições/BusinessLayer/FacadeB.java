
package BusinessLayer;

import DataLayer.FacadeD;
import java.io.File;
import java.util.*;


public class FacadeB {
    
    public static HashMap<Integer,Integer> Login(int nrEleitor,String password){
        Eleitor a = null; 
       HashMap<Integer,Integer> ret = new  HashMap<Integer,Integer>();
        a = FacadeD.Login(nrEleitor,password);
      if (a!=null){
        if (a.getCargo() == 1)//normal
            ret.put(1,a.getNumerodeeleitor());
        else if (a.getCargo() == 2 ||a.getCargo() == 5 ) //partido
             ret.put(2,a.getNumerodeeleitor());
        else if (a.getCargo() == 3) //comisao
             ret.put(3,a.getNumerodeeleitor());
        else if (a.getCargo() == 4) //tribunal
             ret.put(4,a.getNumerodeeleitor());
       
      }else  ret.put(0,0);
        return ret;
    }


//consultar eleiçoes passadas
public static HashMap<Integer,String> ConsEp(){
        
HashMap<Integer,String> ret = new HashMap<Integer,String>();
HashSet<Eleicao> aux =  FacadeD.consEp();
for(Eleicao a :aux ){
   
    ret.put(a.getCodEleicao(),a.getTipodeeleicao());
}

return ret;
}

//consultar eleiçoes activas
public static HashMap<Integer,String> ConsEa(){
        
HashMap<Integer,String> ret = new HashMap<Integer,String>();
HashSet<Eleicao> aux =  FacadeD.consEa();
for(Eleicao a :aux ){
   
    ret.put(a.getCodEleicao(),a.getTipodeeleicao());
}

return ret;
}

//consultar eleiçoes activas
public static HashMap<Integer,String> ConsEf(){
        
HashMap<Integer,String> ret = new HashMap<Integer,String>();
HashSet<Eleicao> aux =  FacadeD.consEf();
for(Eleicao a :aux ){
   
    ret.put(a.getCodEleicao(),a.getTipodeeleicao());
}

return ret;
}

public static HashMap<Integer,String> ConsEfP(){
        
HashMap<Integer,String> ret = new HashMap<Integer,String>();
HashSet<Eleicao> aux =  FacadeD.consEfP();
for(Eleicao a :aux ){
   
    ret.put(a.getCodEleicao(),a.getTipodeeleicao());
}

return ret;
}

public static HashMap<Integer,String> ConsEfA(){
        
HashMap<Integer,String> ret = new HashMap<Integer,String>();
HashSet<Eleicao> aux =  FacadeD.consEfA();
for(Eleicao a :aux ){
   
    ret.put(a.getCodEleicao(),a.getTipodeeleicao());
}

return ret;
}

//vai buscar os candidados de uma eleiçao no circulo em que o eleitor pode votar
public static HashMap<Integer,String> mostarCandidatos(int codEleicao, int nrEleitor){
    
    HashMap<Integer,String> ret = new HashMap<Integer,String>();
    
   
     
         Eleitor a = FacadeD.getEleitor(nrEleitor);
           System.out.println("eleitor:"+nrEleitor);
        System.out.println(a.toString());
       ret = FacadeD.getCandidatos(codEleicao, a.getMorada());
   
    return ret;
}
//vai buscar as candidaturas por aprovar de uma eleiçao
 public static HashMap<Integer,String> buscaCporAprovar(int codEleicao){
    

 
      HashMap<Integer,String> ret   = new   HashMap<Integer,String> ();
        ret =  FacadeD.getCporAprovar(codEleicao);

   // 
      
      return ret;
}
//vai buscar os elementos da candidatura para um circulo    
public static HashMap<Integer,String> detalhesCandidatura(int candidatura){
 HashMap<Integer,String> ret = new HashMap<Integer,String>();
 ret = FacadeD.detalhesCandidatura(candidatura);
 return ret;
    
}
//mostra membros de um partido 
public static HashMap<Integer,String> membrosP(int codEleitor){
    HashMap<Integer,String> ret = new HashMap<Integer,String>();
    Partido a = FacadeD.getMembros(codEleitor);
    for(Eleitor b : a.getElementos().values()){
        ret.put(b.getNumerodeeleitor(), b.getNome());
    }
    
    return ret;
}

public static HashMap<Integer,String> getCirculos(int codEleicao){
    HashMap<Integer,String> ret = new HashMap<Integer,String>();
    ret = FacadeD.getCirculos( codEleicao);
    return ret;
}
public static int aprovaCandidatura(int codCandidatura  ){

return FacadeD.aprovacandidatura(codCandidatura);
}
public static int rejeitaCandidatura( int codCandidatura ){
    return FacadeD.rejeitacandidatura(codCandidatura);
}

public static int removeEl(int nrEleitor){
return FacadeD.removeEl(nrEleitor);

}

public static int addEl(int nrEleitor,String nome, Date date,String morada, int nrBI, int nrEleitorP){
    return FacadeD.addEl(nrEleitor,nome,date,morada,nrBI,nrEleitorP);
}

public static int  voto(int idLista,int nrEleitor){

return FacadeD.voto(idLista,nrEleitor);
}
public static int alterLider(int nrEleitor, int nrEleitorP){
    return FacadeD.alterLider(nrEleitor,nrEleitorP);
}
public static int mandacandidatura(File anexo,int nrEleitor,int codEleicao){
  return FacadeD.mandaCandidatura(nrEleitor,codEleicao);  
    
}

public static int mandaLista(int codEleicao , int codCirculo , HashSet<Integer> membros ) {
    return FacadeD.mandaLista(codEleicao,codCirculo,membros);
}
// Por fazer ...
// 
  public static HashMap<String,Integer> Consulta(int codEleicao){
      return FacadeD.Consulta(codEleicao);
  }
int comecaEleicao(Date datai, Date dataf,HashSet<String> circulos,int tipo ){
  
    return FacadeD.comecaEleicao(datai,dataf,circulos,tipo);
    
    
}

public static int  acabarEleicao(int codEleicao){
    return FacadeD.acabarEleicao(codEleicao);
} 

public static HashMap<Integer,Boolean> estadoC(int nrEleitor){
    return FacadeD.estadoC(nrEleitor);
}
//
//
//
//
//
//
//
//
//
//
/*

*/
}