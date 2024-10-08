package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class Aluno {
    // -- campos de controle
    private UUID id;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private boolean desativado; // false

    // --
    private String nome;
    private String enderecoEletronico;
    private String login; // e-mail
    private String cpf;

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao=" + dataHoraAlteracao
                + ", desativado=" + desativado + ", nome=" + nome + ", enderecoEletronico=" + enderecoEletronico
                + ", login=" + login + ", cpf=" + cpf + "]";
    }

    public void save() {
        // persistir o objeto
        Banco.dados.put(cpf, this); // insert/update
    }

    private static class Banco {
        private static Map<String, Aluno> dados = new HashMap<>();
    }

    // void, null, undefined, NaN
    // INTEGER dependentes -- null

    public static Optional<Aluno> buscaCpf(String cpf) {
        // accountability - responsabilização
        Aluno aluno = Banco.dados.get(cpf); // aluno ou null

        return Optional.ofNullable(aluno);
    }
}
