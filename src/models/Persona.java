package models;

public class Persona {
	// Propiedades
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuentaCorriente;

	// Metodos
	/**
	 * Metodo para cobrar el sueldo. Suma el sueldo al saldo de la cuenta corriente
	 */
	public void cobrarSueldo() {
		cuentaCorriente.setSaldo(cuentaCorriente.getSaldo() + this.sueldo);
	}

	/**
	 * Metodo para sacar dinero. Saca dinero si hay suficiente en la cuenta
	 * @param cantidad Cantidad de dinero que se quieres sacar
	 * @throws Exception Lanza una excepción en caso de intentar sacar más de lo que tienes
	 */
	public void sacarPasta(double cantidad) throws Exception {
		if (cuentaCorriente.getSaldo() >= cantidad)
			cuentaCorriente.setSaldo(cuentaCorriente.getSaldo() - cantidad);
		else
			throw new Exception("No puedes sacar más de lo que tienes");
	}

	/**
	 * Metodo para cambiar el sueldo. Aunque el metodo se llame "subir sueldo"
	 * porque lo especificaba el enunciado, este método permite modificar el sueldo
	 * para más o para menos, pero nunca una cantidad negativa.
	 * 
	 * @param cantidad Nuevo sueldo
	 * @throws Exception Lanza una excepción en caso de que intentes asignar un sueldo negativo
	 */
	public void subirSueldo(double cantidad) throws Exception {
		if (cantidad < 0)
			throw new Exception("No puedes tener un sueldo negativo");
		else
			this.sueldo = cantidad;
	}
	//Constructor
	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cuentaCorriente) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuentaCorriente = cuentaCorriente;
	}
	//Getters y setters
	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldo() {
		return sueldo;
	}
	//To String
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sueldo=" + sueldo
				+ "€, saldo=" + cuentaCorriente.getSaldo() + "€ , numero de cuenta=" + cuentaCorriente.getNumeroCuenta()
				+ "]";
	}

}
