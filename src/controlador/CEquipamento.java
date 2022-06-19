package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAO.DAOEquipamento;
import modelo.dominio.Equipamento;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class CEquipamento {
    
    public boolean cadastrarEquipamento(Equipamento equipamento)
    {
        DAOEquipamento insereDados = new DAOEquipamento();
        if(insereDados.insereEquipamento(equipamento))
        {
            return true;
        }
        return false;

    }
    
    public ArrayList<Equipamento> visualizarEquipamento ()
    {
        DAOEquipamento dadosEquipamento = new DAOEquipamento();
        ArrayList<Equipamento> listaEquipamento = new ArrayList<Equipamento>();
        listaEquipamento = dadosEquipamento.selecionarTodosRegistros();
        
        return listaEquipamento;

    }
    
    public boolean atualizarEquipamento(Equipamento equipamento)
    {
        DAOEquipamento dadosEquipamento = new DAOEquipamento();
        if(dadosEquipamento.alteraEquipamento(equipamento))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarEquipamento(String codigo)
    {
        DAOEquipamento dadosEquipamento = new DAOEquipamento();
        if(dadosEquipamento.removeEquipamento(codigo))
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
            Logger.getLogger(CEquipamento.class.getName()).log(Level.SEVERE, null, ex);
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
