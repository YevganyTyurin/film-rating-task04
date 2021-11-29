package by.epam.film.rating.task04.dao.entity;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String nickname;
    private String name;
    private String patronymicName;
    private String surname;
    private String phone_number;
    private String eMail;
    private boolean isBanned;
    private double rating;

    public User() {};

    public User(int id, String login, String password, String nickname, String name,
                String patronymicName, String surname, String phone_number, String eMail, boolean isBanned, double rating) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.surname = surname;
        this.phone_number = phone_number;
        this.eMail = eMail;
        this.isBanned = isBanned;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && isBanned() == user.isBanned() && Double.compare(user.getRating(), getRating()) == 0 && getLogin().equals(user.getLogin()) && getPassword().equals(user.getPassword()) && getNickname().equals(user.getNickname()) && getName().equals(user.getName()) && getPatronymicName().equals(user.getPatronymicName()) && getSurname().equals(user.getSurname()) && getPhone_number().equals(user.getPhone_number()) && geteMail().equals(user.geteMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getNickname(), getName(), getPatronymicName(), getSurname(), getPhone_number(), geteMail(), isBanned(), getRating());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", eMail='" + eMail + '\'' +
                ", isBanned=" + isBanned +
                ", rating=" + rating +
                '}';
    }
}
