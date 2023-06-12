package se3.treecycle.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column
    private int day;
    @Column
    private int treeCount;
    @Column
    private int treeGrowth;

    public void updateDay() {
        this.day++;
    }

    public void updateTreecount() {
        this.treeCount++;
    }

    public void updateTreegrowth(int treeGrowth) {
        this.treeGrowth += treeGrowth;
    }
}
