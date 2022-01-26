package org.lazarev.congratulator.mappers;

import org.lazarev.congratulator.entities.BirthdayBoyEntity;
import org.lazarev.congratulator.models.BirthdayBoyModel;
import org.lazarev.congratulator.views.BirthdayBoyView;

public class Mapper {

    public static BirthdayBoyEntity modelToBirthdayBoyEntity(BirthdayBoyModel model){
        return new BirthdayBoyEntity(model.getName(), model.getDay(), model.getMonth());
    }

    public static BirthdayBoyView entityToBirthdayBoyView(BirthdayBoyEntity birthdayBoyEntity){
        return new BirthdayBoyView(birthdayBoyEntity.getId(),
                birthdayBoyEntity.getName(),
                birthdayBoyEntity.getDay(),
                birthdayBoyEntity.getMonth());
    }
}
