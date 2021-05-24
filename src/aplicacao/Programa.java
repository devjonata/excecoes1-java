package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Sala: ");
		int sala = sc.nextInt();
		System.out.print("Data de entrada (DD/MM/AAAA): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data de saida (DD/MM/AAAA): ");
		Date saida = sdf.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva: A data de saida de ser apos data de entrada ");
		} else {
			Reserva r = new Reserva(sala, entrada, saida);
			System.out.println(r);
			
			System.out.println();
			System.out.println("Informa a data para atualização da reserva: ");
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saida (DD/MM/AAAA): ");
			saida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (entrada.before(agora) || saida.before(agora)) {
				System.out.println("Erro na reserva: As datas para atualizaçao devem ser datas futuras ");
			} else if (!saida.after(entrada)) {
				System.out.println("Erro na reserva: A data de saida de ser apos data de entrada ");
			} else {
				r.atualizarData(entrada, saida);
				System.out.println(r);
			}
		}

		sc.close();
	}
}
