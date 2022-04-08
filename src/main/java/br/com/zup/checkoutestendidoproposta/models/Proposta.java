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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "propostas")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 11)
    @CPF
    @Size(min = 11, max = 11)
    private String cpf;

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

    public Proposta(String nome, @CPF @Size(min = 11, max = 11) String cpf, String endereco,
                    @Email String email, @Positive BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

}
