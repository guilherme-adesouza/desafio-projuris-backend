package br.com.projuris;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculoTests {

    static List<Funcionario> listaFuncionarios = new ArrayList<>();

    @BeforeAll
    static void initEmployees() {
        listaFuncionarios.add(new Funcionario("Assistente", "Administrativo", new BigDecimal("1000.0")));
        listaFuncionarios.add(new Funcionario("Gerente", "Administrativo", new BigDecimal("7000.70")));
        listaFuncionarios.add(new Funcionario("Diretor", "Administrativo", new BigDecimal("10000.45")));
        listaFuncionarios.add(new Funcionario("Assistente", "Financeiro", new BigDecimal("1300.9")));
        listaFuncionarios.add(new Funcionario("Gerente", "Financeiro", new BigDecimal(7500)));
        listaFuncionarios.add(new Funcionario("Diretor", "Financeiro", new BigDecimal("11000.0")));
        listaFuncionarios.add(new Funcionario("Estagiário", "Jurídico", new BigDecimal("700.4")));
        listaFuncionarios.add(new Funcionario("Assistente", "Jurídico", new BigDecimal("1800.90")));
        listaFuncionarios.add(new Funcionario("Gerente", "Jurídico", new BigDecimal("9500.50")));
        listaFuncionarios.add(new Funcionario("Diretor", "Jurídico", new BigDecimal("13000.0")));
    }

    @Test
    void custoPorCargo() {
        MyCalculo calculo = new MyCalculo();
        final List<CustoCargo> custoCargos = calculo.custoPorCargo(listaFuncionarios);
        final CustoCargo estagiario = custoCargos.stream().filter(custoCargo -> custoCargo.getCargo().equals("Estagiário")).findAny().get();
        assertThat(estagiario.getCusto()).isEqualTo(new BigDecimal("700.4"));
        final CustoCargo assistente = custoCargos.stream().filter(custoCargo -> custoCargo.getCargo().equals("Assistente")).findAny().get();
        assertThat(assistente.getCusto()).isEqualTo(new BigDecimal("4101.80"));
        final CustoCargo gerente = custoCargos.stream().filter(custoCargo -> custoCargo.getCargo().equals("Gerente")).findAny().get();
        assertThat(gerente.getCusto()).isEqualTo(new BigDecimal("24001.20"));
        final CustoCargo diretor = custoCargos.stream().filter(custoCargo -> custoCargo.getCargo().equals("Diretor")).findAny().get();
        assertThat(diretor.getCusto()).isEqualTo(new BigDecimal("34000.45"));
    }

    @Test
    void custoPorDepartamento() {
        MyCalculo calculo = new MyCalculo();
        final List<CustoDepartamento> custoDepartamentos = calculo.custoPorDepartamento(listaFuncionarios);
        final CustoDepartamento administrativo = custoDepartamentos.stream().filter(custoCargo -> custoCargo.getDepartamento().equals("Administrativo")).findAny().get();
        assertThat(administrativo.getCusto()).isEqualTo(new BigDecimal("18001.15"));
        final CustoDepartamento financeiro = custoDepartamentos.stream().filter(custoCargo -> custoCargo.getDepartamento().equals("Financeiro")).findAny().get();
        assertThat(financeiro.getCusto()).isEqualTo(new BigDecimal("19800.9"));
        final CustoDepartamento juridico = custoDepartamentos.stream().filter(custoCargo -> custoCargo.getDepartamento().equals("Jurídico")).findAny().get();
        assertThat(juridico.getCusto()).isEqualTo(new BigDecimal("25001.80"));
    }
}
