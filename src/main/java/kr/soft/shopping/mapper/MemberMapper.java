package kr.soft.shopping.mapper;

import kr.soft.shopping.dto.member.MemberLoginIdxDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void register(MemberRegisterDTO dto);

    MemberLoginIdxDTO login(String userId);
}
