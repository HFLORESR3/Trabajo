package com.upao.factory;

import com.upao.dao.ICliente;
import com.upao.dao.IEspecialidad;
import com.upao.dao.IMedico;
import com.upao.dao.IPan;
import com.upao.dao.impl.EspecialidadDAOoracle;
import com.upao.dao.impl.MedicoDAOoracle;

/**
 *
 * @author Upao
 */
public class FactoryOra extends AbstractFactory{

    @Override
    public ICliente getClienteDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPan getPanDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IMedico getMedicoDAO() {
        return new MedicoDAOoracle();   
    }

    @Override
    public IEspecialidad getEspecialidadDAO() {
        return new EspecialidadDAOoracle();
    }

    
    
}
