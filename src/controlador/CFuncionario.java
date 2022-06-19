package controlador;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAO.DAOFuncionario;
import modelo.dominio.Funcionario;
/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class CFuncionario {

   
    
     public boolean cadastrarFuncionario(Funcionario funcionario)
    {
        DAOFuncionario insereDados = new DAOFuncionario();
        if(insereDados.insereFuncionario(funcionario))
        {
            return true;
        }
        return false;

    }
     public ArrayList<Funcionario> visualizarFuncionario ()
    {
        DAOFuncionario dadosFuncionario = new DAOFuncionario();
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        listaFuncionario = dadosFuncionario.selecionarTodosRegistros();
        
        return listaFuncionario;

    }
    
    public boolean atualizarFuncionario(Funcionario funcionario)
    {
        DAOFuncionario dadosFuncionario = new DAOFuncionario();
        if(dadosFuncionario.alteraFuncionario(funcionario))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarFuncionario(String cpf)
    {
        DAOFuncionario dadosFuncionario = new DAOFuncionario();
        if(dadosFuncionario.removeFuncionario(cpf))
        {
            return true;
        }
        
        return false;
    }
    
    public static Date converteStringDate(String data) 
    {
        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        Date novaData = null;
        try {
            novaData = formatado.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(CFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaData;
    }
    
    public static java.sql.Date converteDateSQL (Date data)
    {
        return new java.sql.Date(data.getTime());
    }
    
    public static String converteDataString (Date data)
    {
        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        String auxData = formatado.format(data);
        return auxData;
    }
}
