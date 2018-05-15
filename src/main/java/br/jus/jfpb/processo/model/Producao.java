package br.jus.jfpb.processo.model;

import java.io.Serializable;

public class Producao implements Serializable {

    private Long id;
    private String salvo_por;
    private int total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSalvo_por() {
        return salvo_por;
    }

    public void setSalvo_por(String salvo_por) {
        this.salvo_por = salvo_por;
    }
}
