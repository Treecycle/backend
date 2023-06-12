package se3.treecycle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EduInfoDto {
    private Boolean locked;
    private String title;
    private String content;
    private int starCount;
}
