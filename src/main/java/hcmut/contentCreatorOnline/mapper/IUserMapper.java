package hcmut.contentCreatorOnline.mapper;

import java.util.List;

import hcmut.contentCreatorOnline.dto.user.CCOUserDTO;
import hcmut.contentCreatorOnline.model.CCO_User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    CCOUserDTO toUserAccountDto(CCO_User entity);

    CCO_User toUserAccount(CCOUserDTO dto);

    List<CCOUserDTO> toListUserAccountDto(List<CCO_User> list);

    List<CCO_User> toListUserAccount(List<CCOUserDTO> dtos);
}
