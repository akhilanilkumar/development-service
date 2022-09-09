package com.development.developmentservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "development")
@Getter
@Setter
public class Development implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Column(name = "budget")
    private Double budget;

    @Column(name = "state")
    private String state;

    @Column(name = "activity_month")
    private int activityMonth;

    @Column(name = "activity_year")
    private int activityYear;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "development_id", referencedColumnName = "id")
    private Set<Activity> activities;
}