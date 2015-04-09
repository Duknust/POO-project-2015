package base;

public class Statistics {

	public Statistics(Statistics e) {

	}

	/** clone */
	@Override
	public Statistics clone() {
		return new Statistics(this);
	}
}
