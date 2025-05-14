package br.ifal.edu.service;

import java.util.List;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.domain.ContaSearchWrapper;
import br.ifal.edu.repository.IContaDao;

public class ContaService implements IContaService {

    final IContaDao dao;

    public ContaService(IContaDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Conta conta) {
        dao.save(conta);
    }

    @Override
    public List<Conta> findAll() {
        return dao.findAll();
    }

    @Override
    public ContaSearchWrapper findOne(String numConta) {
        return dao.findOne(numConta);
    }

    @Override
    public boolean saque(String numConta, double value) {
        if (value <= 0) {
            return false;
        }
        return dao.saque(numConta, value);
    }

    @Override
    public boolean deposito(String numConta, double value) {
        if (value <= 0) {
            return false;
        }
        return dao.deposito(numConta, value);
    }

    @Override
    public boolean transferencia(String fromNumConta, String toNumConta, double value) {
        if (value <= 0) {
            return false;
        }
        return dao.transferencia(fromNumConta, toNumConta, value);
    }

}
