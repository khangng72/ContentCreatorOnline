package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.CreationDTO.CreationDTO;
import hcmut.contentCreatorOnline.dto.CreationDTO.CreationHigestDTO;
import hcmut.contentCreatorOnline.dto.user.CCOUserDTO;
import hcmut.contentCreatorOnline.model.Creation;
import hcmut.contentCreatorOnline.repository.creation.CreationRepoEntityManager;
import hcmut.contentCreatorOnline.repository.creation.CreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CreationService {

    @Autowired
    private CreationRepository creationRepository;

    @Autowired
    private CreationRepoEntityManager creationRepoEntityManager;

    public List<Creation> getAllCreation(){
        List<Creation> listCreation = creationRepository.findAll();
        return listCreation;
    }

    public List<CreationHigestDTO> getBooksHighestPoint(Integer top){
        List<CreationHigestDTO> creationDTOArrayList = new ArrayList<>();
        for (Object[] row : creationRepoEntityManager.getBooksHighestPoint(top)) {
            CreationHigestDTO creationHigestDTO = new CreationHigestDTO();

            creationHigestDTO.setCreationName((String) row[0]);
            creationHigestDTO.setDescription((String) row[1]);
            creationHigestDTO.setNumberOfDislikes((int) row[2]);
            creationHigestDTO.setNumberOfLikes((int) row[3]);
            creationHigestDTO.setPenName((String) row[4]);

            creationDTOArrayList.add(creationHigestDTO);
        }
        return creationDTOArrayList;
    }
}
