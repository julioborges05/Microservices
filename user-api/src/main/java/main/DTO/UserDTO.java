package main.DTO;

import java.util.Date;

public class UserDTO {

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String telephone;
    private Date registrationDate;

    public UserDTO() {
    }

    public UserDTO(String name, String cpf, String address, String email, String telephone, Date registrationDate) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
