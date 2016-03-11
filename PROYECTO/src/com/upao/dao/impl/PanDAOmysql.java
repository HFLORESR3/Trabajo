/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.dao.impl;

import com.moduI.jdbc.ConnectionsMySQL;
import com.upao.dao.IPan;
import com.upao.entity.Pan;
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
public class PanDAOmysql implements IPan{
    Connection con;

    @Override
    public Pan create(Pan obj) throws SQLException {
        String insert = "insert into pan(nom_pan,stock) "
                + "values('"+obj.getNombre()+"','"+obj.getStock()+"')";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(insert);
        pt.executeUpdate();

        return null;
    }

    @Override
    public Pan update(Pan obj) throws SQLException {
        String update = "update pan set nom_pan = '" + obj.getNombre()
                + "', stock='" + obj.getStock() + "' "
                + "where id_pan='" + obj.getId() + "'";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(update);

        pt.executeUpdate();
        pt.close();
        return null;
    }

    @Override
    public Pan find(int id) throws SQLException {
        String sql = "select id_pan,nom_pan,stock from pan where id_pan='" + id + "'";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        Pan p = new Pan();
        while (rs.next()) {
            p.setId(Integer.parseInt(rs.getString("id_pan")));
            p.setNombre(rs.getString("nom_pan"));
            p.setStock(Integer.parseInt(rs.getString("stock")));
        }
        pt.close();
        rs.close();
        return p;
    }

    @Override
    public void delete(Pan obj) throws SQLException {
        String delete = "delete from pan where id_pan='" + obj.getId() + "'";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(delete);
        pt.executeUpdate();
        pt.close();
    }

    @Override
    public List<Pan> getAll() throws SQLException {
        List<Pan> lista = new ArrayList<>();
        String sql = "select * from pan";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Pan p = new Pan();
            p.setId(Integer.parseInt(rs.getString("id_pan")));
            p.setNombre(rs.getString("nom_pan"));
            p.setStock(Integer.parseInt(rs.getString("stock")));
            lista.add(p);
        }
        rs.close();
        pt.close();
        return lista;
    
    }
    
}
