/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import java.sql.SQLException;
import java.util.List;
import negocio.Medico;
import negocio.iRepositorioMedico;
import persistencia.RepositorioMedico;

/**
 *
 * @author lukas
 */
public class RegraMedico {
     iRepositorioMedico medico = new RepositorioMedico();
    
    public List getLista() throws SQLException{
        return medico.getLista();        
    }
    
    public boolean removerMedico(Medico m) throws SQLException{
        return medico.removerMedico(m);
    }
    
    public boolean salvarMedico(Medico m) throws SQLException{
        return medico.salvarMedico(m);
    }
}
