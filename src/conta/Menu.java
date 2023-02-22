package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao, numero, agencia, tipo, aniversario, numerodestino;
		float saldo, limite, valor;
		String titular;
		
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
			opcao = leia.nextInt();
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
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da conta poupança: ");
						aniversario = leia.nextInt();
						ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();		
					}
					
				}
				
			}
			case 2 ->{
				System.out.println("¬¬¬¬¬ Listar todas as contas ¬¬¬¬¬\n\n");
			}
			case 3 ->{
				System.out.println("¬¬¬¬¬ Consultar dados da conta por número ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
			}
			case 4 ->{
				System.out.println("¬¬¬¬¬ Atualizar dados da conta ¬¬¬¬¬\n\n");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
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
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da conta poupança: ");
						aniversario = leia.nextInt();
						ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();		
					}
					
				}
				
			}
			case 5 ->{
				System.out.println("¬¬¬¬¬ apagar conta ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				//método apagar();
			}
			case 6 ->{
				System.out.println("¬¬¬¬¬ Saque ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				System.out.println("Valor de saque: ");
				valor = leia.nextFloat();
				//método sacar();
			}
			case 7 ->{
				System.out.println("¬¬¬¬¬ Depósito ¬¬¬¬¬");
				System.out.println("Número da conta: ");
				numero = leia.nextInt();
				System.out.println("Valor de depósito: ");
				valor = leia.nextFloat();
				//método depositar();
			}
			case 8 ->{
				System.out.println("¬¬¬¬¬ Transferência entre contas ¬¬¬¬¬");
				System.out.println("Número da conta de origem: ");
				numero = leia.nextInt();
				System.out.println("Número da conta de destino: ");
				numerodestino = leia.nextInt();
				System.out.println("Valor de transferência: ");
				valor = leia.nextFloat();
				//método transferência();
			}
			default ->System.out.println("Opção inválida, tente novamente...");
			}
			System.out.println(Cores.TEXT_RESET);
		}
		
	}

}
