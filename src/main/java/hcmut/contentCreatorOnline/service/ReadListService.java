package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.readList.ReadListDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.repository.ReadListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReadListService {

    private final ReadListRepository readListRepository;

    public List<ReadListDTO> getReadListByUserId(UUID userId) {
        try {
            if (userId == null) {
                throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "userId cannot be null");
            }

            return readListRepository.findAllByUserCreated_Id(userId).stream().map(
                    readList -> new ReadListDTO(
                            readList.getReadListId(),
                            readList.getReadListTitle(),
                            readList.getDescription(),
                            readList.getStories().size(),
                            readList.getUserCreated().getId()
                    )).toList();

        } catch (IllegalArgumentException e) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "userId cannot be null");
        }

    }
}
