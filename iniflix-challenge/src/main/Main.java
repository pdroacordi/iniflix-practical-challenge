package main;

import core.domain.Funcionario;
import dataprovider.FuncionarioRepository;
import utils.Formatador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        inserirFuncionarios(); //Inserir todos os funcionários, na mesma ordem e informações da tabela acima. OK

        FuncionarioRepository.removerFuncionario("João"); //Remover o funcionário “João” da lista. OK

        imprimirTodosFuncionarios(); //Imprimir todos os funcionários com todas suas informações. OK


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
}