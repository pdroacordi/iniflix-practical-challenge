package core.usecase;

import core.domain.Funcionario;

import java.util.List;

public class ObterAniversariantesPorMesUseCase {

    public static List<Funcionario> obterAniversariantesPorMes(List<Funcionario> funcionarios, int mes) {
        return funcionarios.stream()
                    .filter( f -> {
                        int nasc = f.getDataNascimento().getMonthValue();
                        return nasc == mes;
                    } )
                    .toList();
    }
}
