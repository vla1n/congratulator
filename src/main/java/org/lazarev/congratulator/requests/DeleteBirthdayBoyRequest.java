package org.lazarev.congratulator.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Сущность запроса на удаление именинника */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeleteBirthdayBoyRequest {

    /** Идентификатор именинника */
    private long birthdayBoyId;
}
