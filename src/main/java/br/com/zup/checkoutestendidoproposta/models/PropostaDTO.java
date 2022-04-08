package br.com.zup.checkoutestendidoproposta.models;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PropostaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Positive
    private BigDecimal salario;

    public PropostaDTO() {}

    public PropostaDTO(@NotBlank String nome, @NotBlank String documento, @NotBlank String endereco,
                       @NotBlank @Email String email, @NotNull @Positive BigDecimal salario) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    public Proposta toModel() {
        return new Proposta(nome, documento, endereco, email, salario);
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

}
