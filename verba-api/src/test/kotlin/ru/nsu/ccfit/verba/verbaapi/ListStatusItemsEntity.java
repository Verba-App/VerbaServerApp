package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "list_status_items", schema = "verba", catalog = "db")
public class ListStatusItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "order", nullable = false)
    private int order;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "days", nullable = false)
    private int days;
    @Basic
    @Column(name = "tactic", nullable = false)
    private int tactic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

        ListStatusItemsEntity that = (ListStatusItemsEntity) o;

        if (id != that.id) return false;
        if (order != that.order) return false;
        if (status != that.status) return false;
        if (days != that.days) return false;
        if (tactic != that.tactic) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + order;
        result = 31 * result + status;
        result = 31 * result + days;
        result = 31 * result + tactic;
        return result;
    }
}
