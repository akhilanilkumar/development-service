package com.development.developmentservice.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
public class DevelopmentDTO implements Serializable {
    private Long id;

    @NotNull
    private Long leaderId;

    private Long partyId;

    @NotNull
    @Length(min = 5, max = 100, message = "Title length should be with in 5 to 100 characters!")
    private String title;

    private Set<ActivityDTO> activities;

    @Digits(integer = 999999999, fraction = 2, message = "Budget is a number in max 2 decimal points!")
    private Double budget;

    @NotNull
    @Length(min = 5, max = 100, message = "State length should be with in 3 to 50 characters!")
    private String state;

    @Digits(integer = 2027, fraction = 0, message = "Activity month is a number and in the range of 1 to 12")
    @Min(1)
    @Max(12)
    private int activityMonth;

    @Digits(integer = 2027, fraction = 0)
    @Min(2022)
    @Max(2027)
    private int activityYear;
}
