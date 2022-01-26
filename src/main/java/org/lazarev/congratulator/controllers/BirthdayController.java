package org.lazarev.congratulator.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.lazarev.congratulator.entities.BirthdayBoyEntity;
import org.lazarev.congratulator.requests.AddBirthdayBoyRequest;
import org.lazarev.congratulator.requests.ChangeBirthdayBoyRequest;
import org.lazarev.congratulator.requests.DeleteBirthdayBoyRequest;
import org.lazarev.congratulator.services.BirthdayService;
import org.lazarev.congratulator.views.BirthdayBoyView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("bithdays")
public class BirthdayController {

    private final BirthdayService birthdayService;

    @GetMapping("/{userId}")
    @Operation(summary = "Получение списка именинников конкретного пользователя по его имени")
    public List<BirthdayBoyView> getBirthdayListByUserName(
            @Parameter(description = "Идентификатор пользователя")
            @PathVariable long userId) {
        return birthdayService.getBirthdayListByUserName(userId);
    }

    @GetMapping("/{userId}/{period}")
    @Operation(summary = "Получение списка именинников за ближайшее время")
    public List<BirthdayBoyView> getBirthdayForNearestPeriod(
            @Parameter(description = "Идентификатор пользователя")
            @PathVariable long userId,
            @Parameter(description = "Период, в днях")
            @PathVariable int period) {
        return birthdayService.getBirthdayForNearestPeriod(userId, period);
    }

    @PostMapping("/add")
    @Operation(summary = "Добавление именинника в список пользователя")
    public BirthdayBoyView addBirthdayBoy(@RequestBody AddBirthdayBoyRequest request) {
        return birthdayService.addBirthdayBoy(request);
    }

    @PostMapping("/change")
    @Operation(summary = "Изменение информации об именинника в список пользователя")
    public void changeBirthdayBoy(@RequestBody ChangeBirthdayBoyRequest request) {
        birthdayService.changeBirthdayBoy(request);
    }

    @PostMapping("/delete")
    @Operation(summary = "Удаление именинника из списка пользователя")
    public void deleteBirthdayBoy(@RequestBody DeleteBirthdayBoyRequest request) {
        birthdayService.deleteBirthdayBoy(request);
    }


}
