/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Eleicao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import BusinessLayer.Eleitor;
import BusinessLayer.Partido;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class FacadeD {

    static int started;
    static Connection c;

    private static void connect() {
        if (started != 1) {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String USER = "root";
            String PASS = "griffin";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                c = DriverManager.getConnection(url, USER, PASS);
                started = 1;
            } catch (InstantiationException ex) {
                Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static Eleitor Login(int nrEleitor, String password) {
        Eleitor ret = null;
        connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from Eleitor  where nrEleitor = ? and password = ? ");
            s1.setInt(1, nrEleitor);
            s1.setString(2, password);

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {

                ret = new Eleitor(rs.getString(2), rs.getInt(1), rs.getInt(3), rs.getDate(5), rs.getString(4), rs.getInt(6));

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public static Eleitor getEleitor(int nrEleitor){
         Eleitor ret =null;
        connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from mydb.Eleitor  where nrEleitor = ?  ");
            s1.setInt(1, nrEleitor);
          

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {

                ret = new Eleitor(rs.getString(2), rs.getInt(1), rs.getInt(3), rs.getDate(5), rs.getString(4), rs.getInt(6));

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
public static HashSet<Eleicao> consEp(){
    HashSet<Eleicao> ret = new HashSet<Eleicao>();
     connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from mydb.Eleicao  where DataF <  CURRENT_DATE() ");
          

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {
                int aa = rs.getInt(4);
                String tipo;
             if( aa  == 0 ) tipo = "Assembleia"; else tipo = "Presidenciais";
            Eleicao a = new Eleicao(tipo ,rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(1));
              ret.add(a);

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
}
public static HashSet<Eleicao> consEa(){
    HashSet<Eleicao> ret = new HashSet<Eleicao>();
     connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from mydb.Eleicao  where DataI <  CURRENT_DATE() and DataF >  CURRENT_DATE() ");
          

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {
                int aa = rs.getInt(4);
                String tipo;
             if( aa  == 0 ) tipo = "Assembleia"; else tipo = "Presidenciais";
            Eleicao a = new Eleicao(tipo ,rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(1));
              ret.add(a);

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
}
public static HashSet<Eleicao> consEf(){
    HashSet<Eleicao> ret = new HashSet<Eleicao>();
     connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from mydb.Eleicao  where DataI >  CURRENT_DATE()");
          

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {
                int aa = rs.getInt(4);
                String tipo;
             if( aa  == 0 ) tipo = "Assembleia"; else tipo = "Presidenciais";
            Eleicao a = new Eleicao(tipo ,rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(1));
              ret.add(a);

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
}

public static HashSet<Eleicao> consEfA(){
    HashSet<Eleicao> ret = new HashSet<Eleicao>();
     connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from mydb.Eleicao  where DataI >  CURRENT_DATE() and tipo = 0 and estado = 0");
          

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {
                int aa = rs.getInt(4);
                String tipo;
             if( aa  == 0 ) tipo = "Assembleia"; else tipo = "Presidenciais";
            Eleicao a = new Eleicao(tipo ,rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(1));
              ret.add(a);

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
}
public static HashSet<Eleicao> consEfP(){
    HashSet<Eleicao> ret = new HashSet<Eleicao>();
     connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from mydb.Eleicao  where DataI >  CURRENT_DATE()and tipo = 1");
          

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {
                int aa = rs.getInt(4);
                String tipo;
             if( aa  == 0 ) tipo = "Assembleia"; else tipo = "Presidenciais";
            Eleicao a = new Eleicao(tipo ,rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(1));
              ret.add(a);

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
}
 public static Eleicao getEleicao(int codEleicao){
        Eleicao ret = null;
        connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select * from eleicao  where ideleicao = ?  ");
            s1.setInt(1, codEleicao);
            

            ResultSet rs = s1.executeQuery();;
            while (rs.next()) {
                 int aa = rs.getInt(4);
 String tipo;
             if( aa  == 0 ) tipo = "Autarquicas"; else tipo = "Presidenciais";
                 ret = new Eleicao(tipo ,rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(1));
              

            }
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    
}
 
 public static HashMap<Integer,String>getCandidatos(int codEleicao,String morada){
     HashMap<Integer,String> ret = new HashMap<Integer,String>();
               connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("Select Eleitor_nrEleitor, idListaEleitorais from mydb.Candidatos as A inner join mydb.listaeleitorais as B  On A.ListaEleitorais_idListaEleitorais= B.idListaEleitorais\n" +
"inner join mydb.circulo_eleitoral as C where C.sede =  ?  and C.Eleicao_idEleicao = ? and B.Circulo_Eleitoral_idCirculo_Eleitoral = C.idCirculo_Eleitoral and B.Aprovacao = true");
           
            s1.setString(1,morada);
            
            s1.setInt(2, codEleicao);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                Eleitor a = getEleitor(rs.getInt(1));
            
                 ret.put(rs.getInt(2),a.getNome());
              
            }
            
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             
             return ret;
             
 }

public static HashMap<Integer,String> getCporAprovar(int codEleicao){
     HashMap<Integer,String> ret = new HashMap<Integer,String>();
               connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("Select idListaEleitorais, sede from mydb.listaeleitorais as A inner join mydb.circulo_eleitoral as B on"
                    + " A.Circulo_Eleitoral_idCirculo_Eleitoral = B.idCirculo_Eleitoral  where B.Eleicao_idEleicao = ? and A.Aprovacao = false ");
            s1.setInt(1, codEleicao);
          

            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
               
            
                 ret.put(rs.getInt(1),rs.getString(2));
              
            }
            
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             
             return ret;
}

public static HashMap<Integer,String> detalhesCandidatura(int candidatura){
    HashMap<Integer,String> ret = new HashMap<Integer,String>();
    connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement(" Select Nome,nrEleitor from mydb.eleitor as A inner join mydb.Candidatos as B on A.nrEleitor =B.Eleitor_nrEleitor inner join mydb.listaeleitorais  as C on C.idListaEleitorais = B.ListaEleitorais_idListaEleitorais where C.idListaEleitorais = ?  ");
            s1.setInt(1, candidatura);
          

            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
               
            
                 ret.put(rs.getInt(2),rs.getString(1));
              
            }
            
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;
}



public static Partido getMembros(int nrEleitor){
    Partido ret = new Partido();
    Eleitor b = getEleitor(nrEleitor);
    connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement(" Select idPartido from mydb.partido as A inner join mydb.eleitor as B  on A.idPartido = B.PArtido_idPartido where B.nrEleitor = ?  ");
            s1.setInt(1, nrEleitor);
            
            ResultSet rs = s1.executeQuery();
            int a= 0;
            while(rs.next()) a = rs.getInt(1);
          if(a != 0){

            
             PreparedStatement s2 = c.prepareStatement(" select Nome,nrEleitor from mydb.eleitor where Partido_idPartido = ?");
             
            s2.setInt(1,a);
            
            ResultSet rs2 = s2.executeQuery();
            
            s1 = c.prepareStatement(" select Nome from mydb.partido where idPartido = ?");
            s1.setInt(1,a);
            ResultSet rs3 = s1.executeQuery();
            String auxx ;
             while(rs.next()) {auxx = rs3.getString(1); ret.setNomedopartido(auxx);}
            
            
            while (rs2.next()) {
              Eleitor x  = getEleitor(rs2.getInt(2));
             
                ret.addMembro(x);
                
               }
            }
            //addpresidente 
             PreparedStatement s3 = c.prepareStatement(" select nrEleitor from mydb.eleitor where Partido_idPartido = ? and cargo = 2");
             s3.setInt(1,a );
            ResultSet rs3 = s3.executeQuery();
           while (rs3.next()) { ret.setLider(rs3.getInt(1));}
            PreparedStatement s4 = c.prepareStatement(" select nrEleitor from mydb.eleitor where Partido_idPartido = ? and cargo = 5");
            s4.setInt(1,a );
            ResultSet rs4 = s4.executeQuery();
          while (rs4.next()) {  ret.setLider(rs4.getInt(1));}
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;
}




public static   HashMap<Integer,String> getCirculos(int codEleicao){
   HashMap<Integer,String> ret = new HashMap<Integer,String>();
    connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement(" Select idCirculo_Eleitoral,sede from mydb.circulo_eleitoral where Eleicao_idEleicao = ?  ");
            s1.setInt(1, codEleicao);
          

            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
               
            
                 ret.put(rs.getInt(1),rs.getString(2));
              
            }
            
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;
}


public static int aprovacandidatura(int codCandidatura){
    connect();
        try {
            c.setAutoCommit(true);

           c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 = c.prepareStatement("  update  mydb.listaeleitorais set Aprovacao = true where idlistaeleitorais = ?  ");
            s1.setInt(1, codCandidatura);
          

           s1.executeUpdate();
           
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
}


public static int rejeitacandidatura(int codCandidatura){
      connect();
        try {
            c.setAutoCommit(true);

           c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 = c.prepareStatement(" delete from mydb.listaeleitorais where idlistaeleitorais = ?  ");
            s1.setInt(1, codCandidatura);
          

           s1.executeUpdate();
           
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
}

public static int removeEl(int nrEleitor){
    connect();
        try {
            c.setAutoCommit(true);

           c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
           PreparedStatement s1 = c.prepareStatement("  update  mydb.eleitor set Partido = 0 where nrEleitor = ?  ");
            s1.setInt(1, nrEleitor);
          

            s1.executeUpdate();
           
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
}
public static int addEl(int nrEleitor,String nome, Date date,String morada, int nrBI, int nrEleitorP){
    connect();
        try {
            c.setAutoCommit(true);
             c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
   PreparedStatement s = c.prepareStatement("Select PArtido_idPartido from mydb.eleitor where nrEleitor = ? ");
   s.setInt(1,nrEleitorP);
   ResultSet r = s.executeQuery();
   int partido = r.getInt(1);
          
           PreparedStatement s1 = c.prepareStatement("  INSERT INTO mydb.eleitor (nrELeitor, Nome,nrBi,Morada,DataNascimento,Cargo,password,partido)\n" +
"VALUES (?,\"?\",?,\"?\",?,?,\"?\");  ");
            s1.setInt(1, nrEleitor);
            s1.setString(2, nome);
            s1.setInt(3,nrBI);
            s1.setString(4, morada);
             java.sql.Date datea = new java.sql.Date(date.getTime());
            s1.setDate(5,  datea);
            s1.setInt(6,1);
            s1.setInt(7, nrEleitor);
            s1.setInt(8,partido);
            
          

            s1.executeUpdate();
           
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
}

public static int voto( int idLista,int nrEleitor ) {
    connect();
        try {
            c.setAutoCommit(true);

           c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
           PreparedStatement s1 = c.prepareStatement("  INSERT INTO mydb.votos(Eleitor_nrEleitor,Lista_idListaEleitorais) VALUES (?,?)  ");
            s1.setInt(1, nrEleitor);
            s1.setInt(2,idLista);
          

           s1.executeUpdate();
           
            
            
            return 1;
        } catch (SQLException ex) {
            
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
}
public static int alterLider(int nrEleitor, int nrEleitorP){
     connect();
        try {
            c.setAutoCommit(true);

            c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 = c.prepareStatement(" update mydb.eleitor set Cargo = 5 where nrEleitor = ?  ");
            s1.setInt(1, nrEleitor);
            PreparedStatement s2 = c.prepareStatement("select Partido_idPartido from mydb.eleitor where nrEleitor = ? ");
            s2.setInt(1, nrEleitorP);
            ResultSet r1 = s2.executeQuery();
            PreparedStatement s3 = c.prepareStatement("select nrEleitor from mydb.eleitor where cargo = 2 and Partido_idPartido = ? ");
           while (r1.next()) { s3.setInt(1, r1.getInt(1));}
            ResultSet r2 = s3.executeQuery();
            PreparedStatement s4 = c.prepareStatement(" update mydb.eleitor set Cargo = 1 where nrEleitor = ? ");
           while (r2.next()) { s4.setInt(1, r2.getInt(1));}
            PreparedStatement s5 = c.prepareStatement("    update mydb.eleitor set Cargo = 2  where nrEleitor = ?");
            s5.setInt(1, nrEleitorP);
            s1.executeUpdate();
            s4.executeUpdate();
            s5.executeUpdate();
       
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
}

public static int mandaCandidatura(int nrEleitor,int codEleicao){
    
        connect();
        try {
            c.setAutoCommit(true);
            int circA;
            int listaC;
            c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 = c.prepareStatement(" select idCirculo_Eleitoral from mydb.circulo_eleitoral where Eleicao_idEleicao = ? ");
            s1.setInt(1, codEleicao);
            PreparedStatement s2 = c.prepareStatement("insert into mydb.listaeleitorais(Aprovacao,Circulo_Eleitoral_idCirculo_Eleitoral)	values(0,?)",Statement.RETURN_GENERATED_KEYS);
           
            PreparedStatement s3 = c.prepareStatement("insert into mydb.candidatos (ListaEleitorais_idListaEleitorais,Eleitor_nrEleitor) values(?,?)");
            s3.setInt(2,nrEleitor);
            
            ResultSet r1 = s1.executeQuery();
            while(r1.next()){
                circA = r1.getInt(1);
                s2.setInt(1, circA);
               s2.executeUpdate( );
              ResultSet keys = s2.getGeneratedKeys();
            if (keys.next()) {
               listaC = keys.getInt(1);
               s3.setInt(1,listaC);
               s3.executeUpdate();
            }
                
            
            
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
}
    

public static int mandaLista(int codEleicao , int codCirculo , HashSet<Integer> membros ) {
       connect();
        try {
            c.setAutoCommit(true);
           int listaC;
            c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 =  c.prepareStatement("insert into mydb.listaeleitorais(Aprovacao,Circulo_Eleitoral_idCirculo_Eleitoral)	values(0,?)",Statement.RETURN_GENERATED_KEYS);
          s1.setInt(1,codCirculo);
          s1.executeUpdate();
                  ResultSet keys = s1.getGeneratedKeys();
            if (keys.next()) {
               listaC = keys.getInt(1);
              for(Integer a :membros){
            PreparedStatement s2 = c.prepareStatement("insert into mydb.candidatos (ListaEleitorais_idListaEleitorais,Eleitor_nrEleitor) values(?,?)");
            s2.setInt(listaC,a);
            
        }
            }
            
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
    
    
}



 public static HashMap<String,Integer> Consulta(int codEleicao){
     
     HashMap<String,Integer> ret = new HashMap<String,Integer>();
     
    connect();
        try {
            c.setAutoCommit(false);
int aux2 ;
            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement(" select idListaEleitorais from mydb.listaeleitorais as A inner join mydb.circulo_eleitoral as B on A.Circulo_Eleitoral_idCirculo_Eleitoral = B.idCirculo_Eleitoral where B.Eleicao_idEleicao = ?  ");
             s1.setInt(1,codEleicao);
          

            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
              
            PreparedStatement s2 = c.prepareStatement(" select count(*) from mydb.votos where Lista_idListaEleitorais = ?");
             PreparedStatement s3 = c.prepareStatement(" select idCandidatos from mydb.candidatos where ListaEleitorais_idListaEleitorais = ?");
             
            s2.setInt(1,rs.getInt(1));
              ResultSet r2 = s2.executeQuery();
                 ResultSet r3 = s3.executeQuery();
              while(r2.next()){aux2 = r2.getInt(1);
                  while(r3.next()){
                      
                  
                  
                      HashMap<Integer,String> aux = detalhesCandidatura(r3.getInt(1));
                      
                      for(Integer a : aux.keySet() ){
                          ret.put(aux.get(a), aux2);
                      }
                  }
                  }
              
            }
            
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;
     
 }
 
 public static int comecaEleicao(Date dataii, Date dataff,HashSet<String> circulos,int tipo ){
         java.sql.Date datai = new java.sql.Date(dataii.getTime());
        java.sql.Date dataf = new java.sql.Date(dataff.getTime());
      connect();
        try {
            c.setAutoCommit(true);
          int eleicaoC;
            c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 =  c.prepareStatement("INSERT INTO mydb.eleicao (DataI, DataF,tipo,estado) VALUES (?,?,?,0); ",Statement.RETURN_GENERATED_KEYS);
            s1.setDate(1, datai);
            s1.setDate(2,dataf);
            s1.setInt(3, tipo);
         s1.executeUpdate();
         
             ResultSet keys = s1.getGeneratedKeys();
            if (keys.next()) {
                 eleicaoC = keys.getInt(1);
                 for(String a : circulos){
                
                PreparedStatement s2 = c.prepareStatement("INSERT INTO mydb.circulo_eleitoral(Eleicao_idEleicao,sede) VALUES (?,?)");
                s2.setInt(1, eleicaoC);
                s2.setString(2,a);
                s2.executeUpdate();
            }
            }
        
            
            
            
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
     
 }
 
 
 public static int  acabarEleicao(int codEleicao){
      connect();
        try {
            c.setAutoCommit(true);

           c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement s1 = c.prepareStatement("  update  mydb.listaeleitorais set estado = 1 where idlistaeleitorais = ?  ");
            s1.setInt(1, codEleicao);
          

           s1.executeUpdate();
           
            
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
     
     
     
 }
 
 public static HashMap<Integer,Boolean> estadoC(int nrEleitor){
        HashMap<Integer,Boolean> ret = new HashMap<Integer,Boolean>();
    connect();
        try {
            c.setAutoCommit(false);

            c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement s1 = c.prepareStatement("select idListaEleitorais,Aprovacao from mydb.listaeleitorais as A inner join mydb.candidatos as B on A.idListaEleitorais= B.ListaEleitorais_idListaEleitorais where B.Eleitor_nrEleitor = ?  ");
            s1.setInt(1, nrEleitor);
          

            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
               
            
                 ret.put(rs.getInt(1),rs.getBoolean(2));
              
            }
            
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FacadeD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;
     
 }
  /*  
    select idCirculo_Eleitoral from mydb.circulo_eleitoral where Eleicao_idEleicao = 2;

insert into mydb.listaeleitorais(Aprovacao,Circulo_Eleitoral_idCirculo_Eleitoral)
	values(0,1);
    
insert into mydb.candidatos (ListaEleitorais_idListaEleitorais,Eleitor_nrEleitor)
 values(x,y);
//para todos os circulodas da eleiçao, criar uma lista com o eleitor 
    ResultSet keys = s1.getGeneratedKeys()) {
            if (keys.next()) {
               
            }*/
    

}

