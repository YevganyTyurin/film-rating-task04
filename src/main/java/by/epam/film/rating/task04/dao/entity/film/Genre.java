package by.epam.film.rating.task04.dao.entity.film;

public enum Genre {
    COMEDY (1),
    DRAMA (2),
    WESTERN (3);

    int id;

    Genre (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Genre getGenre (int id) {
        for (Genre genre: Genre.values()) {
            if (genre.id == id) {
                return genre;
            }
        }
        return null;
    }
}
