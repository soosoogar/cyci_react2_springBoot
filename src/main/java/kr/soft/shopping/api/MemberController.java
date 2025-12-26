package kr.soft.shopping.api;

import kr.soft.shopping.dto.member.MemberInfoDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import kr.soft.shopping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public void Register(@RequestBody MemberRegisterDTO memberRegisterDTO){
        memberService.register(memberRegisterDTO);
    }

    @PostMapping("/login")
    public void Login(@RequestBody MemberInfoDTO memberInfoDTO){
        memberService.login(memberInfoDTO);
    }
}
