// Classe base Conta
abstract class Conta {
    protected String cliente;
    protected double saldo;

    public Conta(String cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            destino.depositar(valor);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void imprimirExtrato();

    public abstract void aplicarJurosDiarios();
}

// Subclasse ContaCorrente
class ContaCorrente extends Conta {
    private static final double JUROS_DIARIOS = 0.001; // 0.1%

    public ContaCorrente(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente de " + cliente + ": Saldo = " + saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        saldo += saldo * JUROS_DIARIOS;
    }
}

// Subclasse ContaPoupanca
class ContaPoupanca extends Conta {
    private static final double JUROS_DIARIOS = 0.0008; // 0.08%

    public ContaPoupanca(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança de " + cliente + ": Saldo = " + saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        saldo += saldo * JUROS_DIARIOS;
    }
}

// Subclasse ContaSalario
class ContaSalario extends Conta {
    public ContaSalario(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Salário de " + cliente + ": Saldo = " + saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        // Não aplica juros
    }
}