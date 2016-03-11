/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.dao.impl;

import com.moduI.jdbc.ConnectionsMySQL;
import com.moduI.jdbc.ConnectionsORA;
import com.upao.dao.IEspecialidad;
import com.upao.entity.Especialidad;
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
public class EspecialidadDAOoracle implements IEspecialidad{
    
    Connection con;
    @Override
    public Especialidad create(Especialidad obj) throws SQLException {
        String insert = "insert into Especialidad(id_especialidad,especialidad) "
                + "values(?,?)";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(insert);
        pt.setString(1, Integer.toString(obj.getId()));
        pt.setString(2, obj.getEspecialidad());
        pt.executeUpdate();

        return null;
    }

    @Override
    public Especialidad update(Especialidad obj) throws SQLException {
        String update = "update especialidad set especialidad = '" + obj.getEspecialidad()+"' "
                + "where id_especialidad='" + obj.getId() + "'";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(update);

        pt.executeUpdate();
        pt.close();
        return null;
    }

    @Override
    public Especialidad find(int id) throws SQLException {
        
        String sql = "select id_especialidad,especialidad from especialidad where id_especialidad='" + id + "'";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        Especialidad e = new Especialidad();
        while (rs.next()) {
            e.setId(Integer.parseInt(rs.getString("id_especialidad")));
            e.setEspeciliadad(rs.getString("especialidad"));
        }
        return e;
    }

    @Override
    public void delete(Especialidad obj) throws SQLException {
        String delete = "delete from especialidad where id_especialidad='" + obj.getId() + "'";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(delete);
        pt.executeUpdate();
        pt.close();
    }

    @Override
    public List<Especialidad> getAll() throws SQLException {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "select id_especialidad,especialidad from especialidad";
        con = ConnectionsORA.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Especialidad e = new Especialidad();
            e.setId(Integer.parseInt(rs.getString("id_especialidad")));
            e.setEspeciliadad(rs.getString("especialidad"));
            lista.add(e);
        }
        rs.close();
        pt.close();
        return lista;
    }
    
}
