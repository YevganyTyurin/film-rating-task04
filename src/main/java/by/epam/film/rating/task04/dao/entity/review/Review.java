package by.epam.film.rating.task04.dao.entity.review;

import java.util.List;

public class Review {
    private int id;
    private String review;
    private int mark;
    private int likesAmount;
    private int dislikesAmount;
//    private User user;
//    private Film film;

//    private int filmId;
//    private int userId;
    private List<ReviewApproval> reviewApproval;

    public Review(int id, String review, int mark, int likesAmount,
                  int dislikesAmount, List<ReviewApproval> reviewApproval) {
        this.id = id;
        this.review = review;
        this.mark = mark;
        this.likesAmount = likesAmount;
        this.dislikesAmount = dislikesAmount;
//        this.filmId = filmId;
//        this.userId = userId;
        this.reviewApproval = reviewApproval;
    }


}
