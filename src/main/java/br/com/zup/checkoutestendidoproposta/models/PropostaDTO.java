package br.com.zup.checkoutestendidoproposta.models;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class PropostaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    @Size(min = 11, max = 14)
    private String cpf;

    @NotBlank
    private String endereco;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Positive
    private BigDecimal salario;

    public PropostaDTO() {}

    public PropostaDTO(@NotBlank String nome, @NotBlank @CPF @Size(min = 11, max = 14) String cpf,
                       @NotBlank String endereco, @NotBlank @Email String email,
                       @NotNull @Positive BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    public Proposta toModel() {
        String novoCpf = cpf.replaceAll("[^0-9]", "");

        return new Proposta(nome, novoCpf, endereco, email, salario);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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
