package rs.raf.sk.models;

import javax.persistence.*;

@Table
@Entity
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idreview")
    private int idreview;
    @Basic
    @Column(name = "rating")
    private int rating;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "user_iduser")
    private int userIduser;
    @Basic
    @Column(name = "hotel_idhotel")
    private int hotelIdhotel;

    public int getIdreview() {
        return idreview;
    }

    public void setIdreview(int idreview) {
        this.idreview = idreview;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
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

        Review review = (Review) o;

        if (idreview != review.idreview) return false;
        if (rating != review.rating) return false;
        if (userIduser != review.userIduser) return false;
        if (hotelIdhotel != review.hotelIdhotel) return false;
        if (comment != null ? !comment.equals(review.comment) : review.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idreview;
        result = 31 * result + rating;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + userIduser;
        result = 31 * result + hotelIdhotel;
        return result;
    }
}
