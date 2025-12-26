package kr.soft.shopping.mapper;

import kr.soft.shopping.dto.member.MemberInfoDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void register(MemberRegisterDTO memberRegisterDTO);
    void login(MemberInfoDTO memberInfoDTO);
}
