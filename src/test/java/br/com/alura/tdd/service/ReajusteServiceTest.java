package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
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
    
    private ReajusteService service;
    private Funcionario funcionario;
    
    
    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Rafaela", LocalDate.now(), new BigDecimal("5000"));
    }

    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoReajusteForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("5150.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoReajusteForBom() {      
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("5750.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoReajusteForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("6000.00"), funcionario.getSalario());

    }
}
