package rs.raf.sk.dto;

public class HotelDto extends AbstractDto<Integer> {

    private int idhotel;
    private String name;
    private String description;

    public HotelDto() {
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public int getIdhotel() {
        return this.idhotel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}