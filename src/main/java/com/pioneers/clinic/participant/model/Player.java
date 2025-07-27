package com.pioneers.clinic.participant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;
    private int age;
    private int physicalSkillScore;
    private int technicalSkillScore;
    private int tacticalSkillScore;
    private int behaviouralSkillScore;
    private String comment;

    public Player() {
    }

    public Player(long id, String firstname, String lastname, int age, int physicalSkillScore, int technicalSkillScore, int tacticalSkillScore, int behaviouralSkillScore, String comment) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.physicalSkillScore = physicalSkillScore;
        this.technicalSkillScore = technicalSkillScore;
        this.tacticalSkillScore = tacticalSkillScore;
        this.behaviouralSkillScore = behaviouralSkillScore;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhysicalSkillScore() {
        return physicalSkillScore;
    }

    public void setPhysicalSkillScore(int physicalSkillScore) {
        this.physicalSkillScore = physicalSkillScore;
    }

    public int getTechnicalSkillScore() {
        return technicalSkillScore;
    }

    public void setTechnicalSkillScore(int technicalSkillScore) {
        this.technicalSkillScore = technicalSkillScore;
    }

    public int getTacticalSkillScore() {
        return tacticalSkillScore;
    }

    public void setTacticalSkillScore(int tacticalSkillScore) {
        this.tacticalSkillScore = tacticalSkillScore;
    }

    public int getBehaviouralSkillScore() {
        return behaviouralSkillScore;
    }

    public void setBehaviouralSkillScore(int behaviouralSkillScore) {
        this.behaviouralSkillScore = behaviouralSkillScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", physicalSkillScore=" + physicalSkillScore +
                ", technicalSkillScore=" + technicalSkillScore +
                ", tacticalSkillScore=" + tacticalSkillScore +
                ", behaviouralSkillScore=" + behaviouralSkillScore +
                ", comment='" + comment + '\'' +
                '}';
    }
}
