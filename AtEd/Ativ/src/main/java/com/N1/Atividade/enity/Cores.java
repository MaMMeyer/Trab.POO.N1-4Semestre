package com.N1.Atividade.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cores {

    @Id
    private int id;

    private String ncor;

    private String hexa;

    public Cores() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getncor() {
        return ncor;
    }

    public void setncor(String ncor) {
        this.ncor = ncor;
    }

    public String gethexa() {
        return hexa;
    }

    public void sethexa(String hexa) {
        this.hexa = hexa;
    }

    @Override
    public String toString() {
        return "cores{" +
                "id=" + id +
                ", ncor='" + ncor + '\'' +
                ", hexa='" + hexa + '\'' +
                '}';
    }
}