package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Reserva;
import excecao.ExcecaoDeDominio;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Sala: ");
			int sala = sc.nextInt();
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			Date entrada = sdf.parse(sc.next());
			System.out.print("Data de saida (DD/MM/AAAA): ");
			Date saida = sdf.parse(sc.next());
			
			Reserva r = new Reserva(sala, entrada, saida);
			System.out.println(r);
			
			System.out.println();
			System.out.println("Informa a data para atualização da reserva: ");
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saida (DD/MM/AAAA): ");
			saida = sdf.parse(sc.next());
			
			r.atualizarData(entrada, saida);	
		} catch (ParseException e){
			System.out.println("Formato de data invalido: ");
		} catch (ExcecaoDeDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

		sc.close();
	}
}
