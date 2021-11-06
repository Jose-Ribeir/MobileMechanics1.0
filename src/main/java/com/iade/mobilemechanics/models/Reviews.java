package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Integer id;

    @Column(name = "review_comment", length = 420)
    private String reviewComment;

    @Column(name = "review_stars")
    private Integer reviewStars;

    @Column(name = "review_client_id")
    private Integer reviewClientId;

    @Column(name = "review_repair_id")
    private Integer reviewRepairId;

    public Integer getReviewRepairId() {
        return reviewRepairId;
    }

    public void setReviewRepairId(Integer reviewRepairId) {
        this.reviewRepairId = reviewRepairId;
    }

    public Integer getReviewClientId() {
        return reviewClientId;
    }

    public void setReviewClientId(Integer reviewClientId) {
        this.reviewClientId = reviewClientId;
    }

    public Integer getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(Integer reviewStars) {
        this.reviewStars = reviewStars;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public Integer getId() {
        return id;
    }

}
