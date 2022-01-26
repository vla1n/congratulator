package org.lazarev.congratulator.repositories;

import org.lazarev.congratulator.entities.BirthdayBoyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BirthdayBoyRepository extends JpaRepository<BirthdayBoyEntity, Long> {

    List<BirthdayBoyEntity> findAllByUserId(long id);

    @Modifying
    @Transactional
    @Query("update BirthdayBoyEntity b set b.name = :name, b.day = :day, b.month = :month where b.id = :birthdayBoyId")
    void updateBirthdayBoy(@Param("name") String name,
                           @Param("day") int day,
                           @Param("month") int month,
                           @Param("birthdayBoyId") long birthdayBoyId);
}
