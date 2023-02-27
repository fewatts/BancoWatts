package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	private int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null)
			conta.visualizar();
		else
			System.out.printf("Conta %d não encontrada...", numero);
	}

	@Override
	public void listasTodas() {
		for(var conta : listaContas)
			conta.visualizar();
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
		System.out.printf("\n  A conta de %s foi criada!\n", conta.getTitular());
		System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.printf("Conta %d atualizada! ", conta.getNumero());
			
		}else 
			System.out.printf("Conta %d não encontrada...", conta.getNumero());
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.printf("Conta %d foi excluída!", numero);
		}else
			System.out.printf("Conta %d não encontrada...", numero);
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		if(conta != null){
			if(conta.sacar(valor))
				System.out.println("O saque foi efetuado com sucesso!");
		}else
			System.out.printf("Conta %d não encontrada...", numero);
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		if(conta != null){
			conta.depositar(valor);
			System.out.println("O depósito foi efetuado com sucesso!");
		}else
			System.out.printf("Conta %d não encontrada...", numero);
		
	}

	@Override
	public void transferir(int numero, int numerodestino, float valor) {
		var contaOrigem = buscarNaCollection(numero);
		var contaDestino = buscarNaCollection(numerodestino);
		if(contaOrigem != null && contaDestino != null){
			if(contaOrigem.sacar(valor) == true){
				contaDestino.depositar(valor);
				System.out.println("A transferência foi efetuada com sucesso!");
			}
		}else
			System.out.println("A conta de origrm e /ou destino não foram encontradas...");
		
	}
	public int gerarNumero() {
		return ++numero;
		
	}
	public Conta buscarNaCollection(int numero){
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return conta;
		}
		return null;
	}
	public int retornatipo(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return conta.getTipo();
		}
		return 0;
	}
	
}
