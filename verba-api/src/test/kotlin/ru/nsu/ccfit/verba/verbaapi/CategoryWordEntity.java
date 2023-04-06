package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "category_word", schema = "verba", catalog = "db")
public class CategoryWordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "category", nullable = false)
    private int category;
    @Basic
    @Column(name = "word", nullable = false)
    private int word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryWordEntity that = (CategoryWordEntity) o;

        if (id != that.id) return false;
        if (category != that.category) return false;
        if (word != that.word) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + category;
        result = 31 * result + word;
        return result;
    }
}
