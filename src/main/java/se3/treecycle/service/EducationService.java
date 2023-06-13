package se3.treecycle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se3.treecycle.dto.EduInfoDto;
import se3.treecycle.dto.EduVideoDto;
import se3.treecycle.dto.EdusInfoDto;
import se3.treecycle.entity.Education;
import se3.treecycle.entity.Member;
import se3.treecycle.repository.EducationRepository;
import se3.treecycle.repository.MemberRepository;
import se3.treecycle.repository.StarRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository educationRepository;
    private final MemberRepository memberRepository;
    private final StarRepository starRepository;

    public EdusInfoDto getEdusInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        int day = member.getDay();
        List<EduInfoDto> eduInfoDtoList = new ArrayList<>();
        List<Education> educations = educationRepository.findAll();
        for (Education edu: educations) {
            boolean locked = true;
            int starCount;
            if(starRepository.findByMemberAndEducation(member, edu).isEmpty()) {
                starCount = 0;
            }
            else {
                starCount = starRepository.findByMemberAndEducation(member, edu).get().getStarCount();
            }
            if (edu.getId() > day) {
                locked = false;
            }
            EduInfoDto eduInfoDto = new EduInfoDto(locked, edu.getTitle(), edu.getContent(), starCount);
            eduInfoDtoList.add(eduInfoDto);
        }
        return new EdusInfoDto(day, eduInfoDtoList);
    }

    public EduVideoDto getEduVideo(Long eduId) {
        String video = educationRepository.findById(eduId).orElseThrow().getVideo();
        return new EduVideoDto(video);
    }
}
