package com.gen.api.member.web;


import com.gen.api.dto.MemberRequestDto;
import com.gen.api.dto.MemberUpdateRequestDto;
import com.gen.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberApiController {


    private final MemberService service;


    @PostMapping("/member")
    public void postMember(@Valid @RequestBody MemberRequestDto dto) throws Exception {

        service.insMember(dto);
    }

    @PatchMapping("/member/{id}")
    public void patchMember(@PathVariable String id, @Valid @RequestBody MemberUpdateRequestDto dto) throws Exception {

        service.updMember(id,dto);
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable String id) throws Exception  {

        service.delMember(id);
    }

}
