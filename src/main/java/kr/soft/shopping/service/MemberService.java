package kr.soft.shopping.service;

import kr.soft.shopping.dto.member.MemberAuthDTO;
import kr.soft.shopping.dto.member.MemberLoginDTO;
import kr.soft.shopping.dto.member.MemberLoginIdxDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import kr.soft.shopping.mapper.AuthMapper;
import kr.soft.shopping.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private AuthMapper authMapper;

    public void register(MemberRegisterDTO dto) {
        memberMapper.register(dto);
    }

    public String login(MemberLoginDTO dto) {
        MemberLoginIdxDTO resultDTO = memberMapper.login(dto.getUserId());
        if(resultDTO == null || !resultDTO.getUserPw().equals(dto.getUserPw())) {
            return null;
        }

        //로그인이 성공이 되었을 때. 허가증을 만들어보자
        String text = "apple_"+dto.getUserId();

        //user_idx?
        resultDTO.getUserIdx();
        MemberAuthDTO authDTO = new MemberAuthDTO();
        authDTO.setUserIdx(resultDTO.getUserIdx()); //user Idx
        authDTO.setAuthName(text); //허가 증

        authMapper.regist(authDTO);

        return text;
    }
}