package meteo;

import java.util.GregorianCalendar;

import base.Position;

import com.eclipsesource.json.JsonObject;
import com.github.dvdme.ForecastIOLib.ForecastIO;

public class MeteoOnline {

	public Meteo getOnlineWeather(Position position) {
		ForecastIO fio = new ForecastIO("35fdc1064d39b1f86a7c3ed9f0dea4c3");
		fio.setUnits(ForecastIO.UNITS_SI);
		fio.setExcludeURL("hourly,minutely");
		boolean worked = fio.getForecast("" + position.getLati(),
				"" + position.getLongi());
		JsonObject response = fio.getCurrently();
		if (worked) {
			return new Meteo(Float.parseFloat(response.get("temperature")
					.toString()), Float.parseFloat(response.get(
					"precipProbability").toString()), response.get("summary")
					.toString());
		} else {
			return new Meteo().autoMeteo();
		}
	}

	public Meteo getOnlineWeather(Position position, GregorianCalendar date) {
		return new Meteo().autoMeteo(position, date);

	}

}
