public class FuncionarioCLT extends Funcionario {
    private static final double ADICIONAL = 300.00;

    public FuncionarioCLT(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + ADICIONAL;
    }
}