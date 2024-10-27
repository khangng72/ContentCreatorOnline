package hcmut.contentCreatorOnline.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.model.User.UserAccount;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserAccountDto toUserAccountDto(UserAccount entity);

    UserAccount toUserAccount(UserAccountDto dto);

    List<UserAccountDto> toListUserAccountDto(List<UserAccount> list);

    List<UserAccount> toListUserAccount(List<UserAccountDto> dtos);
}
