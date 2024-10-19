package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;
import java.util.UUID;

class CreateUserResult {
    private UUID user_id;
    private String first_name;
    private String last_name;
    private String gender;
    private String user_password;
    private LocalDate birthday;
    private String nationality;
    private String email;
    private boolean is_admin;

    public CreateUserResult() {
    }

    public CreateUserResult(UUID user_id, String first_name, String last_name, String gender, String user_password,
            LocalDate birthday, String nationality, String email, boolean is_admin) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.user_password = user_password;
        this.birthday = birthday;
        this.nationality = nationality;
        this.email = email;
        this.is_admin = is_admin;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
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

public class CreateUserResponse {
    private int status;
    private CreateUserResult result;
    private String message;

    public CreateUserResponse(int status, CreateUserResult result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public CreateUserResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CreateUserResult getResult() {
        return result;
    }

    public void setResult(CreateUserResult result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
