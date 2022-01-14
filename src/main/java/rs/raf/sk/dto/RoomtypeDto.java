package rs.raf.sk.dto;

public class RoomtypeDto extends AbstractDto<Integer> {

    private int idroomtype;
    private String name;
    private int dailyprice;
    private int count;
    private int hotelIdhotel;

    public RoomtypeDto() {
    }

    public void setIdroomtype(int idroomtype) {
        this.idroomtype = idroomtype;
    }

    public int getIdroomtype() {
        return this.idroomtype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDailyprice(int dailyprice) {
        this.dailyprice = dailyprice;
    }

    public int getDailyprice() {
        return this.dailyprice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void setHotelIdhotel(int hotelIdhotel) {
        this.hotelIdhotel = hotelIdhotel;
    }

    public int getHotelIdhotel() {
        return this.hotelIdhotel;
    }
}