package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class MyCalculo implements Calculo {

    @Override
    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
        List<CustoCargo> custoCargos = new ArrayList<>();
        funcionarios.stream()
                .collect(groupingBy(Funcionario::getCargo))
                .forEach((cargo, cargoFuncionarios) -> {
                    CustoCargo custoCargo = new CustoCargo();
                    custoCargo.setCargo(cargo);
                    custoCargo.setCusto(
                        cargoFuncionarios.stream()
                            .map(Funcionario::getSalario)
                            .reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                    custoCargos.add(custoCargo);
                });
        return custoCargos;
    }

    @Override
    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
        List<CustoDepartamento> custoDptos = new ArrayList<>();
        funcionarios.stream()
                .collect(groupingBy(Funcionario::getDepartamento))
                .forEach((dpto, dptoFuncionarios) -> {
                    CustoDepartamento custoDpto = new CustoDepartamento();
                    custoDpto.setDepartamento(dpto);
                    custoDpto.setCusto(
                            dptoFuncionarios.stream()
                                    .map(Funcionario::getSalario)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                    custoDptos.add(custoDpto);
                });
        return custoDptos;
    }
}
