package org.lazarev.congratulator.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Сущность запроса для добавление именинника в списк пользователя */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBirthdayBoyRequest {

    /** Идентификатор пользователя */
    private long userId;

    /** Имя именинника */
    private String name;

    /** День рождения */
    private int day;

    /** Месяц рождения */
    private int month;
}
