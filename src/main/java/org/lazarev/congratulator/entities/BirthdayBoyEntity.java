package org.lazarev.congratulator.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/** Сущность, которая описывает именинников */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "birthdayBoy")
public class BirthdayBoyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Имя именинника */
    private String name;

    /** День рождения именинника */
    private int day;

    /** Месяц рождения именинника */
    private int month;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public BirthdayBoyEntity(String name, int day, int month) {
        this.name = name;
        this.day = day;
        this.month = month;
    }


    public BirthdayBoyEntity(String name, int day, int month, UserEntity user) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.user = user;
    }
}
