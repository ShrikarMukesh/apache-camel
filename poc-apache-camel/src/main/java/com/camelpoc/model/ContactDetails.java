package com.camelpoc.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactDetails {
    private String phoneNumber;
    private String email;
    private String emergencyContact;
}
