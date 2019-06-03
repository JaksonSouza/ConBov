package dao;

import connection.connection;
import entity.animal;
import entity.filhote;
import entity.historico;
import entity.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakson
 */

public class dao {
    private final Connection connection;
    public dao(){ 
        this.connection = new connection().getConnection();
    } 
    
     public usuario getUser(usuario usuario) throws SQLException{ 
        String sql = "select login, senha, nome from pecuarista;";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
         while (result.next()){
             
             if(usuario.getUsuario().equals(result.getString(1)) && usuario.getSenha().equals(result.getString(2))){
                 usuario.setLogin(Boolean.TRUE);
                 usuario.setNome(result.getString(3));
                 break;
             }
         }
         return usuario;
    }
    public void setUser(usuario usuario){ 
        String sql = "insert into pecuarista(nome,login,senha) values(?,?,?);";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getUsuario());
                stmt.setString(3, usuario.getSenha());
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
    
    public void setAnimal(animal animal){ 
        String sql = "insert into animal(numero,brinco,raca,sexo,idade,peso,lote) values(?,?,?,?,?,?,?);";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, animal.getNumero());
                stmt.setInt(2, animal.getBrinco());
                stmt.setString(3, animal.getRaca());
                stmt.setString(4, animal.getSexo());
                stmt.setInt(5, animal.getIdade());
                stmt.setFloat(6, animal.getPeso());
                stmt.setInt(7, animal.getLote());
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
    
    public List<animal> imprimirAnimal(String x, String y) throws SQLException{ 
        String sql="";
       
        if(x.equals("")){
            sql = "select id_animal,numero,brinco,raca,sexo,idade,peso,lote,status from animal;";
        }else{
            sql = "select id_animal,numero,brinco,raca,sexo,idade,peso,lote,status from animal where '"+x+"' = "+y+";";
        }
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
        List<animal> array = new ArrayList<animal>();
        
        while (result.next()){
             
             animal animal = new animal();
            
             animal.setIdAnimal(Integer.parseInt(result.getString(1)));
             animal.setNumero(Integer.parseInt(result.getString(2)));
             animal.setBrinco(Integer.parseInt(result.getString(3)));
             animal.setRaca(result.getString(4));
             animal.setSexo(result.getString(5));
             animal.setIdade(Integer.parseInt(result.getString(6)));
             animal.setPeso(Integer.parseInt(result.getString(7)));
             animal.setLote(Integer.parseInt(result.getString(8)));
             animal.setStatus(result.getString(9));
  
             array.add(animal);
        }
        return array;  
    }
    
     public void setHistorico(historico historico, Integer id){ 
        String sql = "insert into historico(id_animal,numero_pai,numero_mae,vacinado) values("+id+",?,?,?);";
       
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, historico.getNumeroPai());
                stmt.setInt(2, historico.getNumeroMae());
                stmt.setString(3, historico.getVacinado());
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
     
     public void updateAnimal(animal animal, Integer id){
         String sql = "UPDATE animal SET numero=?, brinco=?, raca=?, sexo=?,idade=?,peso=?,lote=?,status=? WHERE id_animal=?";
 
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, animal.getNumero());
                stmt.setInt(2, animal.getBrinco());
                stmt.setString(3, animal.getRaca());
                stmt.setString(4, animal.getSexo());
                stmt.setInt(5, animal.getIdade());
                stmt.setFloat(6, animal.getPeso());
                stmt.setInt(7, animal.getLote());
                stmt.setString(8, animal.getStatus());
                
                stmt.setInt(9,id);
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
     
     public void deleteAnimal(Integer id){
          String sql = "DELETE FROM animal WHERE id_animal=?";
 
          try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, id);
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
     }
       public Integer getId(Integer numero) throws SQLException{ 
        String sql = "select * from animal where numero="+numero+";";
        Integer idAnimal=null;
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
         while (result.next()){
             idAnimal=(Integer.parseInt(result.getString(1)));
             
         }
         return idAnimal;
    }
       
     public void deleteHistorico(Integer id){
          String sql = "DELETE FROM historico WHERE id_animal=?";
 
          try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, id);
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
     }
     
      public List<historico> getHistorico(Integer id) throws SQLException{ 
        String sql="select id_animal,numero_pai,numero_mae,vacinado from historico where id_animal="+id+";";
       
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
        List<historico> array = new ArrayList<historico>();
        
        while (result.next()){
             
             historico historico = new historico();
             
             historico.setIdAnimal(Integer.parseInt(result.getString(1)));
             historico.setNumeroPai(Integer.parseInt(result.getString(2)));
             historico.setNumeroMae(Integer.parseInt(result.getString(3)));
             historico.setVacinado(result.getString(4));
             
             array.add(historico);
        }
        return array;  
    }
    
    public void updateHistorico(historico historico, Integer id){
        String sql = "UPDATE historico SET numero_pai=?, numero_mae=?, vacinado=? where id_animal = ?";
 
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, historico.getNumeroPai());
                stmt.setInt(2, historico.getNumeroMae());
                stmt.setString(3, historico.getVacinado());

                stmt.setInt(4,id);
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
    
    public List<filhote> imprimirFilhote(Integer id) throws SQLException{ 
        String sql="select tatuagem,sexo,vacinado from filhote where id_animal = "+id+";";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
        List<filhote> array = new ArrayList<filhote>();
        
        while (result.next()){
             
             filhote filhote = new filhote();
            
             filhote.setTatuagem(Integer.parseInt(result.getString(1)));
             filhote.setSexo(result.getString(2));
             filhote.setVacinado(result.getString(3));
            
             array.add(filhote);
        }
        return array;  
    }
    
    public void setFilhote(filhote filhote, Integer id){ 
        String sql = "insert into filhote(id_animal,tatuagem,sexo,vacinado) values("+id+",?,?,?);";
       
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, filhote.getTatuagem());
                stmt.setString(2, filhote.getSexo());
                stmt.setString(3, filhote.getVacinado());
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
    
    public void deleteFilhote(Integer id){
          String sql = "DELETE FROM filhote  WHERE id_animal=?";
 
          try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, id);
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
     }
    
     public void updateFilhote(filhote filhote, Integer id){
        String sql = "UPDATE filhote SET tatuagem=?, sexo=?, vacinado=? where tatuagem = ?";
 
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                
                stmt.setInt(1, filhote.getTatuagem());
                stmt.setString(2, filhote.getSexo());
                stmt.setString(3, filhote.getVacinado());

                stmt.setInt(4,id);
               
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
     }
     
     public void deleteFilhoteTatu(Integer id){
          String sql = "DELETE FROM filhote  WHERE tatuagem=?";
 
          try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)){
                
                stmt.setInt(1, id);
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
     }
}