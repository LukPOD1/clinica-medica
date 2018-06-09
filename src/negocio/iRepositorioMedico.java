/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lukas
 */
public interface iRepositorioMedico {
    public List<Medico> getLista() throws SQLException;
    public boolean cadastrarMedico(Medico medico) throws SQLException;
    public boolean removerMedico(Medico medico) throws SQLException;
    public boolean editarMedico(Medico medico) throws SQLException;
    public boolean salvarMedico(Medico medico) throws SQLException;
}
