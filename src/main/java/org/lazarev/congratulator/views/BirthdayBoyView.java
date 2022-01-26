package org.lazarev.congratulator.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Модель для отображения сущности именинника */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BirthdayBoyView {

    /** Идентификатор именинника */
    private long id;

    /** Имя именинника */
    private String name;

    /** День рождения именинника */
    private int day;

    /** Месяц рождения именинника */
    private int month;
}
