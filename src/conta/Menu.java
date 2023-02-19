package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		Conta c = new Conta(1, 123, 1, "Fernando Alves", 1723.24f);
		int opcao;
		
		c.visualizar();
		System.out.println(c.getSaldo());
		
		c.depositar(300);
		c.sacar(10000);
		System.out.println();
		System.out.println(c.getSaldo());
		System.out.println();
		
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
			System.out.println(Cores.TEXT_RESET);
			opcao = leia.nextInt();
			if(opcao == 9) {
				System.out.println("Banco Watt´s: menores taxas, melhores investimentos!");
				System.out.println("Volte sempre!\n\n");
				System.exit(0);
			}
			switch(opcao){
			case 1 ->{
				System.out.println("Criar conta\n\n");
			}
			case 2 ->{
				System.out.println("Listar todas as contas\n\n");
			}
			case 3 ->{
				System.out.println("Consultar dados da conta por número\n\n");
			}
			case 4 ->{
				System.out.println("Atualizar dados da conta\n\n");
			}
			case 5 ->{
				System.out.println("pagar conta\n\n");
			}
			case 6 ->{
				System.out.println("Saque\n\n");
			}
			case 7 ->{
				System.out.println("Depósito\n\n");
			}
			case 8 ->{
				System.out.println("Transferência entre contas\n\n");
			}
			default ->System.out.println("Opção inválida, tente novamente...");
			}
			
		}

	}

}
