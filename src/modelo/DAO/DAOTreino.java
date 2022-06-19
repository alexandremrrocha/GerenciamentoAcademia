package modelo.DAO;

import controlador.CTreino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Treino;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class DAOTreino {

    //Classe responsável pela conexão (sessão) com um banco de dados específico. 
    //As instruções SQL são executadas e os resultados são retornados dentro do contexto de uma conexão.
     private Connection con;
     
     //Pre-compila a query para o banco de dados
    // Cria um objeto PreparedStatement para enviar instruções SQL parametrizadas para o banco de dados.
    //Uma instrução SQL com ou sem parâmetros IN pode ser pré-compilada e armazenada em um objeto PreparedStatement.
    //Esse objeto pode ser usado para executar essa instrução de forma eficiente várias vezes. 
    private PreparedStatement comando;
    
    private final FabricaConexao fConexao = FabricaConexao.getInstancia();
    
    private void conectar()
    {
        con = fConexao.conexao();
    }
    
    private void fechar(){
        try{
            comando.close();
            con.close();
        }catch(SQLException e){
            System.err.println("Erro ao fechar conexão\n"+e.getMessage());
        }
    }
    
    private String validar(Treino treino){
        
        String resposta = ""; 
        if(treino.getNomeCliente().equals("") || treino.getNomePersonal().equals("") || treino.getNumeroTreino().equals("") ||
           treino.getDataTreino()== null || treino.getPreTreino().equals("") || treino.getTempoPre().equals("") || 
           treino.getPosTreino().equals("") || treino.getTempoPos().equals("") || treino.getGrupoMuscular().equals("")
           || treino.getSerie().equals("") || treino.getRepeticao().equals("") || treino.getIntervalo().equals("")
           || treino.getHoraInicio().equals("  :  ") || treino.getHoraFim().equals("  :  ")){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
        if(!(treino.getIntervalo().equals("1") || treino.getIntervalo().equals("2"))){
            resposta= "O intervalo é somente de 1 ou 2 minutos";
            return resposta;
        }
        
        return "";
    }
    
    public boolean insereTreino(Treino treino){
        
        conectar();
        String retornaResposta = validar(treino);
        
        Date auxDataTreino = new Date();
            auxDataTreino = treino.getDataTreino();
            
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO TREINO(nomeCliente, nomePersonal, numeroTreino, dataTreino, preTreino, tempoPre, posTreino, tempoPos, grupoMuscular, serie, repeticao, intervalo, horaInicio, horaFim) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, treino.getNomeCliente());
            comando.setString(2, treino.getNomePersonal());
            comando.setString(3, treino.getNumeroTreino());
            comando.setDate(4, CTreino.converteDateSQL(treino.getDataTreino()));
            comando.setString(5, treino.getPreTreino());
            comando.setString(6, treino.getTempoPre());
            comando.setString(7, treino.getPosTreino());
            comando.setString(8, treino.getTempoPos());
            comando.setString(9, treino.getGrupoMuscular());
            comando.setString(10, treino.getSerie());
            comando.setString(11, treino.getRepeticao());
            comando.setString(12, treino.getIntervalo());
            comando.setString(13, treino.getHoraInicio());  
            comando.setString(14, treino.getHoraFim());
            comando.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir treino.\n"+e.getMessage());
        }finally{
            fechar();
        }
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }      
        return false;
    }
    
    
 public  ArrayList<Treino> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM TREINO";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Treino> listaTreino = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Treino treino = new Treino();
                treino.setNomeCliente(rs.getString("NOMECLIENTE"));
                treino.setNomePersonal(rs.getString("NOMEPERSONAL"));
                treino.setNumeroTreino(rs.getString("NUMEROTREINO"));
                treino.setDataTreino(rs.getDate("DATATREINO"));
                treino.setPreTreino(rs.getString("PRETREINO"));
                treino.setTempoPre(rs.getString("TEMPOPRE"));
                treino.setPosTreino(rs.getString("POSTREINO"));
                treino.setTempoPos(rs.getString("TEMPOPOS"));
                treino.setGrupoMuscular(rs.getString("GRUPOMUSCULAR"));
                treino.setSerie(rs.getString("SERIE"));
                treino.setRepeticao(rs.getString("REPETICAO"));
                treino.setIntervalo(rs.getString("INTERVALO"));
                treino.setHoraInicio(rs.getString("HORAINICIO"));
                treino.setHoraFim(rs.getString("HORAFIM"));

                listaTreino.add(treino);
            }
            return listaTreino;
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao visualizar treino\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
 public boolean alteraTreino(Treino treino)
    {
        conectar();
        String retornaResposta = validar(treino);
        
        java.sql.Date sqlDataTreino = new java.sql.Date(treino.getDataTreino().getTime());
        
        if(retornaResposta.equals("")){
            String sql = "UPDATE TREINO SET NOMECLIENTE = ?, NOMEPERSONAL = ?, NUMEROTREINO = ?, DATATREINO = ?, PRETREINO = ?, TEMPOPRE = ?, POSTREINO = ?, TEMPOPOS = ?, GRUPOMUSCULAR = ?, SERIE = ?, REPETICAO = ?, INTERVALO = ?, HORAINICIO = ?, HORAFIM = ?" + "WHERE NUMEROTREINO = ?";
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, treino.getNomeCliente());
            comando.setString(2, treino.getNomePersonal());
            comando.setString(3, treino.getNumeroTreino());
            comando.setDate(4, CTreino.converteDateSQL(treino.getDataTreino()));
            comando.setString(5, treino.getPreTreino());
            comando.setString(6, treino.getTempoPre());
            comando.setString(7, treino.getPosTreino());
            comando.setString(8, treino.getTempoPos());
            comando.setString(9, treino.getGrupoMuscular());
            comando.setString(10, treino.getSerie());
            comando.setString(11, treino.getRepeticao());
            comando.setString(12, treino.getIntervalo());
            comando.setString(13, treino.getHoraInicio());  
            comando.setString(14, treino.getHoraFim());
            comando.setString(15, treino.getNumeroTreino());
          
          //utiliza executeUpdate() para operações que irão modificar a base da dados
         comando.executeUpdate();
          
          return true;
          
      }catch(SQLException e){
          System.err.println("Erro ao atualizar treino.\n"+e.getMessage());
      }finally{
          fechar();
      }
       }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }  
       return false;
  }
    
   public boolean removeTreino(String numeroTreino){
        conectar();
        String sql = "DELETE FROM TREINO WHERE NUMEROTREINO=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, numeroTreino);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar treino.\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    } 

   
    
}
