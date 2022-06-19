package modelo.DAO;


import controlador.CFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Funcionario;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class DAOFuncionario {

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
    
    private String validar(Funcionario funcionario){
        
        String resposta = ""; 
        if(funcionario.getNome().equals("") || funcionario.getCpf().equals("   .   .   -  ") || funcionario.getEndereco().equals("")
            || funcionario.getCidade().equals("") || funcionario.getUf().equals("") || funcionario.getCargo().equals("") ||
            funcionario.getSalario().equals("") ||  funcionario.getDataContratacao() == null){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
        if (!(funcionario.getCargo().equals("Recepcionista") || (funcionario.getCargo().equals("Personal")
                || funcionario.getCargo().equals("Faxineira")))){
            resposta = "Digite apenas Recepcionista - Personal - Faxineira em cargo.";
            return resposta;
        }
        
        return "";
        }
    
    public boolean insereFuncionario(Funcionario funcionario){
        
        conectar();
        String retornaResposta = validar(funcionario);
        
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO FUNCIONARIO(nome, cpf, endereco, cidade, uf, cargo, dataContratacao, salario) VALUES (?,?,?,?,?,?,?,?)";
        
        Date auxDataContratacao = new Date();
            auxDataContratacao = funcionario.getDataContratacao();
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getEndereco());
            comando.setString(4, funcionario.getCidade());
            comando.setString(5, funcionario.getUf());
            comando.setString(6, funcionario.getCargo());
            comando.setDate(7, CFuncionario.converteDateSQL(funcionario.getDataContratacao()));
            comando.setString(8, funcionario.getSalario());
            
 
            comando.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir funcionário.\n"+e.getMessage());
        }finally{
            fechar();
        }
        
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false;
    }
    
    
 public  ArrayList<Funcionario> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM FUNCIONARIO";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Funcionario> listaFuncionario = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setCidade(rs.getString("CIDADE"));        
                funcionario.setUf(rs.getString("UF"));
                funcionario.setCargo(rs.getString("CARGO"));
                funcionario.setDataContratacao(rs.getDate("DATACONTRATACAO"));
                funcionario.setSalario(rs.getString("SALARIO"));
                

                listaFuncionario.add(funcionario);
            }
            return listaFuncionario;
        }
        catch(SQLException e)
        {
            System.err.println("Erro visualizar funcionários.\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
    public boolean alteraFuncionario(Funcionario funcionario){
        conectar();
        String retornaResposta = validar(funcionario);
    
        java.sql.Date sqlDataContratacao = new java.sql.Date(funcionario.getDataContratacao().getTime());
        
        if(retornaResposta.equals("")){
        String sql = "UPDATE FUNCIONARIO SET NOME = ?, CPF = ?, ENDERECO = ?, CIDADE = ?, "
               + "UF = ?, CARGO = ?, DATACONTRATACAO = ?, SALARIO = ?" + "WHERE CPF = ?";
        
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, funcionario.getNome());
          comando.setString(2, funcionario.getCpf());
          comando.setString(3, funcionario.getEndereco());
          comando.setString(4, funcionario.getCidade());
          comando.setString(5, funcionario.getUf());
          comando.setString(6, funcionario.getCargo());
          comando.setDate(7, CFuncionario.converteDateSQL(funcionario.getDataContratacao()));
          comando.setString(8, funcionario.getSalario());
          comando.setString(9, funcionario.getCpf());
          
          
          //utiliza executeUpdate() para operações que irão modificar a base da dados
          comando.executeUpdate();
          
          return true;
          
        }catch(SQLException e){
            System.err.println("Erro ao atualizar funcionário.\n"+e.getMessage());
        }finally{
            fechar();
        }
        
        }else {
            JOptionPane.showMessageDialog(null, retornaResposta);
        }     
       return false;
    }
    
    public boolean removeFuncionario(String cpf){
        conectar();
        String sql = "DELETE FROM FUNCIONARIO WHERE CPF=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar funcionário.\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    } 
    
}
