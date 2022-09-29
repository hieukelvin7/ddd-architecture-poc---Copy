package dxc.ocbc.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDto {

    private Long id;

    private String role;

    private String workName;

    private String status;

    private String action;

    public BasketDto() {
    }

    public BasketDto(Long id, String role, String workName, String status, String action) {
        this.id = id;
        this.role = role;
        this.workName = workName;
        this.status = status;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
