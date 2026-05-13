package io.phuongnt.demo.webEntity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class RegisterUser {

    @NotBlank(message = "Please type your username")
    @Size(min=1, message="Minium is one character")
    private String username;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$",
            message = "The Password has to contain low Character, Upper Character and Special Character in at least 8 characters"
    )
    private String password;

    @NotBlank(message = "Please type your lastname")
    private String lastname;

    @NotBlank(message = "Please type your firstname")
    private String firstname;

    @NotBlank(message ="The Information is needed")
    @Email(message="Invalid Email")
    private String email;


    // Contructor...........................

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, boolean enable, String lastname, String firstname, String email) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    // Getter AND Setter.............................

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
