package base;

public class GeoTools {

	public GeoTools() {
	}

	// In Km's
	public double calcDistance(Position p1, Position p2) {

		double d2r = Math.PI / 180;
		double distance;

		try {
			double dlong = (p2.getLongi() - p1.getLongi()) * d2r;
			double dlat = (p2.getLati() - p1.getLati()) * d2r;
			double a = Math.pow(Math.sin(dlat / 2.0), 2)
					+ Math.cos(p1.getLati() * d2r)
					* Math.cos(p2.getLati() * d2r)
					* Math.pow(Math.sin(dlong / 2.0), 2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			distance = 6367 * c;
		} catch (Exception e) {
			distance = -1.0f;
		}
		return distance;
	}
}
