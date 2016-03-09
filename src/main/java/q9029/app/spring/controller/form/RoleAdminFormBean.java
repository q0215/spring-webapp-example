package q9029.app.spring.controller.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public final class RoleAdminFormBean extends FormBean {

    @Pattern(regexp = "[a-zA-Z0-9]*", message = "{q9029.animaps.Pattern.message}")
    @Size(min = 6, max = 20, message = "{q9029.animaps.Size.message}")
    private String encode;

    private String hash;

    public RoleAdminFormBean(String view) {
        super(view);
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
