package meteo;

import java.util.GregorianCalendar;
import java.util.Random;

import base.Position;

public class Meteo {

	private float temperature;
	private float rainProbability;
	private String summary;

	public Meteo() {
		this.temperature = 15.0f;
		this.rainProbability = 0.25f;
	}

	public Meteo(float temperature, float rainProbability, String summary) {
		this.temperature = temperature;
		this.rainProbability = rainProbability;
		this.summary = summary;
	}

	public Meteo(float temperature, float rainProbability) {
		this.temperature = temperature;
		this.rainProbability = rainProbability;
		this.summary = "Estimated";
	}

	public Meteo(Meteo m) {
		this.temperature = m.getTemperature();
		this.rainProbability = m.getRainProbability();
		this.summary = m.getSummary();
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getRainProbability() {
		return rainProbability;
	}

	public void setRainProbability(float rainProbability) {
		this.rainProbability = rainProbability;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		} else {
			Meteo m = (Meteo) o;
			return (this.temperature == m.getTemperature())
					&& (this.rainProbability == m.getRainProbability());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nTemperature: ");
		sb.append(this.temperature);
		sb.append("\nRain Probability: ");
		sb.append(this.rainProbability);
		sb.append("\nSummary: ");
		sb.append(this.summary);
		return sb.toString();
	}

	public int compareTo(Meteo m) {
		if (this.equals(m))
			return 0;
		if (this.rainProbability < m.getRainProbability())
			return -1;
		else
			return 1;
	}

	public Meteo autoMeteo() {
		Random randomno = new Random();
		float temp = randomno.nextFloat();
		return new Meteo(temp * 25, randomno.nextFloat());
	}

	@Override
	public Meteo clone() {
		return new Meteo(this);
	}

	public Meteo autoMeteo(Position position, GregorianCalendar date) {
		Meteo res = null;
		boolean northHemisphere = position.getContinent().equals("Europe")
				|| position.getContinent().equals("North America")
				|| position.getContinent().equals("Asia");
		int season = position.getSeason(northHemisphere, date); // 0-winter;
																// 1-spring;
																// 2-summer;
																// 3-autumn
		Random randomno = new Random();
		switch (position.getContinent()) {
		case "Europe":
			switch (season) {
			case 0:
				res = new Meteo(randomno.nextFloat() * 10,
						randomno.nextFloat() * 85);
				break;
			case 1:
				res = new Meteo(randomno.nextFloat() * 25,
						randomno.nextFloat() * 55);
				break;
			case 2:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 5);
				break;
			case 3:
				res = new Meteo(randomno.nextFloat() * 25,
						randomno.nextFloat() * 50);
				break;
			}
			break;
		case "Asia":
			switch (season) {
			case 0:
				res = new Meteo(randomno.nextFloat() * 7,
						randomno.nextFloat() * 90);
				break;
			case 1:
				res = new Meteo(randomno.nextFloat() * 30,
						randomno.nextFloat() * 45);
				break;
			case 2:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 15);
				break;
			case 3:
				res = new Meteo(randomno.nextFloat() * 30,
						randomno.nextFloat() * 40);
				break;
			}
			break;
		case "South America":
			switch (season) {
			case 0:
				res = new Meteo(randomno.nextFloat() * 30,
						randomno.nextFloat() * 60);
				break;
			case 1:
				res = new Meteo(randomno.nextFloat() * 35,
						randomno.nextFloat() * 40);
				break;
			case 2:
				res = new Meteo(randomno.nextFloat() * 45,
						randomno.nextFloat() * 25);
				break;
			case 3:
				res = new Meteo(randomno.nextFloat() * 35,
						randomno.nextFloat() * 30);
				break;
			}
			break;
		case "Africa":
			switch (season) {
			case 0:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 10);
				break;
			case 1:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 13);
				break;
			case 2:
				res = new Meteo(randomno.nextFloat() * 45,
						randomno.nextFloat() * 10);
				break;
			case 3:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 12);
				break;
			}
			break;
		case "North America":
			switch (season) {
			case 0:
				res = new Meteo(randomno.nextFloat() * 10,
						randomno.nextFloat() * 85);
				break;
			case 1:
				res = new Meteo(randomno.nextFloat() * 25,
						randomno.nextFloat() * 55);
				break;
			case 2:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 5);
				break;
			case 3:
				res = new Meteo(randomno.nextFloat() * 25,
						randomno.nextFloat() * 50);
				break;
			}
			break;
		case "Oceanie":
			switch (season) {
			case 0:
				res = new Meteo(randomno.nextFloat() * 40,
						randomno.nextFloat() * 85);
				break;
			case 1:
				res = new Meteo(randomno.nextFloat() * 35,
						randomno.nextFloat() * 55);
				break;
			case 2:
				res = new Meteo(randomno.nextFloat() * 22,
						randomno.nextFloat() * 5);
				break;
			case 3:
				res = new Meteo(randomno.nextFloat() * 30,
						randomno.nextFloat() * 50);
				break;
			}
			break;
		default:
			res = new Meteo();
			break;
		}
		return res;
	}
}
