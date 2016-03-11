package com.upao.factory;

import com.upao.dao.ICliente;
import com.upao.dao.IEspecialidad;
import com.upao.dao.IMedico;
import com.upao.dao.IPan;

/**
 *
 * @author Upao
 */
public abstract class AbstractFactory {
    
    //Metodos ==> Retornan Interfaces
    public abstract ICliente getClienteDAO();
    public abstract IPan getPanDAO();
    public abstract IMedico getMedicoDAO();
    public abstract IEspecialidad getEspecialidadDAO();
    
    //Retorna La Factoria de Objetos Segun el Tipo
    public static AbstractFactory getFactory(FactoryType type){
        if(type.equals(FactoryType.MYSQL_Fac))
            return new FactoryMySQL();
        
        if(type.equals(FactoryType.ORA_Fac))
            return new FactoryOra();
        
        return null;
    }
}
