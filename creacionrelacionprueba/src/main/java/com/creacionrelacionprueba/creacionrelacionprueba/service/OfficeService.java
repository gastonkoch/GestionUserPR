package com.creacionrelacionprueba.creacionrelacionprueba.service;

import com.creacionrelacionprueba.creacionrelacionprueba.domain.Office;
import com.creacionrelacionprueba.creacionrelacionprueba.repository.OfficeRepository;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.OfficeDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OfficeService implements IOfficeService{
    
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<OfficeDTO> getOffices() {
        return officeRepository.findAll().stream()
                .map(office -> OfficeDTO.builder()
                                        .officeId(office.getOfficeId())
                                        .officeBuilding(office.getOfficeBuilding())
                                        .officeRoomNumber(office.getOfficeRoomNumber())
                                        .build()
                    ).toList();
    }

    @Override
    public OfficeDTO getOfficeById(Long officeId) {
        return officeRepository.findById(officeId)
                .map(office -> OfficeDTO.builder()
                                .officeId(office.getOfficeId())
                                .officeBuilding(office.getOfficeBuilding())
                                .officeRoomNumber(office.getOfficeRoomNumber())
                                .build()
                ).orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "Office with id " + officeId + " not found"
                ));
    
    }

    @Override
    public void saveOffice(OfficeDTO office) {
        officeRepository.save(Office.builder()
                                    .officeBuilding(office.getOfficeBuilding())
                                    .officeRoomNumber(office.getOfficeRoomNumber())
                                    .build());
    }

    @Override
    public void deleteOffice(Long officeId) {
        officeRepository.deleteById(officeId);
    }

    @Override
    public void updateOffice(OfficeDTO office) {
        officeRepository.findById(office.getOfficeId())
                .map(existing -> officeRepository.save(Office.builder()
                                .officeId(office.getOfficeId())
                                .officeBuilding(office.getOfficeBuilding())
                                .officeRoomNumber(office.getOfficeRoomNumber())
                                .build())
                ).orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "Office with id " + office.getOfficeId() + " not found"
                ));
    }
}
