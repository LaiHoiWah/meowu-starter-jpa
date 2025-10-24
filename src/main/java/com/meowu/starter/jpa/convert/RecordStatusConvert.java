package com.meowu.starter.jpa.convert;

import com.meowu.starter.entity.enums.RecordStatus;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RecordStatusConvert extends StringEnumConvert<RecordStatus>{

    @Override
    public Class<RecordStatus> getType(){
        return RecordStatus.class;
    }
}
