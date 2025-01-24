package entities;

import java.util.Scanner;

public class JogoVelha {
	private char[][] matriz = new char[3][3];
	private char antigoValor = 'N';

	public JogoVelha() {
		for (int x = 0; x < this.matriz.length; x++) {
			for (int y = 0; y < this.matriz.length; y++) {
				this.matriz[x][y] = '_';
			}
		}
	}

	public void jogar() {
		int x, y;
		char valorJogada;
		boolean jogoFinalizado;
		Scanner sc = new Scanner(System.in);

		System.out.println("'S' para sair");

		do {

			System.out.print("Informe a posição X (1 : 3): ");
			x = sc.nextInt() - 1;

			System.out.print("Informe a posição Y (1 : 3): ");
			y = sc.nextInt() - 1;

			System.out.print("Informe o valor da jogada (X ou O): ");
			valorJogada = sc.next().charAt(0);

			this.fazerJogada(x, y, valorJogada);

			jogoFinalizado = this.verificaVitoria(valorJogada);

			this.mostrarTabuleiro();

		} while (valorJogada != 'S' && !jogoFinalizado);

		sc.close();
	}

	private void mostrarTabuleiro() {
		for (int x = 0; x < this.matriz.length; x++) {
			for (int y = 0; y < this.matriz.length; y++) {

				System.out.print(this.matriz[x][y] + " ");
			}
			System.out.println();
		}

		System.out.println("\n_______________________\n");

	}

	private void fazerJogada(int x, int y, char valorJogada) {

		if (valorJogada != antigoValor) {
			if (this.matriz[x][y] == '_') {

				this.matriz[x][y] = valorJogada;
				antigoValor = valorJogada;

			} else {

				System.out.println("\nPosição já selecionada\n");

			}
		} else {
			char aux;
			if (antigoValor == 'X') {
				aux = 'O';
			} else {
				aux = 'X';
			}

			System.out.println("\nTurno do jogador " + aux + "\n");
		}

	}

	private boolean verificaVitoria(char valorJogada) {

		// Verifico primeiro as linhas do tabuleiro
		final int x = 0;

		if ((this.matriz[x][x] == valorJogada && this.matriz[x][x + 1] == valorJogada
				&& this.matriz[x][x + 2] == valorJogada)
				|| (this.matriz[x + 1][x] == valorJogada && this.matriz[x + 1][x + 1] == valorJogada
						&& this.matriz[x + 1][x + 2] == valorJogada)
				|| (this.matriz[x + 2][x] == valorJogada && this.matriz[x + 2][x + 1] == valorJogada
						&& this.matriz[x + 2][x + 2] == valorJogada)) {
			anunciarVencedor(valorJogada);
			return true;
		}

		// Verifico as colunas do tabuleiro
		if ((this.matriz[x][x] == valorJogada && this.matriz[x + 1][x] == valorJogada
				&& this.matriz[x + 2][x] == valorJogada)
				|| (this.matriz[x][x + 1] == valorJogada && this.matriz[x + 1][x + 1] == valorJogada
						&& this.matriz[x + 2][x + 1] == valorJogada)
				|| (this.matriz[x][x + 2] == valorJogada && this.matriz[x + 1][x + 2] == valorJogada
						&& this.matriz[x + 2][x + 2] == valorJogada)) {
			anunciarVencedor(valorJogada);
			return true;
		}

		// Verifico as diagonais do tabuleiro
		if ((this.matriz[x][x] == valorJogada && this.matriz[x + 1][x + 1] == valorJogada
				&& this.matriz[x + 2][x + 2] == valorJogada)
				|| (this.matriz[x][x + 2] == valorJogada && this.matriz[x + 1][x + 1] == valorJogada
						&& this.matriz[x + 2][x] == valorJogada)) {
			anunciarVencedor(valorJogada);
			return true;
		} else {
			return false;
		}
	}

	private void anunciarVencedor(char valorJogada) {
		System.out.println("O jogador " + valorJogada + " é o vencedor!");
	}
}
