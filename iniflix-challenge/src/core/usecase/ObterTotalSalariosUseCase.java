package core.usecase;

import core.domain.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ObterTotalSalariosUseCase {

    public static BigDecimal obterSalariosTotal(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
