package kr.soft.shopping.mapper;

import kr.soft.shopping.dto.member.MemberAuthDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    void regist(MemberAuthDTO dto);

    MemberAuthDTO searchKey(String authName);
}
