package model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recarga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Puedes usar GenerationType.IDENTITY para generación automática
	private int id;
	private Date fecha;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id") // Nombre de la columna en la tabla Recarga
    //@Transient
	private Cliente cliente;
	private double saldo;
	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
