public class ProgramaFolha {
    public static void main(String[] args) {
        FuncionarioCLT funcionarioCLT = new FuncionarioCLT("Carlos", 2000.00);
        FuncionarioTemporario funcionarioTemporario = new FuncionarioTemporario("Ana", 2000.00);

        funcionarioCLT.exibirDados();
        System.out.println("Salário Final: " + funcionarioCLT.calcularSalario());
        System.out.println();

        funcionarioTemporario.exibirDados();
        System.out.println("Salário Final: " + funcionarioTemporario.calcularSalario());
    }
}