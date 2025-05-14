package br.ifal.edu.domain;

public class ContaSearchWrapper {

    private Conta conta;
    final boolean found;

    public ContaSearchWrapper(boolean found) {
        this.found = found;
    }

    public boolean isFound() {
        return this.found;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta newConta) {
        this.conta = newConta;
    }
}
