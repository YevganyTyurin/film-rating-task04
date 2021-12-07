package by.epam.film.rating.task04.dao.entity.user;

public enum Status {
    NEWBIE(1),
    MASTER(2),
    GRANDMASTER(3);

    int id;

    Status(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Status getStatus (int id) {
        for (Status status: Status.values()) {
            if (status.id == id) {
                return status;
            }
        }
        return null;
    }
}
