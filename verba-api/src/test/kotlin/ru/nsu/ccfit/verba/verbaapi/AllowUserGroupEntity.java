package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "allow_user_group", schema = "verba", catalog = "db")
public class AllowUserGroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user", nullable = false)
    private int user;
    @Basic
    @Column(name = "group", nullable = false)
    private int group;
    @Basic
    @Column(name = "access_read", nullable = false)
    private boolean accessRead;
    @Basic
    @Column(name = "access_changes", nullable = false)
    private boolean accessChanges;
    @Basic
    @Column(name = "tactic", nullable = false)
    private int tactic;

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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public boolean isAccessRead() {
        return accessRead;
    }

    public void setAccessRead(boolean accessRead) {
        this.accessRead = accessRead;
    }

    public boolean isAccessChanges() {
        return accessChanges;
    }

    public void setAccessChanges(boolean accessChanges) {
        this.accessChanges = accessChanges;
    }

    public int getTactic() {
        return tactic;
    }

    public void setTactic(int tactic) {
        this.tactic = tactic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllowUserGroupEntity that = (AllowUserGroupEntity) o;

        if (id != that.id) return false;
        if (user != that.user) return false;
        if (group != that.group) return false;
        if (accessRead != that.accessRead) return false;
        if (accessChanges != that.accessChanges) return false;
        if (tactic != that.tactic) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user;
        result = 31 * result + group;
        result = 31 * result + (accessRead ? 1 : 0);
        result = 31 * result + (accessChanges ? 1 : 0);
        result = 31 * result + tactic;
        return result;
    }
}
