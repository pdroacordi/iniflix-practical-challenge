package main;

import core.domain.Funcionario;
import core.usecase.*;
import dataprovider.FuncionarioRepository;
import utils.Formatador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {



    public static void main(String[] args) {
        final double PERCENTUAL_AUMENTO_SALARIAL = 10d;

        inserirFuncionarios(); //Inserir todos os funcionários, na mesma ordem e informações da tabela acima. OK

        FuncionarioRepository.removerFuncionario("João"); //Remover o funcionário “João” da lista. OK

        imprimirTodosFuncionarios(); //Imprimir todos os funcionários com todas suas informações. OK

        concederAumentoSalarial(PERCENTUAL_AUMENTO_SALARIAL); //Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor. OK

        System.out.println();
        System.out.println("---------------");
        System.out.println();

        imprimirFuncionariosPorFuncao(); //Imprimir os funcionários, agrupados por função. OK

        System.out.println();
        System.out.println("---------------");
        System.out.println();

        imprimirFuncionariosAniversarioOutubroDezembro(); // Imprimir os funcionários que fazem aniversário no mês 10 e 12. OK

        System.out.println();
        System.out.println("---------------");
        System.out.println();

        imprimirFuncionarioMaisVelho(); // Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade. OK

        System.out.println();
        System.out.println("---------------");
        System.out.println();

        imprimirPorOrdemAlfabetica(); // Imprimir a lista de funcionários por ordem alfabética. OK
    }

    private static void inserirFuncionarios(){
        List<Funcionario> funcionarios = List.of(
        new Funcionario.FuncionarioBuilder()
                .nome("Maria")
                .dataNascimento(LocalDate.of(2000, 10, 18))
                .salario(new BigDecimal("2009.44"))
                .funcao("Operador")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("João")
                .dataNascimento(LocalDate.of(1990, 5, 12))
                .salario(new BigDecimal("2284.38"))
                .funcao("Operador")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Caio")
                .dataNascimento(LocalDate.of(1961, 5, 2))
                .salario(new BigDecimal("9836.14"))
                .funcao("Coordenador")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Miguel")
                .dataNascimento(LocalDate.of(1988, 10, 14))
                .salario(new BigDecimal("19119.88"))
                .funcao("Diretor")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Alice")
                .dataNascimento(LocalDate.of(1995, 1, 5))
                .salario(new BigDecimal("2234.72"))
                .funcao("Recepcionista")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Heitor")
                .dataNascimento(LocalDate.of(1999, 11, 19))
                .salario(new BigDecimal("1582.72"))
                .funcao("Operador")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Arthur")
                .dataNascimento(LocalDate.of(1993, 3, 31))
                .salario(new BigDecimal("4071.84"))
                .funcao("Contador")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Laura")
                .dataNascimento(LocalDate.of(1994, 7, 8))
                .salario(new BigDecimal("3017.45"))
                .funcao("Gerente")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Heloísa")
                .dataNascimento(LocalDate.of(2003, 5, 24))
                .salario(new BigDecimal("1606.85"))
                .funcao("Eletricista")
                .build(),
        new Funcionario.FuncionarioBuilder()
                .nome("Helena")
                .dataNascimento(LocalDate.of(1996, 9, 2))
                .salario(new BigDecimal("2799.93"))
                .funcao("Gerente")
                .build()
        );

        FuncionarioRepository.adicionarFuncionarios(funcionarios);
    }

    private static void imprimirTodosFuncionarios(){
        List<Funcionario> funcionarios = FuncionarioRepository.obterFuncionarios();

        funcionarios.forEach( f -> {
            System.out.println( " [ Nome: "
                    .concat( f.getNome() )
                    .concat(", DataNascimento: ")
                    .concat( Formatador.formatar( f.getDataNascimento() ) )
                    .concat(", Salario: R$ ")
                    .concat( Formatador.formatar( f.getSalario() ) )
                    .concat(", Função: ")
                    .concat( f.getFuncao() )
                    .concat( " ]" )
            );
        } );
    }

    private static void concederAumentoSalarial(double percentual){
        List<Funcionario> funcionarios = FuncionarioRepository.obterFuncionarios();

        funcionarios.forEach( f -> {
            AumentoSalarialUseCase.aumentarSalario( percentual, f );
        });
    }

    private static void imprimirFuncionariosPorFuncao(){
        List<Funcionario> funcionarios = FuncionarioRepository.obterFuncionarios();

        Map<String, List<Funcionario>> funcionariosPorFuncao = AgruparFuncionariosPorFuncaoUseCase.obterFuncionariosPorFuncao(funcionarios);

        funcionariosPorFuncao.forEach( (funcao, lista) -> {
            System.out.println(funcao+": "+lista);
        });
    }

    private static void imprimirFuncionariosAniversarioOutubroDezembro(){
        List<Funcionario> funcionarios = FuncionarioRepository.obterFuncionarios();

        List<Funcionario> outubro = ObterAniversariantesPorMesUseCase.obterAniversariantesPorMes(funcionarios, 10);
        List<Funcionario> dezembro = ObterAniversariantesPorMesUseCase.obterAniversariantesPorMes(funcionarios, 12);

        System.out.println("Aniversariantes de Outubro: "+outubro);
        System.out.println("Aniversariantes de Dezembro: "+dezembro);
    }

    private static void imprimirFuncionarioMaisVelho(){
        List<Funcionario> funcionarios = FuncionarioRepository.obterFuncionarios();

        Funcionario maisVelho = ObterFuncionarioMaisVelhoUseCase.obterMaisVelho(funcionarios);

        System.out.println("Funcionário mais velho: "+maisVelho.getNome()+", "+maisVelho.getIdade()+" anos.");
    }

    private static void imprimirPorOrdemAlfabetica(){
        List<Funcionario> funcionarios = FuncionarioRepository.obterFuncionarios();

        List<Funcionario> ordenado = OrdenaPorOrdemAlfabeticaUseCase.ordenarListaPorOrdemAlfabetica(funcionarios);

        ordenado.forEach( f -> {
            System.out.println( " [ Nome: "
                    .concat( f.getNome() )
                    .concat(", DataNascimento: ")
                    .concat( Formatador.formatar( f.getDataNascimento() ) )
                    .concat(", Salario: R$ ")
                    .concat( Formatador.formatar( f.getSalario() ) )
                    .concat(", Função: ")
                    .concat( f.getFuncao() )
                    .concat( " ]" )
            );
        } );
    }
}