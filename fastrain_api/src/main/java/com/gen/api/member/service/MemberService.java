package com.gen.api.member.service;

import com.gen.api.dto.MemberRequestDto;
import com.gen.api.dto.MemberUpdateRequestDto;
import com.gen.api.entity.Member;
import com.gen.api.entity.repository.MemberRepository;
import com.gen.api.exception.AlreadyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {


    private final MemberRepository memberRepository;


    public void insMember(MemberRequestDto dto) throws Exception {

        Member member = memberRepository.findById(dto.getId()).orElse(null);
        if(member == null) {
            memberRepository.save(dto.toEntity());
        } else {
            throw new AlreadyException();
        }

    }

    @Transactional
    public void updMember(String id, MemberUpdateRequestDto dto) throws Exception{
        Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        member.update(dto.getPassword());
    }
    @Transactional
    public void delMember(String id) throws Exception{
        
        memberRepository.deleteById(id);

    }


}
