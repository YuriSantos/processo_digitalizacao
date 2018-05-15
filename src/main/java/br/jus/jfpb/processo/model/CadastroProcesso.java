package br.jus.jfpb.processo.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(sequenceName="cadastro_seq", name="cadastro_id", allocationSize=1)
public class CadastroProcesso extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cadastro_id")
    private Long id;

    Calendar data_cadastro = Calendar.getInstance();

    @Column(name = "numero_processo", unique = true)
    private String numero_processo;

    @ManyToOne
    private Usuario usuario;
    private String salvo_por;

    private int numero_de_volume;
    private int numero_de_folhas;

    @Transient
    private String us_id;
    @Transient
    private String data_string;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getNumero_processo() {
        return numero_processo;
    }

    public void setNumero_processo(String numero_processo) {
        this.numero_processo = numero_processo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSalvo_por() {
        return salvo_por;
    }

    public void setSalvo_por(String salvo_por) {
        this.salvo_por = salvo_por;
    }

    public int getNumero_de_volume() {
        return numero_de_volume;
    }

    public void setNumero_de_volume(int numero_de_volume) {
        this.numero_de_volume = numero_de_volume;
    }

    public int getNumero_de_folhas() {
        return numero_de_folhas;
    }

    public void setNumero_de_folhas(int numero_de_folhas) {
        this.numero_de_folhas = numero_de_folhas;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

}
