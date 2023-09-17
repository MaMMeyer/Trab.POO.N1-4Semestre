package com.N1.Atividade.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Agenda {

    @Id
    private int id;

    private String nome;

    private String contato;

    public Agenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getcontato() {
        return contato;
    }

    public void setcontato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "agenda{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}