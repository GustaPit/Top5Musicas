package repository;

 import models.Musicss; 
 import config.DbConnection;

 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

public class MusicssRepository {    

    //criar um novo Musicss
    public void adicionarMusicss(Musicss Musicss){
            String sql = "INSERT INTO Musicsss (nome, idade, Musicas, Grammys, Vivo, Genero, Nacionalidade)  VALUES (?, ?, ?, ?, ?, ?, ?)";
             

            try (Connection conn = DbConnection.getConnection();
                PreparedStatement stmt= conn.prepareStatement(sql)) {

                    stmt.setString(1, Musicss.getNome());
                    stmt.setInt(2, Musicss.getidade());
                    stmt.setString(3, Musicss.getMusicas());
                    stmt.setInt(4, Musicss.getGrammys());
                    stmt.setString(5, Musicss.getVivo());
                    stmt.setString(6, Musicss.getGenero());
                    stmt.setString(7, Musicss.getNacionalidade());


                    int linhasAfetadas = stmt.executeUpdate();
                    if(linhasAfetadas > 0) {
                        System.out.println("Musicss adicionado com sucesso!");
                    }

                }catch (SQLException e){
                    System.out.println("Erro ao adicionar Musicss");
                    e.printStackTrace();
                }
            }

            // Obter todos os Musicsss
             public List<Musicss> obterTodosMusicsss(){
                List<Musicss> Musicsss  = new ArrayList<>();
                String sql=  "SELECT * FROM Musicsss";

                try (Connection conn = DbConnection.getConnection();
                 Statement stmt= conn.createStatement();
                 ResultSet rs =  stmt.executeQuery(sql)){

                    while (rs.next()){
                        Musicss Musicss  = new Musicss(
                           rs. getInt("id"), 
                           rs. getString("nome"), 
                           rs. getInt("Idade"), 
                           rs. getString("Musicas"),
                           rs. getInt("Grammys"),
                           rs. getString("Vivo"),
                           rs. getString("Genero"),
                           rs. getString("Nacionalidade")

                        );
                        Musicsss.add(Musicss);
                    }

                }catch (SQLException e) {
                    System.out.println("Erro ao obter Musicsss");
                    e.printStackTrace();
                }
                return Musicsss;
    }

        //obter Musicss por ID
        public Musicss obterMusicssPorId(int id) {
            String sql= "SELECT * FROM Musicsss  WHERE id = ?";
            Musicss Musicss = null;
        

        try (Connection conn = DbConnection.getConnection();
        PreparedStatement stmt= conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
                ResultSet rs =  stmt.executeQuery();

                if (rs.next()){
                    Musicss  = new Musicss(
                           rs. getInt("id"), 
                           rs. getString("nome"), 
                           rs. getInt("idade"), 
                           rs. getString("Musicas"),
                           rs. getInt("Grammys"),
                           rs. getString("Vivo"),
                           rs. getString("Genero"),
                           rs. getString("Nacionalidade")
                        );
                    }

                } catch (SQLException e) {
                    System.out.println("Erro ao obter Musicss por ID");
                    e.printStackTrace();
                }
                return Musicss;

            }
      
            //Atualizar  um Musicss

            public void AtualizarMusicss (Musicss  Musicss){
                String sql = 
                "UPDATE Musicsss SET nome= ? , email= ? , telefone= ?, WHERE id = ?";
               
                try (Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, Musicss.getNome());
                    stmt.setInt(2, Musicss.getidade());
                    stmt.setString(3, Musicss.getMusicas());
                    stmt.setInt(4, Musicss.getGrammys());
                    stmt.setString(5, Musicss.getVivo());
                    stmt.setString(6, Musicss.getGenero());
                    stmt.setString(7, Musicss.getNacionalidade());
                    stmt.setInt(8,Musicss.getId());
                   
                    int linhasAfetadas = stmt.executeUpdate();
                    if(linhasAfetadas > 0 ){
                        System.out.println("Musicss atualizado com sucesso!");
                    }else{
                        System.out.println("Musicss não encontrado.");
                    }

                } catch (SQLException e){
                    System.out.println("Erro ao atualizar Musicss");
                    e.printStackTrace();
                }
            }

            //deletar um Musicss
            public void deletarMusicss(int id){
                String sql = "DELETE FROM Musicsss WHERE id ?";

                try (Connection conn = DbConnection.getConnection();
                PreparedStatement stmt= conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                   
                    int linhasAfetadas = stmt.executeUpdate();
                    if(linhasAfetadas > 0 ) {
                        System.out.println("Musicss deletado com sucesso!");
                    }else {
                        System.out.println("Musicss não encontrado.");
                    }

                }catch (SQLException e) {
                    System.out.println("Erro ao deletar Musicss");
                    e.printStackTrace();
                }
            }
        }
        
        



    
 
