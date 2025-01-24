package application;

import java.util.Scanner;

import entities.JogoVelha;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		JogoVelha jogo = new JogoVelha();

		jogo.jogar();

		sc.close();
	}

}
