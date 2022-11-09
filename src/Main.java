import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Rodolfo");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        cc.depositar(100);
        cc.transferir(200, poupanca);

        cc.imprimirExtrato("=== Extrato Conta Corrente ===");
        System.out.println("--------");
        poupanca.imprimirExtrato("=== Extrato Conta Poupança ===");
    }
}