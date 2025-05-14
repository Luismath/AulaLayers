package br.ifal.edu.repository;

import java.util.ArrayList;
import java.util.List;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.domain.ContaSearchWrapper;

public class InMemoryContaDao implements IContaDao {

    final static List<Conta> db = new ArrayList<>();

    @Override
    public void save(Conta conta) {
        // Chamada para o banco de dados
        db.add(conta);
    }

    @Override
    public List<Conta> findAll() {
        return db;
    }

    @Override
    public ContaSearchWrapper findOne(String numeroConta) {
        for (Conta conta : db) {
            if (conta.getNumero().equals(numeroConta)) {
                ContaSearchWrapper ContaSearchWrapper = new ContaSearchWrapper(true);
                ContaSearchWrapper.setConta(conta);
                return ContaSearchWrapper;
            }
        }
        return new ContaSearchWrapper(false);
    }

    @Override
    public boolean saque(String numConta, double value) {
        ContaSearchWrapper result = this.findOne(numConta);
        if (!result.isFound()) {
            return false;
        }
        Conta conta = result.getConta();
        if (conta.getSaldo() < value) {
            return false;
        }
        conta.setSaldo(conta.getSaldo() - value);
        return true;
    }

    @Override
    public boolean deposito(String numConta, double value) {
        ContaSearchWrapper result = this.findOne(numConta);
        if (!result.isFound()) {
            return false;
        }
        Conta conta = result.getConta();
        conta.setSaldo(conta.getSaldo() + value);
        return true;
    }

    @Override
    public boolean transferencia(String fromNumConta, String toNumConta, double value) {
        ContaSearchWrapper fromConta = this.findOne(fromNumConta);
        ContaSearchWrapper toConta = this.findOne(toNumConta);
        if (!fromConta.isFound() || !toConta.isFound()) {
            return false;
        }
        Conta fConta = fromConta.getConta();
        if (fConta.getSaldo() < value) {
            return false;
        }
        Conta tConta = toConta.getConta();
        fConta.setSaldo(fConta.getSaldo() - value);
        tConta.setSaldo(tConta.getSaldo() + value);
        return true;
    }

}
