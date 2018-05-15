package br.jus.jfpb.processo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(sequenceName="meta_seq", name="meta_id", allocationSize=1)
public class Meta extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meta_id")
    private Long id;

    @ManyToOne
    private Usuario usuario;
    private int meta_estipulada;
    private int meta_alcancada;
    private int meta_total;
    private float porcentagem;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getMeta_estipulada() {
        return meta_estipulada;
    }

    public void setMeta_estipulada(int meta_estipulada) {
        this.meta_estipulada = meta_estipulada;
    }

    public int getMeta_alcancada() {
        return meta_alcancada;
    }

    public void setMeta_alcancada(int meta_alcancada) {
        this.meta_alcancada = meta_alcancada;
    }

    public int getMeta_total() {
        return meta_total;
    }

    public void setMeta_total(int meta_total) {
        this.meta_total = meta_total;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }
}
