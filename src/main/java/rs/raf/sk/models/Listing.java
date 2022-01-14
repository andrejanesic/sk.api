package rs.raf.sk.models;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
public class Listing {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idlisting")
    private int idlisting;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "startdate")
    private Date startdate;
    @Basic
    @Column(name = "enddate")
    private Date enddate;
    @Basic
    @Column(name = "room_idroom")
    private int roomIdroom;
    @Basic
    @Column(name = "roomtype_idroomtype")
    private int roomtypeIdroomtype;

    public int getIdlisting() {
        return idlisting;
    }

    public void setIdlisting(int idlisting) {
        this.idlisting = idlisting;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getRoomIdroom() {
        return roomIdroom;
    }

    public void setRoomIdroom(int roomIdroom) {
        this.roomIdroom = roomIdroom;
    }

    public int getRoomtypeIdroomtype() {
        return roomtypeIdroomtype;
    }

    public void setRoomtypeIdroomtype(int roomtypeIdroomtype) {
        this.roomtypeIdroomtype = roomtypeIdroomtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        if (idlisting != listing.idlisting) return false;
        if (roomIdroom != listing.roomIdroom) return false;
        if (roomtypeIdroomtype != listing.roomtypeIdroomtype) return false;
        if (city != null ? !city.equals(listing.city) : listing.city != null) return false;
        if (startdate != null ? !startdate.equals(listing.startdate) : listing.startdate != null) return false;
        if (enddate != null ? !enddate.equals(listing.enddate) : listing.enddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idlisting;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + roomIdroom;
        result = 31 * result + roomtypeIdroomtype;
        return result;
    }
}
