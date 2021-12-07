package by.epam.film.rating.task04.dao.entity.film;

import by.epam.film.rating.task04.dao.entity.user.Role;

public enum AgeRating {
    R6 (1),
    R12 (2),
    R14 (3),
    R16 (4),
    R18 (5);

    int id;

    AgeRating (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AgeRating getAgeRating (int id) {
        for (AgeRating ageRating: AgeRating.values()) {
            if (ageRating.id == id) {
                return ageRating;
            }
        }
        return null;
    }
}
