package by.epam.film.rating.task04.dao.entity.film;

import java.util.Objects;

public class Trailer {
    private int id;
    private String trailerVideo;

    public Trailer(int id, String trailerVideo) {
        this.id = id;
        this.trailerVideo = trailerVideo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrailerVideo() {
        return trailerVideo;
    }

    public void setTrailerVideo(String trailerVideo) {
        this.trailerVideo = trailerVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trailer)) return false;
        Trailer trailer = (Trailer) o;
        return getId() == trailer.getId() && getTrailerVideo().equals(trailer.getTrailerVideo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTrailerVideo());
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "id=" + id +
                ", trailerVideo='" + trailerVideo + '\'' +
                '}';
    }
}
