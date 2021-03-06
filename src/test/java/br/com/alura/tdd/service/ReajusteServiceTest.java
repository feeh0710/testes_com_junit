package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	ReajusteService service;
	Funcionario funcionario ;
	
	@BeforeEach // roda esse metodo toda vez antes de cada metodo testado
	public void inicializar() {
			this.service = new ReajusteService();
			this.funcionario = new Funcionario("Dernando", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario,Desempenho.A_DESEJAR);
		Assertions.assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario,Desempenho.BOM);
		Assertions.assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
	}
	@Test
	public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario,Desempenho.OTIMO);		
		Assertions.assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
	}
}
