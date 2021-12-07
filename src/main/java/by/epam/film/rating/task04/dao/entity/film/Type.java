package by.epam.film.rating.task04.dao.entity.film;

public enum Type {
    FILM (1),
    SERIAL (2);

    int id;

    Type (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Type getType (int id) {
        for (Type type: Type.values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}
