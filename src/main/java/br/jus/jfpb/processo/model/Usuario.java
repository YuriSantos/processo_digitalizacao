package br.jus.jfpb.processo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@SequenceGenerator(
        name = "usuario_id",
        sequenceName = "usuario_seq",
        allocationSize = 1
)
public class Usuario extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usuario_id")
    private Long id;
    private String nome;
    private String senha;
    private boolean administrador;
    private int soma_alcancado;
    @ManyToOne
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public int getSoma_alcancado() {
        return soma_alcancado;
    }

    public void setSoma_alcancado(int soma_alcancado) {
        this.soma_alcancado = soma_alcancado;
    }
}

