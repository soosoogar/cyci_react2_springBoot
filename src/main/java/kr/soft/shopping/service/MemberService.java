package kr.soft.shopping.service;

import kr.soft.shopping.dto.member.MemberInfoDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import kr.soft.shopping.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public void register(MemberRegisterDTO memberRegisterDTO){
        memberMapper.register(memberRegisterDTO);
    }

    public void login(MemberInfoDTO memberInfoDTO){
        memberMapper.login(memberInfoDTO);
    }

}
