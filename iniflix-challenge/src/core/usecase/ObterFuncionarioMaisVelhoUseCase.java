package core.usecase;

import core.domain.Funcionario;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ObterFuncionarioMaisVelhoUseCase {

    public static Funcionario obterMaisVelho(List<Funcionario> funcionarios) {
        Optional<Funcionario> maisVelho = funcionarios.stream()
                .max(Comparator.comparing(Funcionario::getIdade));
        return maisVelho.orElse(null);
    }
}
