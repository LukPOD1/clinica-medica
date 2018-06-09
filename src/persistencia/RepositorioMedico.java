/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Medico;
import negocio.iRepositorioMedico;

/**
 *
 * @author lukas
 */
public class RepositorioMedico implements iRepositorioMedico{

    @Override
    public List<Medico> getLista() throws SQLException {
        String sql = "select * from medico";
        List<Medico> lista = new ArrayList<>();
        
        PreparedStatement pst = ConexaoBanco.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Medico obj = new Medico();
            obj.setId(rs.getInt("medicoId"));
            obj.setNome(rs.getString("medicoNome"));
            obj.setCrm(rs.getInt("medicoCRM"));
            obj.setEspecialidade(rs.getString("medicoEspecialidade"));
            obj.setEmail(rs.getString("medicoEmail"));
            obj.setTelefone(rs.getString("medicoTelefone"));
            lista.add(obj);
        }
        return lista;
    }

    @Override
    public boolean cadastrarMedico(Medico medico) throws SQLException {
        String sql = "insert into medico(medicoNome, medicoCRM, medicoEspecialidade, medicoEmail, medicoTelefone)"
                + "values(?,?,?,?,?)";
        PreparedStatement pst = ConexaoBanco.getPreparedStatement(sql);
        pst.setString(1, medico.getNome());
        pst.setInt(2, medico.getCrm());
        pst.setString(3, medico.getEspecialidade());
        pst.setString(4, medico.getEmail());
        pst.setString(5, medico.getTelefone());
        if (pst.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removerMedico(Medico medico) throws SQLException {
        String sql = "delete from medico where medicoId = ?";
        PreparedStatement pst = ConexaoBanco.getPreparedStatement(sql);
        pst.setInt(1, medico.getId());
        if (pst.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editarMedico(Medico medico) throws SQLException {
        String sql = "update medico set medicoNome = ?, medicoCRM = ?, medicoEspecialidade = ?, medicoEmail = ?, medicoTelefone = ? where medicoId = ? ";
        PreparedStatement pst = ConexaoBanco.getPreparedStatement(sql);
        pst.setString(1, medico.getNome());
        pst.setInt(2, medico.getCrm());
        pst.setString(3, medico.getEspecialidade());
        pst.setString(4, medico.getEmail());
        pst.setString(5, medico.getTelefone());
        pst.setInt(6, medico.getId());
        
        if (pst.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean salvarMedico(Medico medico) throws SQLException {
        if (medico.getId() == null) {
            cadastrarMedico(medico);
        } else {
            editarMedico(medico);
        }
        return false;
    }
    
}
