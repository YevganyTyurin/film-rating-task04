package by.epam.film.rating.task04.dao.builder;

import by.epam.film.rating.task04.dao.entity.film.*;
import by.epam.film.rating.task04.dao.entity.review.Review;
import by.epam.film.rating.task04.dao.entity.review.ReviewApproval;
import by.epam.film.rating.task04.dao.entity.user.Role;
import by.epam.film.rating.task04.dao.entity.user.Status;
import by.epam.film.rating.task04.dao.entity.user.User;
import by.epam.film.rating.task04.dao.tableColumnName.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InstanceBuilder {


    public User buildUser(ResultSet resultSet) throws SQLException {
        resultSet.next();
        int id = resultSet.getInt(UserTableColumnName.ID);
        String login = resultSet.getString(UserTableColumnName.LOGIN);
        String password = resultSet.getString(UserTableColumnName.PASSWORD);
        String nickname = resultSet.getString(UserTableColumnName.NICKNAME);
        String name = resultSet.getString(UserTableColumnName.NAME);
        String surname = resultSet.getString(UserTableColumnName.SURNAME);
        String phoneNumber = resultSet.getString(UserTableColumnName.PHONE_NUMBER);
        String eMail = resultSet.getString(UserTableColumnName.E_MAIL);
        boolean isBanned = resultSet.getBoolean(UserTableColumnName.IS_BANNED);
        double rating = resultSet.getDouble(UserTableColumnName.RATING);
        String avatarImage = resultSet.getString(UserTableColumnName.AVATAR_IMAGE);
        Role role = Role.getRole(resultSet.getInt(UserTableColumnName.ROLE_ID));
        Status status = Status.getStatus((resultSet.getInt(UserTableColumnName.STATUS_ID)));
        return new User(id, login, password, nickname, name, surname,
                phoneNumber, eMail, isBanned, rating, avatarImage, role, status);
    }

    public Review buildReview(ResultSet resultSet, List<ReviewApproval> reviewApprovals) throws SQLException {
        resultSet.next();
        int id = resultSet.getInt(ReviewTableColumnName.ID);
        String review = resultSet.getString(ReviewTableColumnName.REVIEW);
        int mark = resultSet.getInt(ReviewTableColumnName.MARK);
        int likesAmount = resultSet.getInt(ReviewTableColumnName.LIKES_AMOUNT);
        int dislikesAmount = resultSet.getInt(ReviewTableColumnName.DISLIKES_AMOUNT);
        return new Review(id, review, mark, likesAmount, dislikesAmount, reviewApprovals);
    }

    public ReviewApproval buildReviewApproval(ResultSet resultSet) throws SQLException {
        resultSet.next();
        boolean isLiked = resultSet.getBoolean(ReviewApprovalTableColumnName.IS_LIKED);
        return new ReviewApproval(isLiked);
    }

    public Trailer buildTrailer(ResultSet resultSet) throws SQLException {
        resultSet.next();
        int id = resultSet.getInt(TrailerTableColumnName.ID);
        String trailerImage = resultSet.getString(TrailerTableColumnName.TRAILER_VIDEO);
        return new Trailer(id, trailerImage);
    }

    public Poster buildPoster(ResultSet resultSet) throws SQLException {
        resultSet.next();
        int id = resultSet.getInt(PosterTableColumnName.ID);
        String posterImage = resultSet.getString(PosterTableColumnName.POSTER_IMAGE);
        return new Poster(id, posterImage);
    }

    public Film buildFilm(ResultSet resultSet, List<Trailer> trailers, List<Poster> posters,
                          List<Genre> genres, List<CountryOfOrigin> countryOfOrigin) throws SQLException {
        resultSet.next();

        int id = resultSet.getInt(FilmTableColumnName.ID);
        int productionYear = resultSet.getInt(FilmTableColumnName.PRODUCTION_YEAR);
        String name = resultSet.getString(FilmTableColumnName.NAME);
        String description = resultSet.getString(FilmTableColumnName.DESCRIPTION);
        double filmRating = resultSet.getDouble(FilmTableColumnName.FILM_RATING);
        int reviewAmount = resultSet.getInt(FilmTableColumnName.REVIEW_AMOUNT);
        Type type = Type.getType(resultSet.getInt(FilmTableColumnName.TYPE_ID));
        AgeRating ageRating = AgeRating.getAgeRating(resultSet.getInt(FilmTableColumnName.AGE_RATING));

        return new Film(id, productionYear, name, description, filmRating, reviewAmount,
                type, ageRating, genres, countryOfOrigin, posters, trailers);
    }






}
