package com.meowu.starter.jpa.convert;

import com.meowu.starter.entity.enums.AccountStatus;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AccountStatusConvert extends StringEnumConvert<AccountStatus>{

    @Override
    public Class<AccountStatus> getType(){
        return AccountStatus.class;
    }
}
