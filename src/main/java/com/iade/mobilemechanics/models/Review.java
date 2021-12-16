package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Integer id;

    @Column(name = "review_comment", length = 420)
    private String reviewComment;

    @Column(name = "review_stars")
    private Integer reviewStars;

    @ManyToOne
    @JoinColumn(name = "review_client_id")
    private Client reviewClient;

    @ManyToOne
    @JoinColumn(name = "review_repair_id")
    private Repair reviewRepair;

    public Repair getReviewRepair() {
        return reviewRepair;
    }

    public void setReviewRepair(Repair reviewRepair) {
        this.reviewRepair = reviewRepair;
    }

    public Client getReviewClient() {
        return reviewClient;
    }

    public void setReviewClient(Client reviewClient) {
        this.reviewClient = reviewClient;
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

    public void setId(Integer id) {
        this.id = id;
    }
}
