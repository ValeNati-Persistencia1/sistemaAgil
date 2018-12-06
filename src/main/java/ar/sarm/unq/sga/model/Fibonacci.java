package ar.sarm.unq.sga.model;

public enum Fibonacci {
	UNO(1.0), DOS(2.0), TRES(3.0), CINCO(5.0), INFINITO(Double.POSITIVE_INFINITY);

	private double numero;

	private Fibonacci(Double numero) {
		this.setNumero(numero);
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}
}
