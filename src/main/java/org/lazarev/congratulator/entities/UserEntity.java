package org.lazarev.congratulator.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/** Сущность, которая описывает пользователя */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Имя пользователя */
    private String username;

    /** Список именинников */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BirthdayBoyEntity> friends;

    public UserEntity(String username, List<BirthdayBoyEntity> friends) {
        this.username = username;
        this.friends = friends;
    }
}
