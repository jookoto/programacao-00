public class FuncionarioTemporario extends Funcionario {
    private static final double DESCONTO = 100.00;

    public FuncionarioTemporario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase - DESCONTO;
    }
}