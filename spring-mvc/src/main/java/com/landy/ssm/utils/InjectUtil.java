package com.landy.ssm.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个通用的类型转换器：

 用来转换形如：

 firstName=jack&lastName=lily&gender=1&foods=Steak&foods=Pizza&quote=Enter+your+favorite+quote!&education=Jr.High&tOfD=Day 到 Student 对象。
 * @author landyl
 * @create 11:01 AM 07/18/2018
 */
public class InjectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(InjectUtil.class);

    public static <T> T convert2Obj(String source, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();
            Map<String, Object> params = new HashMap<>();
            if(source != null && source.length() > 0) {
                String[] fields = source.split("&");
                for(String field : fields) {
                    String[] fieldKeyValue = field.split("\\=");
                    String fieldKey = fieldKeyValue[0];
                    String fieldValue = fieldKeyValue[1];
                    if (params.containsKey(fieldKey)) {
                        Object keyValueRetrieved = params.get(fieldKey);
                        if (keyValueRetrieved instanceof String) {
                            ArrayList<String> values = new ArrayList<>();
                            values.add(keyValueRetrieved.toString());
                            values.add(fieldValue);
                            params.put(fieldKey, values);
                        } else {
                            ((ArrayList<String>) keyValueRetrieved).add(fieldValue);
                        }
                    } else {
                        params.put(fieldKey, fieldValue);
                    }
                }
            }
            BeanUtils.populate(t, params);
        } catch(InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            LOGGER.error("String convert to Bean failure!", e);
        }
        return t;
    }

}
