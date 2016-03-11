/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.main;

import com.upao.dao.ICliente;
import com.upao.dao.IEspecialidad;
import com.upao.dao.IMedico;
import com.upao.dao.IPan;
import com.upao.dao.impl.ClienteDAOmysql;
import com.upao.entity.Cliente;
import com.upao.entity.Especialidad;
import com.upao.entity.Medico;
import com.upao.entity.Pan;
import com.upao.factory.AbstractFactory;
import com.upao.factory.FactoryType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        IMedico m = AbstractFactory.getFactory(FactoryType.ORA_Fac).getMedicoDAO();
        IEspecialidad e = AbstractFactory.getFactory(FactoryType.ORA_Fac).getEspecialidadDAO();

        Especialidad e1 = new Especialidad(1, "ALERGOLOGIA");
        Especialidad e2 = new Especialidad(2, "CARDIOLOGIA");
        Especialidad e3 = new Especialidad(3, "CIRUGIA DE CABEZA Y CUELLO");
        Especialidad e4 = new Especialidad(4, "CIRUGIA DE COLUMNA VERTEBRAL");
        
        e.create(e1);
        e.create(e2);
        e.create(e3);
        e.create(e4);
        
        System.out.println("ESPECIALDIDADES");
        for(Especialidad especialidad :  e.getAll()){
                System.out.println(especialidad.toString());
        }
        
        Medico m1 = new Medico(1, "Medico1", "A", "558977830", e1);
        Medico m2 = new Medico(2, "Medico2", "B", "985465234", e2);
        Medico m3 = new Medico(3, "Medico3", "C", "985632568", e3);
        Medico m4 = new Medico(4, "Medico4", "D", "985478542", e4);
        System.out.println("MEDICOS");
        
        m.create(m1);
        m.create(m2);
        m.create(m3);
        m.create(m4);
        for(Medico medicos :  m.getAll()){
                System.out.println(medicos.toString());
        }
    }

}
