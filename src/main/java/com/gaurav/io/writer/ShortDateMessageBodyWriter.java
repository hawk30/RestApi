package com.gaurav.io.writer;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by oracle on 10/12/16.
 */
@Provider
@Produces("text/shortDate")
public class ShortDateMessageBodyWriter implements MessageBodyWriter<Date> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Date.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        String shortDate= Calendar.getInstance().DAY_OF_MONTH+ "-"+ Calendar.getInstance().MONTH+ "-"+ Calendar.getInstance().YEAR;
        entityStream.write(shortDate.getBytes());
    }
}
