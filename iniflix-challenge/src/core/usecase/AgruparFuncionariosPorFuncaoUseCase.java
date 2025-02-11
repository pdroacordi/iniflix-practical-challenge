package core.usecase;

import core.domain.Funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgruparFuncionariosPorFuncaoUseCase {

    public static Map<String, List<Funcionario>> obterFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        funcionarios.forEach(funcionario -> {
            String funcao = funcionario.getFuncao();
            funcionariosPorFuncao.computeIfAbsent(funcao, k -> new ArrayList<>())
                    .add(funcionario);
        });
        return funcionariosPorFuncao;
    }
}
