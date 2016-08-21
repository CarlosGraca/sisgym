/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Carlos
 */
public class Item {

    private int id;
    private String name;
    private int idMatricula;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Item(int id, String name, int idMatricula) {
        this.id = id;
        this.name = name;
        this.idMatricula = idMatricula;
    }
    public Item() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
