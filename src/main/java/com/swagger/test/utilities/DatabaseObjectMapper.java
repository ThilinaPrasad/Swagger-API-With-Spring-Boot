package com.swagger.test.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseObjectMapper {

    // API to DB method
    public <A, D> D apiToDb(A apiObject, D dbObject) throws IllegalAccessException {

        // temp hash map for hold property values
        Map<String, Object> tempValues = new HashMap<String, Object>();

        // Get declared fields in objects
        Field[] dbFields = dbObject.getClass().getDeclaredFields();
        Field[] apiFields = apiObject.getClass().getDeclaredFields();

        for(Field field: apiFields){
            field.setAccessible(true);
            JsonProperty annotation = field.getAnnotation(JsonProperty.class);
            if(annotation!=null){
                tempValues.put(annotation.value(),field.get(apiObject));
            }
        }

        for (Field field: dbFields){
            field.setAccessible(true);
            Column annotation = field.getDeclaredAnnotation(Column.class);
            if(annotation!=null){
                Object value = tempValues.get(annotation.name());
                if(value!=null){
                    if (field.getType() == Boolean.class) {
                        field.set(dbObject, value.toString());
                    } else if (field.getType() == String.class) {
                        field.set(dbObject, String.valueOf(value));
                    } else if (value.getClass() == Integer.class) {
                        field.set(dbObject, Integer.toString((int) value));
                    }
                    else {
                        field.set(dbObject, value);
                    }
                }

            }
        }

        return dbObject;
    }

    // DB to API Method
    public <A, D> A dbToApi(A apiObject, D dbObject) throws IllegalAccessException {

        // temp hash map for hold property values
        Map<String, Object> tempValues = new HashMap<String, Object>();

        // Get declared fields in objects
        Field[] dbFields = dbObject.getClass().getDeclaredFields();
        Field[] apiFields = apiObject.getClass().getDeclaredFields();

        // Retrive entities object values
            for (Field field : dbFields) {
                field.setAccessible(true);
                Column annotation = field.getAnnotation(Column.class);
                if (annotation != null) {
                    tempValues.put(annotation.name(), field.get(dbObject));

                }
            }

        // Set values to api object
        for(Field field: apiFields){
            field.setAccessible(true);
            JsonProperty annotation = field.getDeclaredAnnotation(JsonProperty.class);
            if(annotation!=null){
                Object value = tempValues.get(annotation.value());
                if(value!=null){
                    if (field.getType() == Boolean.class && value.getClass() == String.class) {
                        field.set(apiObject, value.equals("1"));
                    } else if (field.getType() == String.class && value.getClass() == Boolean.class) {
                        field.set(apiObject, String.valueOf(value));
                    } else if (value.getClass() == Integer.class && field.getType() == String.class) {
                        field.set(apiObject, Integer.toString((int) value));
                    }
                     else {
                        field.set(apiObject, value);
                    }
                }

            }
        }
        return apiObject;
    }

}
