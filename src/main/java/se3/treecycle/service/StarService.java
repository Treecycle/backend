package se3.treecycle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se3.treecycle.dto.QuizResultDto;
import se3.treecycle.dto.TreeInfoDto;
import se3.treecycle.entity.Education;
import se3.treecycle.entity.Member;
import se3.treecycle.entity.Star;
import se3.treecycle.repository.EducationRepository;
import se3.treecycle.repository.MemberRepository;
import se3.treecycle.repository.StarRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StarService {
    private final StarRepository starRepository;
    private final MemberRepository memberRepository;
    private final EducationRepository educationRepository;

    public TreeInfoDto saveStarResult(Long memberId, Long eduId, QuizResultDto quizResultDto) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        if(educationRepository.findById(eduId).isPresent()) {
            Education education = educationRepository.findById(eduId).orElseThrow();
            Star star = Star.builder()
                    .member(member)
                    .education(education)
                    .starCount(quizResultDto.getStarCount())
                    .build();
            starRepository.save(star);
        }

        int growth = quizResultDto.getStarCount() * 5;
        int treeGrowth = member.getTreeGrowth() + growth;

        if(treeGrowth >= 100) {
            member.updateTreecount();
            member.updateTreegrowth(treeGrowth % 100);
        }
        else {
            member.updateTreegrowth(treeGrowth);
        }

        return new TreeInfoDto(member.getTreeCount(), member.getTreeGrowth());
    }
}
