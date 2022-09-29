package dxc.ocbc.dto;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDto {
    private Long id;
    private String name;
}
