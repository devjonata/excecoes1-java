package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer sala;
	private Date entrada;
	private Date saida;

	public Reserva() {
	}

	public Reserva(Integer sala, Date entrada, Date saida) {
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
