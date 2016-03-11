/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.dao.impl;

import com.moduI.jdbc.ConnectionsMySQL;
import com.moduI.jdbc.ConnectionsORA;
import com.upao.dao.IMedico;
import com.upao.entity.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */
public class MedicoDAOoracle implements IMedico{
    Connection con;

    @Override
    public Medico create(Medico obj) throws SQLException {
        String insert = "insert into medico(id_medico,nom_medico,direccion,telefono,cod_especialidad) "
                + "values(?,?,?,?,?)";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(insert);
        pt.setString(1, Integer.toString(obj.getId()));
        pt.setString(2, obj.getNombre());
        pt.setString(3, obj.getDireccion());
        pt.setString(4, obj.getTelefono());
        pt.setString(5, Integer.toString(obj.getEspecialidad().getId()));
        pt.executeUpdate();
        pt.close();
        return null;

    }

    @Override
    public Medico update(Medico obj) throws SQLException {
        String update = "update medico set nom_medico = '" + obj.getNombre()
                + "', direccion='" + obj.getDireccion()
                + "', telefono='" + obj.getTelefono()+ "' "
                + ", cod_especialidad='" + obj.getEspecialidad().getId()+ "' "
                + "where id_medico='" + obj.getId() + "'";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(update);
        pt.executeUpdate();
        pt.close();
        return null;
    }

    @Override
    public Medico find(int id) throws SQLException {
        String sql = "select * from medico where id_medico='" + id + "'";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        Medico m = new Medico();
        while (rs.next()) {
            m.setId(Integer.parseInt(rs.getString("id_medico")));
            m.setNombre(rs.getString("nom_medico"));
            m.setDireccion(rs.getString("direccion"));
            m.setTelefono(rs.getString("telefono"));
            EspecialidadDAOoracle a = new EspecialidadDAOoracle();
            m.setEspecialidad(a.find(Integer.parseInt(rs.getString("cod_especialidad"))));
            
        }
        return m;
    }

    @Override
    public void delete(Medico obj) throws SQLException {
        String delete = "delete from medico where id_medico='" + obj.getId() + "'";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(delete);
        pt.executeUpdate();
        pt.close();
    }
    

    @Override
    public List<Medico> getAll() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "select * from medico";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Medico m = new Medico();
            m.setId(Integer.parseInt(rs.getString("id_medico")));
            m.setNombre(rs.getString("nom_medico"));
            m.setDireccion(rs.getString("direccion"));
            m.setTelefono(rs.getString("telefono"));
            EspecialidadDAOoracle a = new EspecialidadDAOoracle();
            m.setEspecialidad(a.find(Integer.parseInt(rs.getString("cod_especialidad"))));
            lista.add(m);
        }
        rs.close();
        pt.close();
        return lista;
    }
    
}
