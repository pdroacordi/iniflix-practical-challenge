package core.usecase;

import core.domain.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ObterQuantidadeSalariosPorFuncionarioUseCase {

    private final static BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static BigDecimal calculaSalarioPorFuncionario(Funcionario funcionario) {
        return funcionario.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
    }
}
