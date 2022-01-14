package rs.raf.sk.models;

import javax.persistence.*;

@Table
@Entity
public class Roomtype {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idroomtype")
    private int idroomtype;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "dailyprice")
    private int dailyprice;
    @Basic
    @Column(name = "count")
    private int count;
    @Basic
    @Column(name = "hotel_idhotel")
    private int hotelIdhotel;

    public int getIdroomtype() {
        return idroomtype;
    }

    public void setIdroomtype(int idroomtype) {
        this.idroomtype = idroomtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDailyprice() {
        return dailyprice;
    }

    public void setDailyprice(int dailyprice) {
        this.dailyprice = dailyprice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getHotelIdhotel() {
        return hotelIdhotel;
    }

    public void setHotelIdhotel(int hotelIdhotel) {
        this.hotelIdhotel = hotelIdhotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roomtype roomtype = (Roomtype) o;

        if (idroomtype != roomtype.idroomtype) return false;
        if (dailyprice != roomtype.dailyprice) return false;
        if (count != roomtype.count) return false;
        if (hotelIdhotel != roomtype.hotelIdhotel) return false;
        if (name != null ? !name.equals(roomtype.name) : roomtype.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idroomtype;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + dailyprice;
        result = 31 * result + count;
        result = 31 * result + hotelIdhotel;
        return result;
    }
}
