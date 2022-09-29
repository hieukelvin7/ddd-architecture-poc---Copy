package dxc.ocbc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String address;
    private Integer age;

    private Long companyId;
}
