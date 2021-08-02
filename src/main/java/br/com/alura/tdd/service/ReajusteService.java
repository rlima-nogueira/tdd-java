package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

    private static final BigDecimal TRES_PORCENTO = new BigDecimal("0.03");
    private static final BigDecimal QUINZE_PORCENTO = new BigDecimal("0.15");
    private static final BigDecimal VINTE_PORCENTO = new BigDecimal("0.20");

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        if (desempenho.equals(Desempenho.A_DESEJAR)) {
            BigDecimal reajuste = funcionario.getSalario().multiply(TRES_PORCENTO);

            funcionario.reajustarSalario(reajuste);
        }

        if (desempenho.equals(Desempenho.BOM)) {
            BigDecimal reajuste = funcionario.getSalario().multiply(QUINZE_PORCENTO);

            funcionario.reajustarSalario(reajuste);
        }

        if (desempenho.equals(Desempenho.OTIMO)) {
            BigDecimal reajuste = funcionario.getSalario().multiply(VINTE_PORCENTO);

            funcionario.reajustarSalario(reajuste);
        }
    }

}
