package by.epam.film.rating.task04.dao.entity.film;

import java.util.Objects;

public class Poster {
    private int id;
    private String posterImage;

    public Poster(int id, String posterImage) {
        this.id = id;
        this.posterImage = posterImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poster)) return false;
        Poster poster = (Poster) o;
        return getId() == poster.getId() && getPosterImage().equals(poster.getPosterImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosterImage());
    }

    @Override
    public String toString() {
        return "Poster{" +
                "id=" + id +
                ", posterImage='" + posterImage + '\'' +
                '}';
    }
}
