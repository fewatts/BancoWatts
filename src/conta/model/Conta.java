package conta.model;

import conta.util.Cores;

public abstract class Conta {
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println(Cores.TEXT_RED_BOLD+"\n                    Saldo insuficiente..."+Cores.TEXT_RESET);
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("Novo saldo: "+ getSaldo());
		return true;
	}
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	public void visualizar() {
		String tipo = "";
		switch(this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta poupança";
		}
		System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
		System.out.println("       DADOS DA CONTA       ");
		System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
		System.out.println("Número da conta: "+ this.numero);
		System.out.println("Número da agência: "+ this.agencia);
		System.out.println("Tipo de conta: "+ tipo);
		System.out.println("Nome do titular: "+ this.titular);
		System.out.println("Saldo da conta: "+ this.saldo);
	}
	
}
