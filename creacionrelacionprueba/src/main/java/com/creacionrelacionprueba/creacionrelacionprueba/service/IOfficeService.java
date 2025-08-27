package com.creacionrelacionprueba.creacionrelacionprueba.service;

import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.OfficeDTO;
import java.util.List;

public interface IOfficeService {
    public List<OfficeDTO> getOffices();
    public OfficeDTO getOfficeById(Long officeId);
    public void saveOffice(OfficeDTO office);
    public void deleteOffice(Long officeId);
    public void updateOffice(OfficeDTO office);    
}
