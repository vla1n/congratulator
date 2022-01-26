package org.lazarev.congratulator.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lazarev.congratulator.models.BirthdayBoyModel;

import java.util.List;

/** Сущность запроса для создание пользователя */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateUserRequest {

    /** Имя пользователя */
    private String username;

    /** Список именинников */
    private List<BirthdayBoyModel> friends;
}
