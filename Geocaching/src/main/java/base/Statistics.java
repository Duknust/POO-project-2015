package base;

import java.io.Serializable;

public class Statistics implements Serializable {

    int numberCachesLastMonth = 0;
    int numberCachesLastYear = 0;

    public Statistics(Statistics e) {

    }

    @Override
    public Statistics clone() {
        return new Statistics(this);
    }
}
