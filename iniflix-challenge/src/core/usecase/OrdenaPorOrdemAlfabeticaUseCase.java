package core.usecase;

import core.domain.Funcionario;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenaPorOrdemAlfabeticaUseCase {

    public static List<Funcionario> ordenarListaPorOrdemAlfabetica(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }
}
