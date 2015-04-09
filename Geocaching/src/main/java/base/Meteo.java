package base;

public class Meteo {
	// variaveis de instância

	private int temperaturaMin;
	private int temperaturaMax;
	private int probabilidadeChuva;

	/**
	 * Constructor para objectos da classe Meteorologia
	 */
	public Meteo() {
		this.temperaturaMin = 0;
		this.temperaturaMax = 10;
		this.probabilidadeChuva = 50;
	}

	public Meteo(int temperaturaMin, int temperaturaMax,
			int probabilidadeChuva) {
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
		this.probabilidadeChuva = probabilidadeChuva;
	}

	public Meteo(Meteo m) {
		this.temperaturaMin = m.getTemperaturaMin();
		this.temperaturaMax = m.getTemperaturaMax();
		this.probabilidadeChuva = m.getProbabilidadeChuva();
	}

	// gets e sets

	public int getTemperaturaMin() {
		return this.temperaturaMin;
	}

	public int getTemperaturaMax() {
		return this.temperaturaMax;
	}

	public int getProbabilidadeChuva() {
		return this.probabilidadeChuva;
	}

	public void setTemperaturaMin(int temperaturamin) {
		this.temperaturaMin = temperaturaMin;
	}

	public void setTemperaturaMax(int temperaturamax) {
		this.temperaturaMax = temperaturaMax;
	}

	public void setProbabilidadeChuva(int probabilidadechuva) {
		this.probabilidadeChuva = probabilidadeChuva;
	}

	// Outros metodos

	// ALTERAR
	public int temperatura() {
		return (int) (this.temperaturaMin + (Math.random() * ((this.temperaturaMax - this.temperaturaMin) + 1)));
	}

	public String tempo(int temp) {
		String tempo = new String();
		int r = (int) (Math.random() * 101);
		if (this.probabilidadeChuva >= r) {
			if (temp <= 2)
				tempo = "Neve";
			else
				tempo = "Chuva";
		} else if (temp > 25)
			tempo = "Seco";
		else
			tempo = "Normal";
		return tempo;
	}

	/** equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		} else {
			Meteo m = (Meteo) o;
			return (this.temperaturaMin == m.getTemperaturaMin())
					&& (this.temperaturaMax == m.getTemperaturaMax())
					&& (this.probabilidadeChuva == m.getProbabilidadeChuva());
		}
	}

	/** toString */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nTemperatura Minima : ");
		sb.append(this.temperaturaMin);
		sb.append("\nTemperatura Maxima : ");
		sb.append(this.temperaturaMax);
		sb.append("\nProbabilidade de Chuva : ");
		sb.append(this.probabilidadeChuva);
		return sb.toString();
	}

	/** compareTo */

	public int compareTo(Meteo m) {
		if (this.equals(m))
			return 0;
		if (this.probabilidadeChuva < m.getProbabilidadeChuva())
			return -1;
		else
			return 1;
	}

	/** clone */
	@Override
	public Meteo clone() {
		return new Meteo(this);
	}
}
