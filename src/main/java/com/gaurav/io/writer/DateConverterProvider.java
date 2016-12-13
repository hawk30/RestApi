package com.gaurav.io.writer;

import com.gaurav.io.model.MyDate;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * Created by oracle on 8/12/16.
 */
@Provider
public class DateConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.getName().equals(MyDate.class.getName())) {
            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    Calendar cal= Calendar.getInstance();
                    if("tomorrow".equalsIgnoreCase(value))
                        cal.add(Calendar.DATE,1);
                    else if("yesterday".equalsIgnoreCase(value))
                        cal.add(Calendar.DATE,-1);
                    else
                        cal.add(Calendar.DATE,0);

                    MyDate myDate= new MyDate();
                    myDate.setDate(cal.get(Calendar.DATE));
                    myDate.setMonth(cal.get(Calendar.MONTH));
                    myDate.setYear(cal.get(Calendar.YEAR));
                    return rawType.cast(myDate);
                }

                @Override
                public String toString(T value) {
                    if(value==null)
                        return null;
                    return value.toString();
                }
            };
        }
        return null;
    }
}
