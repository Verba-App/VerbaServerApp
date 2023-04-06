package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "photo_file", schema = "verba", catalog = "db")
public class PhotoFileEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "file", nullable = false)
    private int file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoFileEntity that = (PhotoFileEntity) o;

        if (id != that.id) return false;
        if (file != that.file) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + file;
        return result;
    }
}
