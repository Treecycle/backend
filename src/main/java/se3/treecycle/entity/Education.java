package se3.treecycle.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Education {
    @Id
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String video;
}
