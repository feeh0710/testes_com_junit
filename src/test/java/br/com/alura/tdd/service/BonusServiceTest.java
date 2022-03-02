package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	BonusService service;
	
	//  @AfterEach dispara o metodo depois de cada metodo teste
	//  @BeforAll  roda uma unica vez antes de todos os metodos testes(precisa ser estatico)
	// @AfterAll  roda uma unica vez depois de todos os metodos tetes(precisa ser estatico)
	
	@BeforeEach
	public void inicializar() {
		this.service = new BonusService();
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
