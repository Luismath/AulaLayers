package br.ifal.edu.domain;

public class Conta {

    private String numero;
    private String agencia;
    private String nome;
    private double saldo;

    public Conta(String numero, String agencia, String nome) {
        this.numero = numero;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = 0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double newSaldo) {
        this.saldo = newSaldo;
    }

    @Override
    public String toString() {
        return "Conta{"
                + "numero='" + numero + '\''
                + ", agencia='" + agencia + '\''
                + ", nome='" + nome + '\''
                + ", saldo=" + saldo
                + '}';
    }
}
