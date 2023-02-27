package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		int opcao = 0, numero, agencia, tipo, aniversario, numerodestino = 0;
		float saldo, limite, valor = 0.0f;
		String titular;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
			
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		while(true) {
			System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("                                                                   ");
			System.out.println("                          BANCO WATT´S                             ");
			System.out.println("                                                                   ");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("                                                                   ");
			System.out.println("                   1- Criar conta                                  ");
			System.out.println("                   2- Listar todas as contas                       ");
			System.out.println("                   3- Buscar conta por número                      ");
			System.out.println("                   4- Atualizar dados da conta                     ");
			System.out.println("                   5- Apagar conta                                 ");
			System.out.println("                   6- Sacar                                        ");
			System.out.println("                   7- Depositar                                    ");
			System.out.println("                   8- Transferir valores entre contas              ");
			System.out.println("                   9- Sair                                         ");
			System.out.println("                                                                   ");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("¬¬¬Digite sua opção:                                               ");
			System.out.println("                                                                   ");
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Apenas valores inteiros...");
				leia.nextLine();
				opcao = 0;
			}
			if(opcao == 9) {
				System.out.println("Banco Watt´s: menores taxas, melhores investimentos!");
				System.out.println("Volte sempre!\n\n");
				System.exit(0);
			}
			switch(opcao){
			case 1 ->{
				System.out.println("¬¬¬¬¬ Criar conta ¬¬¬¬¬ ");
				System.out.println("Número da agência: ");
				agencia = leia.nextInt();
				System.out.println("Nome titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				do {
					System.out.println("Tipo de conta (1-CC/2-CP): ");
					tipo = leia.nextInt();
				}while(tipo < 1 && tipo > 2);
				System.out.println("Saldo da conta: ");
				saldo = leia.nextFloat();
				switch(tipo) {
					case 1->{
						System.out.println("Limite da conta corrente: ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 ->{
						System.out.println("Aniversário da conta poupança: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					
				}
				keyPress();
				
			}
			case 2 ->{
				System.out.println("¬¬¬¬¬ Listar todas as contas ¬¬¬¬¬\n\n");
				contas.listasTodas();
				keyPress();
			}
			case 3 ->{
				System.out.println("¬¬¬¬¬ Consultar dados da conta por número ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
			}
			case 4 ->{
				System.out.println("¬¬¬¬¬ Atualizar dados da conta ¬¬¬¬¬\n\n");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				if(contas.buscarNaCollection(numero) != null) {
					System.out.println("Número da agência: ");
					agencia = leia.nextInt();
					System.out.println("Nome titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					tipo = contas.retornatipo(numero);
					System.out.println("Saldo da conta: ");
					saldo = leia.nextFloat();
					switch(tipo) {
						case 1->{
							System.out.println("Limite da conta corrente: ");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 ->{
							System.out.println("Aniversário da conta poupança: ");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
						
					}
					
			    }else
				   System.out.println("A conta não foi encontrada...");
				keyPress();
			}
			case 5 ->{
				System.out.println("¬¬¬¬¬ apagar conta ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
			}
			case 6 ->{
				System.out.println("¬¬¬¬¬ Saque ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				System.out.println("Valor de saque: ");
				valor = leia.nextFloat();
				contas.sacar(numero, valor);
				keyPress();
			}
			case 7 ->{
				System.out.println("¬¬¬¬¬ Depósito ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				System.out.println("Valor de depósito: ");
				valor = leia.nextFloat();
				contas.depositar(numero, valor);
				keyPress();
			}
			case 8 ->{
				System.out.println("¬¬¬¬¬ Transferência entre contas ¬¬¬¬¬");
				System.out.println("Número da conta de origem: ");
				numero = leia.nextInt();
				System.out.println("Número da conta de destino: ");
				numerodestino = leia.nextInt();
				System.out.println("Valor de transferência: ");
				valor = leia.nextFloat();
				contas.transferir(numero, numerodestino, valor);
				keyPress();
			}
			default ->System.out.println("Opção inválida, tente novamente...");
			}
			System.out.println(Cores.TEXT_RESET);
		}
		
	}
	public static void keyPress() {

		try{

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		}catch(IOException e){

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
		
	}

}
