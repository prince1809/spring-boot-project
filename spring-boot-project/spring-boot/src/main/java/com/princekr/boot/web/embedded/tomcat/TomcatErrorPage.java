package com.princekr.boot.web.embedded.tomcat;

import com.princekr.boot.web.server.ErrorPage;
import org.apache.catalina.Context;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Tomcat specific management for an {@link ErrorPage}.
 */

public class TomcatErrorPage {

    private static final String ERROR_PAGE_CLASS = "org.apache.tomcat.util.descriptor.web.ErrorPage";

    private final String location;

    private final String exceptionType;

    private final int errorCode;

    private final Object nativePage;

    TomcatErrorPage(ErrorPage errorPage) {
        this.location = errorPage.getPath();
        this.exceptionType = errorPage.getExceptionName();
        this.errorCode = errorPage.getStatusCode();
        this.nativePage = createNativePage(errorPage);
    }

    private Object createNativePage(ErrorPage errorPage) {
        try {
            if (ClassUtils.isPresent(ERROR_PAGE_CLASS, null)) {
                return BeanUtils.instantiateClass(ClassUtils.forName(ERROR_PAGE_CLASS, null));
            }
        } catch (ClassNotFoundException | LinkageError ex) {
            // swallow and continue
        }
        return null;
    }

    public void addContext(Context context) {
        Assert.state(this.nativePage != null, "No Tomcat 8 detected so no native error page exists");
        if (ClassUtils.isPresent(ERROR_PAGE_CLASS, null)) {
            org.apache.tomcat.util.descriptor.web.ErrorPage errorPage = (org.apache.tomcat.util.descriptor.web.ErrorPage) this.nativePage;
            errorPage.setLocation(this.location);
            errorPage.setErrorCode(this.errorCode);
            errorPage.setExceptionType(this.exceptionType);
            context.addErrorPage(errorPage);
        } else {
            callMethod(this.nativePage, "setLocation", this.location, String.class);
            callMethod(this.nativePage, "setErrorCode", this.errorCode, int.class);
            callMethod(this.nativePage, "setExceptionType", this.exceptionType, String.class);
            callMethod(context, "addErrorPage", this.nativePage, this.nativePage.getClass());
        }
    }

    private void callMethod(Object target, String name, Object value, Class<?> type) {
        Method method = ReflectionUtils.findMethod(target.getClass(), name, type);
        ReflectionUtils.invokeMethod(method, target, value);
    }
}
