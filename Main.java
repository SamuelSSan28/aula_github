import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Integer option;
		Scanner s = new Scanner(System.in);

		Banco banco = new Banco();

		Menu mainMenu = new Menu(Arrays.asList("Cadastrar Cliente", "Cadastrar Conta", "Depósito", "Saque",
				"Transferência", "Extrato da Conta", "Recarga de Celular", "Sair"));
		do {
			option = mainMenu.getSelection();
			switch (option) {
				case 1:
					Cliente cliente = new Cliente();

					System.out.println("Informe o nome: ");
					cliente.setNome(s.nextLine());

					System.out.println("Informe o cpf: ");
					cliente.setCpf(s.nextLine());

					System.out.println("Informe a senha: ");
					cliente.setSenha(s.nextLine());

					System.out.println(banco.cadastrarCliente(cliente));
					break;
				case 2:
					System.out.println("Informe o cpf do cliente: ");
					System.out.println(banco.abrirConta(s.nextLine()));
					break;
				case 3:
					Integer numeroConta = 0;
					double valorDeposito = 0.0;

					System.out.println("Informe o numero da conta: ");
					numeroConta = Integer.parseInt(s.nextLine());

					System.out.println("Informe o valor a ser depositado: ");
					valorDeposito = Double.valueOf(s.nextLine());

					Boolean resultadoDeposito = banco.deposito(numeroConta, valorDeposito);

					if (resultadoDeposito)
						System.out.println("\nDepósito realizado com sucesso!\n");
					else
						System.out.println(
								"\nNão foi possível realizar o depósito!\nPor favor, verifique o número da conta.\n");

					break;
				case 4:
					Integer numConta = 0;
					double valorSaque = 0.0;

					System.out.println("Informe o numero da conta: ");
					numConta = Integer.parseInt(s.nextLine());

					System.out.println("Informe o valor a ser sacado: ");
					valorSaque = Double.valueOf(s.nextLine());

					Boolean resultadoSaque = banco.saque(numConta, valorSaque);

					if(resultadoSaque) System.out.println("\n Saque realizado com sucesso!\n");
					else System.out.println("\nNão foi possível realizar o saque!\nPor favor, verifique o saldo e número da conta.\n");
					break;
				case 5:
					Integer c1, c2 = 0;
					double valor = 0.0;

					System.out.println("Informe o numero da conta de Origem: ");
					c1 = Integer.parseInt(s.nextLine());

					System.out.println("Informe o numero da conta de Destino: ");
					c2 = Integer.parseInt(s.nextLine());

					System.out.println("Informe o valor a ser tranferido: ");
					valor = Double.valueOf(s.nextLine());

					Boolean resultadoTransacao = banco.transferencia(c1, c2, valor);

					if (resultadoTransacao)
						System.out.println("Transferencia realizada com sucesso");
					else
						System.out.println(
								"Nao foi possivel realizar a transferencia !\n Verifique o saldo e o numero das contas !");

					break;
				case 6:
					System.out.println("Informe o numero da conta: ");
					Integer numero_conta = Integer.parseInt(s.nextLine());

					System.out.println("\n*****Extrato******");
					System.out.println(banco.getExtrato(numero_conta));
					System.out.println("******************\n");
					break;
				case 7:
					Integer conta = 0;
					String telefone;

					System.out.println("Informe o numero da conta: ");
					conta = Integer.parseInt(s.nextLine());

					System.out.println("Informe o numero do telefone: ");
					telefone = s.nextLine();

					Boolean resultadoRecarga = banco.recarga(conta, telefone);

					if (resultadoRecarga)
						System.out.println("\nRecarga para o número "+ telefone +" realizada com sucesso!\n");
					else
						System.out.println(
								"\nNão foi possível realizar a recarga!\nPor favor, verifique o número da conta e se há saldo disponível.\n");

					break;
				case 8:
					System.out.println("Tchau!");
					break;
			}
		} while (option != 8);
	}

}
