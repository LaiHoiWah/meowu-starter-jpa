package com.meowu.starter.jpa.convert;

import com.meowu.starter.entity.enums.StringEnum;
import com.meowu.starter.entity.utils.StringEnumReflectUtils;
import jakarta.persistence.AttributeConverter;

import java.util.Objects;

public abstract class StringEnumConvert<T extends Enum<T> & StringEnum<T>> implements AttributeConverter<T, String>{

    public abstract Class<T> getType();

    @Override
    public String convertToDatabaseColumn(T obj){
        return Objects.isNull(obj) ? null : obj.getCode();
    }

    @Override
    public T convertToEntityAttribute(String str){
        return StringEnumReflectUtils.getByCode(getType(), str);
    }
}
