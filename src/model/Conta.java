package model;

import lombok.Getter;
import service.IConta;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    final protected Cliente cliente;
    @Getter
    protected int agencia;
    @Getter
    protected int numero;
    @Getter
    protected double saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (this.saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente em conta para transferir: " + this.saldo + ", valor de deposito: " + valor);
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato(String tipoConta) {
        System.out.println(tipoConta);
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}