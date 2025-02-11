package core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private BigDecimal salario;

    private String funcao;

    private Funcionario(FuncionarioBuilder builder) {
        super(builder.nome, builder.dataNascimento);
        this.salario = builder.salario;
        this.funcao = builder.funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public static class FuncionarioBuilder {
        private String nome;
        private LocalDate dataNascimento;
        private BigDecimal salario;
        private String funcao;

        public FuncionarioBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public FuncionarioBuilder dataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public FuncionarioBuilder salario(BigDecimal salario) {
            this.salario = salario;
            return this;
        }

        public FuncionarioBuilder funcao(String funcao) {
            this.funcao = funcao;
            return this;
        }

        public Funcionario build() {
            return new Funcionario(this);
        }
    }
}
