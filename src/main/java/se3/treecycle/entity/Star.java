package se3.treecycle.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Star {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    @ManyToOne
    @JoinColumn(name = "edu_id", nullable = false)
    private Education education;

    @Column
    private int starCount;

    @Builder
    public Star(Member member, Education education, int starCount) {
        this.member = member;
        this.education = education;
        this.starCount = starCount;
    }
}
