package dxc.ocbc.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
