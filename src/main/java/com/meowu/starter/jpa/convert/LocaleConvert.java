package com.meowu.starter.jpa.convert;

import com.meowu.starter.entity.enums.Locale;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocaleConvert extends StringEnumConvert<Locale>{

    @Override
    public Class<Locale> getType(){
        return Locale.class;
    }
}
