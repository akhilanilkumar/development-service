package com.development.developmentservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "development")
@Getter
@Setter
public class Development {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "leader_id")
    private Long leaderId;

    @Column(name = "party_id")
    private Long partyId;

    @Column(name = "title")
    private String title;

    @Column(name = "activity")
    private String activity;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "state")
    private String state;

    @Column(name = "activity_month")
    private int activityMonth;

    @Column(name = "activity_year")
    private int activityYear;
}

enum ActivityMonth {
    JAN(1),
    FEB(2),
    MAR(3),
    APR(4),
    MAY(5),
    JUN(6),
    JUL(7),
    AUG(8),
    SEPT(9),
    OCT(10),
    NOV(11),
    DEC(12);

    private final int month;

    ActivityMonth(int month) {
        this.month = month;
    }
}