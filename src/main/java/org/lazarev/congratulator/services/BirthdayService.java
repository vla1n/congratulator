package org.lazarev.congratulator.services;

import lombok.RequiredArgsConstructor;
import org.lazarev.congratulator.entities.BirthdayBoyEntity;
import org.lazarev.congratulator.entities.UserEntity;
import org.lazarev.congratulator.mappers.Mapper;
import org.lazarev.congratulator.repositories.BirthdayBoyRepository;
import org.lazarev.congratulator.requests.AddBirthdayBoyRequest;
import org.lazarev.congratulator.requests.ChangeBirthdayBoyRequest;
import org.lazarev.congratulator.requests.DeleteBirthdayBoyRequest;
import org.lazarev.congratulator.views.BirthdayBoyView;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BirthdayService {

    private final BirthdayBoyRepository birthdayBoyRepository;

    /**
     * Получение списка именинников конкретного пользователя по его имени
     */
    public List<BirthdayBoyView> getBirthdayListByUserName(long userId) {
        return birthdayBoyRepository.findAllByUserId(userId).stream().map(Mapper::entityToBirthdayBoyView).collect(Collectors.toList());
    }

    /**
     * Получение списка именинников за ближайшее время
     *
     * @param period в днях
     */
    public List<BirthdayBoyView> getBirthdayForNearestPeriod(long userId, int period) {
        return getBirthdayListByUserName(userId).stream()
                .filter(f -> checkIncludeDateInPeriod(f.getMonth(), f.getDay(), period))
                .collect(Collectors.toList());
    }

    /**
     * Добавление именинника в список пользователя
     */
    public BirthdayBoyView addBirthdayBoy(AddBirthdayBoyRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(request.getUserId());
        return Mapper.entityToBirthdayBoyView(birthdayBoyRepository.save(new BirthdayBoyEntity(request.getName(), request.getDay(), request.getMonth(), userEntity)));
    }

    /**
     * Изменение информации об имениннике в список пользователя
     */
    public void changeBirthdayBoy(ChangeBirthdayBoyRequest request) {
        birthdayBoyRepository.updateBirthdayBoy(request.getName(), request.getDay(), request.getMonth(), request.getBirthdayBoyId());
    }

    /**
     * Удаление именинника из списка пользователя
     */
    public void deleteBirthdayBoy(DeleteBirthdayBoyRequest request) {
        birthdayBoyRepository.deleteById(request.getBirthdayBoyId());
    }

    /**
     * Проверка входит ли дата в указаный период
     *
     * @param period в днях
     */
    private boolean checkIncludeDateInPeriod(int month, int day, int period) {
        long birthdayDate = new Date(getCurrentDateWithoutTime().getYear(), month - 1, day).getTime() / 1000;
        long dateWithPeriod = getTimestampWithPeriod(period) / 1000;
        long currentDate = getCurrentDateWithoutTime().getTime() / 1000;
        return (dateWithPeriod >= birthdayDate) && (birthdayDate >= currentDate);
    }

    /**
     * Получение даты через несколько дней, в милисекундах
     *
     * @param period в днях
     */
    private long getTimestampWithPeriod(int period) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, period);
        return new Date(getCurrentDateWithoutTime().getYear(), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).getTime();
    }

    /**
     * Получение текущей даты без времени, в милисекундах
     */
    private Date getCurrentDateWithoutTime() {
        Date date = new Date();
        date.setSeconds(0);
        date.setHours(0);
        date.setMinutes(0);
        return date;
    }

}
