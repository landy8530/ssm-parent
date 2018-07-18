package com.landy.ssm.controller.converter;

import com.landy.ssm.domain.Student;
import com.landy.ssm.utils.InjectUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author landyl
 * @create 11:00 AM 07/18/2018
 */
@Component(value = "string2StudentConverter")
public class String2StudentConverter implements Converter<String,Student> {
    @Override
    public Student convert(String source) {
        return InjectUtil.convert2Obj(source, Student.class);
    }
}
