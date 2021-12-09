package models;

public class CuentaCorriente {
	// Propiedades
	private int numeroCuenta;
	private double saldo;
	private Persona titular;

	// Metodos
	/**
	 * Metodo para sumar dinero a la cuenta.
	 * 
	 * @param cantidad Suma una cantidad positiva de dinero
	 * @throws Exception Lanza excepción si la cantidad introducida es negativa
	 */
	public void sumarCantidad(double cantidad) throws Exception {
		if (cantidad > 0)
			this.saldo += cantidad;
		else
			throw new Exception("No puedes sumar una cantidad negativa");
	}

	/**
	 * Metodo para restar dinero a la cuenta
	 * 
	 * @param cantidad Resta una cantidad positiva de dinero
	 * @throws Exception Lanza una excepción si la cantidad introducida es negativa
	 *                   o si introduces una cantidad de dinero que no tienes
	 */
	public void restarCantidad(double cantidad) throws Exception {
		if (cantidad > 0) {
			if (this.saldo >= cantidad)
				this.saldo -= cantidad;
			else
				throw new Exception("No tienes esa cantidad de dinero para retirar");
		} else
			throw new Exception("No puedes restar una cantidad negativa");
	}
	//Constructor
	public CuentaCorriente(int numeroCuenta, double saldo, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}
	//Getters y setters
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Persona getTitular() {
		return titular;
	}
	//TO String
	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}

}
