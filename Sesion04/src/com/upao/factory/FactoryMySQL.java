package com.upao.factory;

import com.upao.dao.ICliente;
import com.upao.dao.IEspecialidad;
import com.upao.dao.IMedico;
import com.upao.dao.IPan;
import com.upao.dao.impl.ClienteDAOmysql;
import com.upao.dao.impl.PanDAOmysql;

/**
 *
 * @author Upao
 */
public class FactoryMySQL extends AbstractFactory{

    @Override
    public ICliente getClienteDAO() {
        return new ClienteDAOmysql();
    }

    @Override
    public IPan getPanDAO() {
        return new PanDAOmysql();
    }

    @Override
    public IMedico getMedicoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEspecialidad getEspecialidadDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
