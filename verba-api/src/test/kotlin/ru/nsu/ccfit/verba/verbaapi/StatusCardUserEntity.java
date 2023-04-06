package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "status_card_user", schema = "verba", catalog = "db")
public class StatusCardUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user", nullable = false)
    private int user;
    @Basic
    @Column(name = "card", nullable = false)
    private int card;
    @Basic
    @Column(name = "repeat", nullable = false)
    private Timestamp repeat;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public Timestamp getRepeat() {
        return repeat;
    }

    public void setRepeat(Timestamp repeat) {
        this.repeat = repeat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusCardUserEntity that = (StatusCardUserEntity) o;

        if (id != that.id) return false;
        if (user != that.user) return false;
        if (card != that.card) return false;
        if (status != that.status) return false;
        if (repeat != null ? !repeat.equals(that.repeat) : that.repeat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user;
        result = 31 * result + card;
        result = 31 * result + (repeat != null ? repeat.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
