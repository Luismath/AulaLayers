package br.ifal.edu.service;

import java.util.List;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.domain.ContaSearchWrapper;

public interface IContaService {

    public void save(Conta conta);

    public List<Conta> findAll();

    public ContaSearchWrapper findOne(String numConta);

    public boolean saque(String numConta, double value);

    public boolean deposito(String numConta, double value);

    public boolean transferencia(String fromNumConta, String toNumConta, double value);
}
