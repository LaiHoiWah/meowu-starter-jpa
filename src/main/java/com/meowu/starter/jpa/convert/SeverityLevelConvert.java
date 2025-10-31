package com.meowu.starter.jpa.convert;

import com.meowu.starter.entity.enums.SeverityLevel;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SeverityLevelConvert extends StringEnumConvert<SeverityLevel>{

    @Override
    public Class<SeverityLevel> getType(){
        return SeverityLevel.class;
    }
}
