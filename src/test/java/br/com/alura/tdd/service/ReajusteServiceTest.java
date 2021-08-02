package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;


/**
 * O sistema deve permitir que os funcionários recebem reajuste salarial anual baseado em seu
 * desempenho, obedecendo as seguintes regras:
 * 1. Se o desempenho foi "A desejar", reajuste será de apenas 3% do salário
 * 2. Se o desempenho foi "Bom", reajuste será de 15% do salário
 * 3. Se o desempenho foi "Ótimo", reajuste será de 20% do salário
 */
public class ReajusteServiceTest {
    
    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoReajusteForADesejar() {
        BigDecimal tresPorcento = new BigDecimal("0.03");
        BigDecimal salarioAtual = new BigDecimal("3000");        
        BigDecimal valorAcrescentado = salarioAtual.multiply(tresPorcento);
        BigDecimal salarioEsperado = new BigDecimal("0.00");
        salarioEsperado = (salarioAtual.add(valorAcrescentado));
        
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), salarioAtual);

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(salarioEsperado, funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoReajusteForBom() {
        BigDecimal tresPorcento = new BigDecimal("0.15");
        BigDecimal salarioAtual = new BigDecimal("5000");        
        BigDecimal valorAcrescentado = salarioAtual.multiply(tresPorcento);
        BigDecimal salarioEsperado = new BigDecimal("0.00");
        salarioEsperado = (salarioAtual.add(valorAcrescentado));
        
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Rogério", LocalDate.now(), salarioAtual);

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(salarioEsperado, funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoReajusteForOtimo() {
        BigDecimal tresPorcento = new BigDecimal("0.20");
        BigDecimal salarioAtual = new BigDecimal("3000");        
        BigDecimal valorAcrescentado = salarioAtual.multiply(tresPorcento);
        BigDecimal salarioEsperado = new BigDecimal("0.00");
        salarioEsperado = (salarioAtual.add(valorAcrescentado));
        
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Rogério", LocalDate.now(), salarioAtual);

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(salarioEsperado, funcionario.getSalario());

    }
}
