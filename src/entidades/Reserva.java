package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecao.ExcecaoDeDominio;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer sala;
	private Date entrada;
	private Date saida;

	public Reserva() {
	}

	public Reserva(Integer sala, Date entrada, Date saida) {
		if (!saida.after(entrada)) {
			throw new ExcecaoDeDominio("A data de saida de ser apos data de entrada ");
		}
		this.sala = sala;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long calc = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(calc, TimeUnit.MILLISECONDS);
	}

	public void atualizarData(Date entrada, Date saida) {
		
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			throw new ExcecaoDeDominio("As datas para atualizaçao devem ser datas futuras ");
		} if (!saida.after(entrada)) {
			throw new ExcecaoDeDominio("A data de saida de ser apos data de entrada ");
		}
		
		this.entrada = entrada;
		this.saida = saida;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva: Sala: " + sala + ", entrada: " + sdf.format(entrada) + ", saida: " + sdf.format(saida)
				+ ", " + duracao() + " noites");
		return sb.toString();
	}

}
