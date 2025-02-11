package dataprovider;

import core.domain.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    private static final List<Funcionario> FUNCIONARIOS = new ArrayList<Funcionario>();

    public static boolean adicionarFuncionario(Funcionario funcionario) {
        FUNCIONARIOS.add(funcionario);
        return true;
    }

    public static boolean adicionarFuncionarios(List<Funcionario> funcionarios) {
        FUNCIONARIOS.addAll(funcionarios);
        return true;
    }

    public static boolean removerFuncionario(String nomeFuncionario) {
        List<Funcionario> aRemover = new ArrayList<>();
        for( Funcionario f : FUNCIONARIOS ) {
            if( f.getNome().equals(nomeFuncionario) ) {
                aRemover.add(f);
            }
        }
        if( aRemover.isEmpty() ) {
            return false;
        }
        FUNCIONARIOS.removeAll(aRemover);
        return true;
    }

    public static List<Funcionario> obterFuncionarios() {
        return FUNCIONARIOS;
    }

    public static Funcionario obterFuncionarioPorNome(String nomeFuncionario) {
        for( Funcionario f : FUNCIONARIOS ) {
            if( f.getNome().equals(nomeFuncionario) ) {
                return f;
            }
        }
        return null;
    }
}
