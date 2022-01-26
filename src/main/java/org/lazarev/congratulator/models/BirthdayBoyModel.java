package org.lazarev.congratulator.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Модель именинника */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BirthdayBoyModel {

    /** Имя именинника */
    private String name;

    /** День рождения именинника */
    private int day;

    /** Месяц рождения именинника */
    private int month;

}
