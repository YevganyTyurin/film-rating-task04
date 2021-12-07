package by.epam.film.rating.task04.dao.entity.film;

public enum CountryOfOrigin {
    POLAND (1),
    GERMANY (2),
    USA (3);

    int id;

    CountryOfOrigin (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static CountryOfOrigin getCountryOfOrigin (int id) {
        for (CountryOfOrigin country: CountryOfOrigin.values()) {
            if (country.id == id) {
                return country;
            }
        }
        return null;
    }
}
