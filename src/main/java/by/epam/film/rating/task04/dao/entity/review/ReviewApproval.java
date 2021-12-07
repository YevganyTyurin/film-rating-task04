package by.epam.film.rating.task04.dao.entity.review;

import by.epam.film.rating.task04.dao.entity.user.User;

public class ReviewApproval {
//    private int userId;
//    private int reviewId;
    private boolean isLiked;
//    private Review review;
//    private User user;


    public ReviewApproval(boolean isLiked) {
        this.isLiked = isLiked;
    }
}
