package org.lazarev.congratulator.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Сущность запроса на изменения информации об имениннике*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangeBirthdayBoyRequest {

    /** Идентификатор именинника */
    private long birthdayBoyId;

    /** Имя именинника */
    private String name;

    /** День рождения */
    private int day;

    /** Месяц рождения */
    private int month;
}
