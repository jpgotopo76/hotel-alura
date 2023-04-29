package jdbc.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Reserva {
	private Integer id;
	private Date fechaE;
	private Date fechaS;
	private String valor;
	private String formaPago;
	
	public Reserva(Date fechaE, Date fechaS, String valor, String formaPago) {
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reserva(Integer id, Date fechaE, Date fechaS, String valor, String formaPago) {
		this.id = id;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Date getFechaEntrada() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId_Reserva() {
		// TODO Auto-generated method stub
		return (Integer) null;
	}

	public Date getFechaSalida() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getValorReserva() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFormaPago() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
