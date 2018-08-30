package forma;

public class Circulo implements Forma {

	private double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}

	@Override
	public double calcArea() {
		return raio * raio * Math.PI;
	}

}
