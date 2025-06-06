package br.com.llmtech.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "PAISES")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 3, columnDefinition = "char")
    private String sigla;

//    @OneToMany(mappedBy = "pais")
//    private List<Estado> estados;


    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

