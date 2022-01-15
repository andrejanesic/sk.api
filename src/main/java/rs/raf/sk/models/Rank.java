package rs.raf.sk.models;

import javax.persistence.*;

@Table
@Entity
public class Rank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrank")
    private int idrank;
    @Basic
    @Column(name = "name")
    private String name;
    // ONLY "less" OR "more"
    @Basic
    @Column(name = "criteria")
    private String criteria;
    @Basic
    @Column(name = "value")
    private String value;
    @Basic
    @Column(name = "discount")
    private int discount;

    public int getIdrank() {
        return idrank;
    }

    public void setIdrank(int idrank) {
        this.idrank = idrank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rank rank = (Rank) o;

        if (idrank != rank.idrank) return false;
        if (discount != rank.discount) return false;
        if (name != null ? !name.equals(rank.name) : rank.name != null) return false;
        if (criteria != null ? !criteria.equals(rank.criteria) : rank.criteria != null) return false;
        if (value != null ? !value.equals(rank.value) : rank.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrank;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (criteria != null ? criteria.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + discount;
        return result;
    }
}
