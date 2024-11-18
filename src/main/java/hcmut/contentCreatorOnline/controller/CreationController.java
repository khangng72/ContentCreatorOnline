package hcmut.contentCreatorOnline.controller;


import hcmut.contentCreatorOnline.dto.CreationDTO.CreationHigestDTO;
import hcmut.contentCreatorOnline.model.Creation;
import hcmut.contentCreatorOnline.service.impl.CreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creation")
public class CreationController {
    @Autowired
    private CreationService creationService;

    @GetMapping("/all")
    public List<Creation> getAllCreation(){
        return creationService.getAllCreation();
    }

    @GetMapping("/top")
    public List<CreationHigestDTO> getBooksHighestPoint(@RequestParam Integer top){
        return creationService.getBooksHighestPoint(top);
    }
}
