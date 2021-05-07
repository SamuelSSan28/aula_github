import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Integer option;
		Scanner s = new Scanner(System.in);

		Menu mainMenu = new Menu(Arrays.asList("Cadastrar Cliente", "Cadastrar Conta", "Depósito", "Saque",
				"Transferência", "Extrato da Conta", "Recarga de Celular", "Sair"));
		do {
			option = mainMenu.getSelection();
			switch (option) {
				case 1:
					System.out.println("Opção 1!");
					break;
				case 2:
					System.out.println("Opção 2!");
					break;
				case 3:
					System.out.println("Opção 3!");
					break;
				case 4:
					System.out.println("Opção 4!");
					break;
				case 5:
					System.out.println("Opção 5!");
					break;
				case 6:
					System.out.println("Opção 6!");
					break;
				case 7:
					System.out.println("Opção 7!");
					break;
				case 8:
					System.out.println("Tchau!");
					break;
			}
		} while (option != 8);
	}

}
