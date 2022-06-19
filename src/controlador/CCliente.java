package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DAO.DAOCliente;
import modelo.dominio.Cliente;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class CCliente {
    
    public boolean cadastrarCliente(Cliente cliente)
    {
        DAOCliente insereDados = new DAOCliente();
        if(insereDados.insereCliente(cliente))
        {
            return true;
        }
        return false;

    }
    
    public ArrayList<Cliente> visualizarClientes ()
    {
        DAOCliente dadosCliente = new DAOCliente();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes = dadosCliente.selecionarTodosRegistros();
        
        return listaClientes;

    }
    
    public boolean atualizarCliente(Cliente cliente)
    {
        DAOCliente dadosCliente = new DAOCliente();
        if(dadosCliente.alteraCliente(cliente))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarCliente(String cpf)
    {
        DAOCliente dadosCliente = new DAOCliente();
        if(dadosCliente.removeCliente(cpf))
        {
            return true;
        }
        
        return false;
    }
    
}
