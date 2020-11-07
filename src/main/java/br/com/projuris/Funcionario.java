package br.com.projuris;

import java.math.BigDecimal;
public class Funcionario {

    private String cargo;
    private String departamento;
    private BigDecimal salario;

    public Funcionario(String cargo, String departamento, BigDecimal salario) {
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}