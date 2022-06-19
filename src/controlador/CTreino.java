package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAO.DAOTreino;
import modelo.dominio.Treino;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class CTreino {
   
    public boolean cadastrarAgendamento(Treino treino)
    {
        DAOTreino insereDados = new DAOTreino();
        if(insereDados.insereTreino(treino))
        {
            return true;
        }
        return false;

    }
     public ArrayList<Treino> visualizarTreino ()
    {
        DAOTreino dadosTreino = new DAOTreino();
        ArrayList<Treino> listaTreino = new ArrayList<Treino>();
        listaTreino = dadosTreino.selecionarTodosRegistros();
        
        return listaTreino;

    }
    
    public boolean atualizarTreino(Treino treino)
    {
        DAOTreino dadosTreino = new DAOTreino();
        if(dadosTreino.alteraTreino(treino))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarTreino(String nomeTreino)
    {
        DAOTreino dadosTreino = new DAOTreino();
        if(dadosTreino.removeTreino(nomeTreino))
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
            Logger.getLogger(CTreino.class.getName()).log(Level.SEVERE, null, ex);
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
