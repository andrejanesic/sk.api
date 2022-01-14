package rs.raf.sk.dto;

import java.sql.Date;

public class UserDto extends AbstractDto<Integer> {

    private int iduser;
    private String username;
    private String password;
    private String email;
    private Object type;
    private String phone;
    private Date birthdate;
    private String firstname;
    private String lastname;
    private String passport;
    private Date hiredate;
    private Integer hotelIdhotel;

    public UserDto() {
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIduser() {
        return this.iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getType() {
        return this.type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setBirthdate(java.sql.Date birthdate) {
        this.birthdate = birthdate;
    }

    public java.sql.Date getBirthdate() {
        return this.birthdate;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setHiredate(java.sql.Date hiredate) {
        this.hiredate = hiredate;
    }

    public java.sql.Date getHiredate() {
        return this.hiredate;
    }

    public void setHotelIdhotel(Integer hotelIdhotel) {
        this.hotelIdhotel = hotelIdhotel;
    }

    public Integer getHotelIdhotel() {
        return this.hotelIdhotel;
    }
}