package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;

public class CreateUserRequest {
    private String first_name;
    private String last_name;
    private String gender;
    private String user_password;
    private LocalDate birthday;
    private String nationality;
    private String email;
    private boolean is_admin;

    // currently missing address

    public CreateUserRequest() {
    }

    public CreateUserRequest(String first_name, String last_name, String gender, String user_password,
            LocalDate birthday, String nationality, String email, boolean is_admin) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.user_password = user_password;
        this.birthday = birthday;
        this.nationality = nationality;
        this.email = email;
        this.is_admin = is_admin;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
