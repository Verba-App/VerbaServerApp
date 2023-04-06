package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "card", schema = "verba", catalog = "db")
public class CardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "createTime", nullable = false)
    private Timestamp createTime;
    @Basic
    @Column(name = "repetitionTime", nullable = false)
    private Timestamp repetitionTime;
    @Basic
    @Column(name = "catalog", nullable = false)
    private int catalog;
    @Basic
    @Column(name = "word", nullable = false)
    private int word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getRepetitionTime() {
        return repetitionTime;
    }

    public void setRepetitionTime(Timestamp repetitionTime) {
        this.repetitionTime = repetitionTime;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
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

        CardEntity that = (CardEntity) o;

        if (id != that.id) return false;
        if (catalog != that.catalog) return false;
        if (word != that.word) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (repetitionTime != null ? !repetitionTime.equals(that.repetitionTime) : that.repetitionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (repetitionTime != null ? repetitionTime.hashCode() : 0);
        result = 31 * result + catalog;
        result = 31 * result + word;
        return result;
    }
}
