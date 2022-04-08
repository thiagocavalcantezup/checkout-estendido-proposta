package br.com.zup.checkoutestendidoproposta.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "propostas")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @Positive
    private BigDecimal salario;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Proposta() {}

    public Proposta(String nome, String documento, String endereco, @Email String email,
                    @Positive BigDecimal salario) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

}
