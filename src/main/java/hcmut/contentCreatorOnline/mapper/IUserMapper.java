package hcmut.contentCreatorOnline.mapper;

import java.util.List;

import hcmut.contentCreatorOnline.model.CCO_User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserAccountDto toUserAccountDto(CCO_User entity);

    CCO_User toUserAccount(UserAccountDto dto);

    List<UserAccountDto> toListUserAccountDto(List<CCO_User> list);

    List<CCO_User> toListUserAccount(List<UserAccountDto> dtos);
}
