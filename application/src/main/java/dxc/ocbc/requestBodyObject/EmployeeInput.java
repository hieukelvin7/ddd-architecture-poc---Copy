package dxc.ocbc.requestBodyObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInput {
    private String name;
    private String email;
    private String address;
    private Integer age;
    private Long companyId;
}
