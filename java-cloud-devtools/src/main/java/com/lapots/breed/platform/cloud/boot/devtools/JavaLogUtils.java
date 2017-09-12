package com.lapots.breed.platform.cloud.boot.devtools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaLogUtils {

    public static Logger getLogger() {
        final Throwable t = new Throwable();
        t.fillInStackTrace();
        String clazz = t.getStackTrace()[1].getClassName();
        return LoggerFactory.getLogger(clazz);
    }

}
