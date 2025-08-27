package com.creacionrelacionprueba.creacionrelacionprueba.controller;

import com.creacionrelacionprueba.creacionrelacionprueba.repository.OfficeRepository;
import com.creacionrelacionprueba.creacionrelacionprueba.service.OfficeService;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.OfficeDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private OfficeService officeService;
    
    @GetMapping("/getOffices")
    public ResponseEntity<List<OfficeDTO>> getOffices(){
        return ResponseEntity.ok(officeService.getOffices());
    }
    
    @GetMapping("/getOfficeById/{officeId}")
    public ResponseEntity<OfficeDTO> getOfficeById(@PathVariable Long officeId){
        return ResponseEntity.ok(officeService.getOfficeById(officeId));
    }
    
    @PostMapping("/saveOffice")
    public ResponseEntity<String> saveOffice(@RequestBody OfficeDTO office){
        officeService.saveOffice(office);
        return ResponseEntity.ok("La oficina fue creada de manera exitosa");
    }
    
    @DeleteMapping("/deleteOffice/{officeId}")
    public ResponseEntity<String> deleteOffice(@PathVariable Long officeId){
        officeService.deleteOffice(officeId);
        return ResponseEntity.ok("La oficina fue eliminada");
    }
    
    @PutMapping("/updateOffice")
    public ResponseEntity<String> updateOffice(@RequestBody OfficeDTO office){
        officeService.updateOffice(office);
        return ResponseEntity.ok("La oficina fue modificada");
    }
}
