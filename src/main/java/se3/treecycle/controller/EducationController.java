package se3.treecycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se3.treecycle.dto.ResponseDto;
import se3.treecycle.service.EducationService;

@RestController
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping("/edu/{member_id}")
    public ResponseDto readEduInfo(@PathVariable Long member_id) {
        return ResponseDto.success("성공", educationService.getEdusInfo(member_id));
    }

    @GetMapping("/edu/video/{edu_id}")
    public ResponseDto readEduVideo(@PathVariable Long edu_id) {
        return ResponseDto.success("성공", educationService.getEduVideo(edu_id));
    }
}
