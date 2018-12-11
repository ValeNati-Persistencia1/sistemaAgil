package ar.sarm.unq.sga.model;

public enum Fibonacci {
	UNO(1), DOS(2), TRES(3), CINCO(5), INFINITO(Integer.MAX_VALUE);

	private int numero;

	private Fibonacci(int numero) {
		this.setNumero(numero);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
