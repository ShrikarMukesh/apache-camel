package com.camelpoc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankAccount {

    private String accountNumber;
    private double balance;
    private List<Card> cards;
    private List<LinkedParty> linkedParties;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cards = new ArrayList<>();
        this.linkedParties = new ArrayList<>();
    }

    // Additional methods to add/remove cards and linked parties
    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public void addLinkedParty(LinkedParty linkedParty) {
        this.linkedParties.add(linkedParty);
    }

    public void removeLinkedParty(LinkedParty linkedParty) {
        this.linkedParties.remove(linkedParty);
    }
}


