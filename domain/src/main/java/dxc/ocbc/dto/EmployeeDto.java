package dxc.ocbc.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeDto {
    private  Long id;
    private String name;
    private String email;
    private String address;
    private Integer age;

    private Long companyId;
}
