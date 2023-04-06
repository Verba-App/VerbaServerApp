package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "file_resources", schema = "verba", catalog = "db")
public class FileResourcesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "resources", nullable = false)
    private int resources;
    @Basic
    @Column(name = "path", nullable = false, length = 255)
    private String path;
    @Basic
    @Column(name = "type", nullable = false)
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileResourcesEntity that = (FileResourcesEntity) o;

        if (id != that.id) return false;
        if (resources != that.resources) return false;
        if (type != that.type) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + resources;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }
}
