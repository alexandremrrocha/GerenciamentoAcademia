package modelo.DAO;

import controlador.CEquipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Equipamento;


/**
 *
 * @author Alexandre Rocha e Raquel
 */ 
public class DAOEquipamento {
    
    //Classe responsável pela conexão (sessão) com um banco de dados específico. 
    //As instruções SQL são executadas e os resultados são retornados dentro do contexto de uma conexão.
     private Connection con;
     
    //Pre-compila a query para o banco de dados
    // Cria um objeto PreparedStatement para enviar instruções SQL parametrizadas para o banco de dados.
    //Uma instrução SQL com ou sem parâmetros IN pode ser pré-compilada e armazenada em um objeto PreparedStatement.
    //Esse objeto pode ser usado para executar essa instrução de forma eficiente várias vezes. 
    private PreparedStatement comando;
    
    private final FabricaConexao fConexao = FabricaConexao.getInstancia();
    
    // Método acessado internamente para conectar com o banco
    private void conectar()
    {
        con = fConexao.conexao();
    }
    
    //Método que fecha a conexão com o banco
    private void fechar(){
        try{
            comando.close();
            con.close();
        }catch(SQLException e){
            System.err.println("Erro ao fechar conexão\n"+e.getMessage());
        }
    }
    
    private String validar(Equipamento equipamento){
        
        String resposta = ""; 
        if(equipamento.getCodigo().equals("") || equipamento.getNome().equals("") || equipamento.getFornecedor().equals("") ||
           equipamento.getQuantidade().equals("") || equipamento.getValor().equals("") || equipamento.getLimitePeso().equals("") ||
           equipamento.getDataCompra()== null){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
      if (!(equipamento.getFornecedor().equals("Leal Fitness") || (equipamento.getFornecedor().equals("ErgoLife")) || 
              (equipamento.getFornecedor().equals("Profitness")))){
            resposta = "Fornecedores são somente: Leal Fitness, ErgoLife e Profitness.";
           return resposta;
       }
        
        return "";
    }
    
    
    public boolean insereEquipamento(Equipamento equipamento){
        
        conectar();
        String retornaResposta = validar(equipamento);
        
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO EQUIPAMENTO(codigo, nome, fornecedor, dataCompra, quantidade, valor, limitePeso) VALUES (?,?,?,?,?,?,?)";
        
        Date auxDataCompra = new Date();
            auxDataCompra = equipamento.getDataCompra();
           
        java.sql.Date sqlDataCompra = new java.sql.Date(auxDataCompra.getTime());
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, equipamento.getCodigo());
            comando.setString(2, equipamento.getNome());
            comando.setString(3, equipamento.getFornecedor());
            comando.setDate(4, CEquipamento.converteDateSQL(equipamento.getDataCompra()));
            comando.setString(5, equipamento.getQuantidade());
            comando.setString(6, equipamento.getValor());
            comando.setString(7, equipamento.getLimitePeso());
            comando.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir equipamento.\n"+e.getMessage());
        }finally{
            fechar();
        }
        
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false; 
    }
    
     public  ArrayList<Equipamento> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM EQUIPAMENTO";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Equipamento> listaEquipamento = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Equipamento equipamento = new Equipamento();
                equipamento.setCodigo(rs.getString("CODIGO"));
                equipamento.setNome(rs.getString("NOME"));
                equipamento.setFornecedor(rs.getString("FORNECEDOR"));
                equipamento.setDataCompra(rs.getDate("DATACOMPRA"));
                equipamento.setQuantidade(rs.getString("QUANTIDADE"));
                equipamento.setValor(rs.getString("VALOR"));
                equipamento.setLimitePeso(rs.getString("LIMITEPESO"));

                listaEquipamento.add(equipamento);
            }
            return listaEquipamento;
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao visualizar equipamentos.\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
     
    public boolean alteraEquipamento(Equipamento equipamento)
    {
        conectar();
        String retornaResposta = validar(equipamento);
        
        java.sql.Date sqlDataCompra = new java.sql.Date(equipamento.getDataCompra().getTime());
      
        if(retornaResposta.equals("")){
        String sql = "UPDATE EQUIPAMENTO SET CODIGO = ?, NOME = ?, FORNECEDOR = ?, DATACOMPRA = ?, QUANTIDADE = ?, VALOR = ?, LIMITEPESO = ?" 
               + "WHERE CODIGO = ?";
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, equipamento.getCodigo());
          comando.setString(2, equipamento.getNome());
          comando.setString(3, equipamento.getFornecedor());
          comando.setDate(4, CEquipamento.converteDateSQL(equipamento.getDataCompra()));
          comando.setString(5, equipamento.getQuantidade());
          comando.setString(6, equipamento.getValor());
          comando.setString(7, equipamento.getLimitePeso());
          comando.setString(8, equipamento.getCodigo());
          
          //utiliza executeUpdate() para operações que irão modificar a base da dados
         comando.executeUpdate();
          
          return true;
          
        }catch(SQLException e){
            System.err.println("Erro ao atualizar equipamento.\n"+e.getMessage());
        }finally{
            fechar();
        }
        }else {
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false;
  }
    
   public boolean removeEquipamento(String codigo){
        conectar();
        String sql = "DELETE FROM EQUIPAMENTO WHERE CODIGO=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, codigo);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar equipamento.\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    } 
}
