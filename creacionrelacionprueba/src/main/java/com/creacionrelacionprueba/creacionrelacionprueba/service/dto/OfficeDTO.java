package com.creacionrelacionprueba.creacionrelacionprueba.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficeDTO {
    private Long officeId;
    private String officeBuilding;
    private Integer officeRoomNumber;
}
