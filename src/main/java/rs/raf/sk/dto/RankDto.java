package rs.raf.sk.dto;

public class RankDto extends AbstractDto<Integer> {

    private int idrank;
    private String name;
    private String criteria;
    private String value;
    private int discount;

    public RankDto() {
    }

    public void setIdrank(int idrank) {
        this.idrank = idrank;
    }

    public int getIdrank() {
        return this.idrank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getCriteria() {
        return this.criteria;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }
}