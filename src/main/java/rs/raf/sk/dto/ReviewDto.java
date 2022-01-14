package rs.raf.sk.dto;

public class ReviewDto extends AbstractDto<Integer> {

    private int idreview;
    private int rating;
    private String comment;
    private int userIduser;
    private int hotelIdhotel;

    public ReviewDto() {
    }

    public void setIdreview(int idreview) {
        this.idreview = idreview;
    }

    public int getIdreview() {
        return this.idreview;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    public int getUserIduser() {
        return this.userIduser;
    }

    public void setHotelIdhotel(int hotelIdhotel) {
        this.hotelIdhotel = hotelIdhotel;
    }

    public int getHotelIdhotel() {
        return this.hotelIdhotel;
    }
}