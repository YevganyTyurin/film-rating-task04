package by.epam.film.rating.task04.dao.entity.user;

public class User {
    private int id;
    private String login;
    private String password;
    private String nickname;
    private String name;
    private String surname;
    private String phoneNumber;
    private String eMail;
    private boolean isBanned;
    private double rating;
    private String avatarImage;
    private Role role;
    private Status status;

    public User() {};

    public User(int id, String login, String password, String nickname, String name, String surname,
                String phoneNumber, String eMail, boolean isBanned, double rating, String avatarImage,
                Role role, Status status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.isBanned = isBanned;
        this.rating = rating;
        this.avatarImage = avatarImage;
        this.role = role;
        this.status = status;
    }


}
