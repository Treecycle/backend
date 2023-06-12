package se3.treecycle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EdusInfoDto {
    private int day;
    private List<EduInfoDto> eduInfoDtoList;
}
