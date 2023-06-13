package se3.treecycle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se3.treecycle.dto.TreeInfoDto;
import se3.treecycle.entity.Member;
import se3.treecycle.repository.MemberRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public TreeInfoDto getTreeInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return new TreeInfoDto(member.getTreeCount(), member.getTreeGrowth());
    }

    public String getNickname(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return member.getNickname();
    }
}
