package se3.treecycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se3.treecycle.dto.QuizResultDto;
import se3.treecycle.dto.ResponseDto;
import se3.treecycle.service.StarService;

@RestController
@RequiredArgsConstructor
public class StarController {
    private final StarService starService;
    @PostMapping("/star/{member_id}/{edu_id}")
    public ResponseDto createStar(@PathVariable Long member_id, @PathVariable Long edu_id, @RequestBody QuizResultDto quizResultDto) {
        return ResponseDto.success("성공", starService.saveStarResult(member_id, edu_id, quizResultDto));
    }
}
