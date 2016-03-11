/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.entity;

/**
 *
 * @author Armando
 */
public class Especialidad {
    private int id;
    private String especialidad;

    public Especialidad(int id, String especilidad) {
        this.id = id;
        this.especialidad = especilidad;
    }
    
    public Especialidad(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspeciliadad(String especilidad) {
        this.especialidad = especilidad;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "id=" + id + ", especilidad=" + especialidad + '}';
    }
    
    
    
}
