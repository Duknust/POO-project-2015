package meteo;

import java.util.Random;

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

    public Meteo autoMeteo(){
        Random randomno = new Random();
        float temp = randomno.nextFloat();
        return new Meteo(temp*25, randomno.nextFloat(), "Estimated");
    }

	@Override
	public Meteo clone() {
		return new Meteo(this);
	}
}
