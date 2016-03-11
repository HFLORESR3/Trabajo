/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.dao.impl;

import com.moduI.jdbc.ConnectionsMySQL;
import com.upao.dao.ICliente;
import com.upao.entity.Cliente;
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
public class ClienteDAOmysql implements ICliente {

    Connection con;

    @Override
    public Cliente create(Cliente obj) throws SQLException {
        String insert = "insert into cliente(nom_cliente,direccion) "
                + "values(?,?)";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(insert);
        pt.setString(1, obj.getNombre());
        pt.setString(2, obj.getDireccion());

        pt.executeUpdate();

        return null;
    }

    @Override
    public Cliente update(Cliente obj) throws SQLException {
        String update = "update cliente set nom_cliente = '" + obj.getNombre()
                + "', direccion='" + obj.getDireccion() + "' "
                + "where id_cliente='" + obj.getId() + "'";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(update);

        pt.executeUpdate();
        pt.close();
        return null;
    }

    @Override
    public Cliente find(int id) throws SQLException {
        String sql = "select id_cliente,nom_cliente,direccion from cliente where id_cliente='" + id + "'";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        Cliente cl = new Cliente();
        while (rs.next()) {
            cl.setId(Integer.parseInt(rs.getString("id_cliente")));
            cl.setNombre(rs.getString("nom_cliente"));
            cl.setDireccion(rs.getString("direccion"));
        }
        return cl;
    }

    @Override
    public void delete(Cliente obj) throws SQLException {
        String delete = "delete from cliente where id_cliente='" + obj.getId() + "'";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(delete);
        pt.executeUpdate();
        pt.close();
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "select id_cliente,nom_cliente,direccion from cliente";
        con = ConnectionsMySQL.getInstance();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Cliente cl = new Cliente();
            cl.setId(Integer.parseInt(rs.getString("id_cliente")));
            cl.setNombre(rs.getString("nom_cliente"));
            cl.setDireccion(rs.getString("direccion"));
            lista.add(cl);
        }
        rs.close();
        pt.close();
        return lista;
    }

}
