package com.camelpoc.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private Date birthDate;
    private Address address;
    private ContactDetails contactDetails;
    private Education education;
    private Job job;

}
