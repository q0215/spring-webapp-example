package q9029.app.spring.controller.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupFormBean extends FormBean {

    @Pattern(regexp = "[a-zA-Z0-9]*", message = "{q9029.animaps.Pattern.message}")
    @Size(min = 6, max = 20, message = "{q9029.animaps.Size.message}")
    private String id;

    private String name;

    private String password;

    private boolean status;

    private int role;

    public SignupFormBean(String view) {
        super(view);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
