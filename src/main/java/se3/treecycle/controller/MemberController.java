package se3.treecycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se3.treecycle.dto.ResponseDto;
import se3.treecycle.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/tree/{member_id}")
    public ResponseDto readTreeInfo(@PathVariable Long member_id) {
        return ResponseDto.success("성공", memberService.getTreeInfo(member_id));
    }

    @GetMapping("member/nickname/{member_id}")
    public ResponseDto readNickname(@PathVariable Long member_id) {
        return ResponseDto.success("성공", memberService.getNickname(member_id));
    }
}
