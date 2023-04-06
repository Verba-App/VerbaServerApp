package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "photo_card", schema = "verba", catalog = "db")
public class PhotoCardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "photo", nullable = false)
    private int photo;
    @Basic
    @Column(name = "card", nullable = false)
    private int card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoCardEntity that = (PhotoCardEntity) o;

        if (id != that.id) return false;
        if (photo != that.photo) return false;
        if (card != that.card) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + photo;
        result = 31 * result + card;
        return result;
    }
}
