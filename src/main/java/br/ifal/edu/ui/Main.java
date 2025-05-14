package br.ifal.edu.ui;

import java.util.Scanner;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.domain.ContaSearchWrapper;
import br.ifal.edu.repository.MysqlContaDao;
import br.ifal.edu.service.ContaService;
import br.ifal.edu.service.IContaService;

public class Main {

    public static void main(String[] args) {
        int opc = 0;
        IContaService service = new ContaService(new MysqlContaDao());

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar por Numero");
            System.out.println("3 - Mostrar Todos");
            System.out.println("4 - Deposito");
            System.out.println("5 - Saque");
            System.out.println("6 - Transferência");

            System.out.print("Digite a opc desejada: ");

            opc = scanner.nextInt();

            if (opc == 1) {
                System.out.print("Digite o numero: ");
                String numero = scanner.next();
                System.out.print("Digite a agencia: ");
                String agencia = scanner.next();
                System.out.print("Digite o nome: ");
                String nome = scanner.next();

                Conta conta = new Conta(numero, agencia, nome);
                service.save(conta);
            }
            if (opc == 2) {
                System.out.print("Digite o numero: ");
                String numero = scanner.next();

                ContaSearchWrapper result = service.findOne(numero);
                if (!result.isFound()) {
                    System.out.println("Conta não encontrada");
                } else {
                    System.out.println("conta: " + result.getConta());
                }
            }

            if (opc == 3) {
                var list = service.findAll();
                for (Conta conta : list) {
                    System.out.println("Conta: " + conta);
                }
            }

            if (opc == 4) {
                System.out.print("Digite o numero da conta: ");
                String numero = scanner.next();
                System.out.print("Insira o valor para depositar: ");
                double value = scanner.nextDouble();
                boolean result = service.deposito(numero, value);
                if (!result) {
                    System.out.println("Falha ao realizar o deposito");
                } else {
                    System.out.println("Deposito realizado com sucesso");
                }
            }

            if (opc == 5) {
                System.out.print("Digite o numero da conta: ");
                String numero = scanner.next();
                System.out.print("Insira o valor para sacar: ");
                double value = scanner.nextDouble();
                boolean result = service.saque(numero, value);
                if (!result) {
                    System.out.println("Falha ao realizar o saque");
                } else {
                    System.out.println("Saque realizado com sucesso");
                }
            }

            if (opc == 6) {
                System.out.print("Digite o numero da conta de origem: ");
                String fromNum = scanner.next();
                System.out.print("Digite o numero da conta de destino: ");
                String toNum = scanner.next();
                System.out.print("Digite o valor a transferir: ");
                double value = scanner.nextDouble();
                boolean result = service.transferencia(fromNum, toNum, value);
                if (!result) {
                    System.out.println("Houve uma falha durante a transferencia");
                } else {
                    System.out.println("Transferencia realizada com sucesso");
                }
            }

        } while (opc != 0);

    }
}
