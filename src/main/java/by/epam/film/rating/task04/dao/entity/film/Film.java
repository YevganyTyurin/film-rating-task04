package by.epam.film.rating.task04.dao.entity.film;

import java.util.List;

public class Film {
    private int id;
    private int productionYear;
    private String name;
    private String description;
    private double filmRating;
    private int reviewAmount;
    private Type type;
    private AgeRating ageRating;
    private List<Genre> genre;
    private List<CountryOfOrigin> countryOfOrigin;
    private List<Poster> poster;
    private List<Trailer> trailer;

    public Film(int id, int productionYear, String name, String description,
                double filmRating, int reviewAmount, Type type, AgeRating ageRating,
                List<Genre> genre, List<CountryOfOrigin> countryOfOrigin,
                List<Poster> poster, List<Trailer> trailer) {
        this.id = id;
        this.productionYear = productionYear;
        this.name = name;
        this.description = description;
        this.filmRating = filmRating;
        this.reviewAmount = reviewAmount;
        this.type = type;
        this.ageRating = ageRating;
        this.genre = genre;
        this.countryOfOrigin = countryOfOrigin;
        this.poster = poster;
        this.trailer = trailer;
    }
}
