package com.bea.springbootmysql.controller;

import com.bea.springbootmysql.controller.request.SignUpRequest;
import com.bea.springbootmysql.controller.request.UpdateNicknameRequest;
import com.bea.springbootmysql.controller.response.MemberResponse;
import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import com.bea.springbootmysql.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {

    private MemberService memberService;

    @GetMapping
    public List<MemberResponse> getAll() {
        return memberService.findMembers()
                .stream()
                .map(member -> new MemberResponse(member))
                .toList();
    }

    @GetMapping
    public List<MemberResponse> getMembers(@RequestParam Grade grade) {
        return memberService.findMembers(grade)
                .stream()
                .map(member -> new MemberResponse(member))
                .toList();
    }

    @GetMapping
    public List<MemberResponse> getMembers(@RequestParam String name) {
        return memberService.findMembers(name)
                .stream()
                .map(member -> new MemberResponse(member))
                .toList();
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        Member member = memberService.findMember(id);
        return new MemberResponse(member);
    }

    @PostMapping
    public void signUp(@RequestBody SignUpRequest request) {
        Member member = request.convertToMember();
        memberService.signUp(member);
    }

    @PatchMapping("/{id}/nickname")
    public void updateNickname(@PathVariable Long id, @RequestBody UpdateNicknameRequest request) {
        memberService.changeNickname(id, request.getNickname());
    }
}
