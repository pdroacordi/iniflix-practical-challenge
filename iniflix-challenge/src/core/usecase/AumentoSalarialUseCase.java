package core.usecase;

import core.domain.Funcionario;

import java.math.BigDecimal;

public class AumentoSalarialUseCase {

    public static BigDecimal aumentarSalario( double percentual, Funcionario funcionario ) {
        return funcionario.aumentarSalario(percentual);
    }

}
