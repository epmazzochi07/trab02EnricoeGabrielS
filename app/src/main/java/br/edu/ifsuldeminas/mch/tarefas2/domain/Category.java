package br.edu.ifsuldeminas.mch.tarefas2.domain;

import java.io.Serializable;

public class Category implements Serializable {

    private Integer id;
    private String name;


    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%s", name);
    }
}
