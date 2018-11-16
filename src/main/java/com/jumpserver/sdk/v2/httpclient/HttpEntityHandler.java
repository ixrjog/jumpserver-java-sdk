package com.jumpserver.sdk.v2.httpclient;

import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.exceptions.ClientResponseException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * 对各类状态码进行处理
 * */
public class HttpEntityHandler {

    private static final Logger LOG = LoggerFactory.getLogger(HttpEntityHandler.class);

    @SuppressWarnings("unchecked")
    public static <T> List<T> handleList(HttpResponse response, Class<T> returnType, boolean list) {
        if (response.getStatus() >= 400) {
            throw new ClientResponseException(response.getStatusMessage());
        }
        //TODO readEntity
        return response.readEntityList(returnType);
    }

    @SuppressWarnings("unchecked")
    public static <T> T handle(HttpResponse response, Class<T> returnType, boolean list) {
        try {
            //TODO options
//            Handle<T> handle = Handle.create(response, returnType, options, requiresVoidBodyHandling);
//            System.out.println(response.getEntity(String.class));

            String text = "";
            if (response.getStatus() >= 400) {

//                if (requiresVoidBodyHandling && ActionResponse.class == returnType) {
//                    return (T) ResponseToActionResponse.INSTANCE.apply(response);
//                }

//                if (options != null) {
//                    options.propagate(response);
//                }

//                if (handle404(handle).isComplete()) {
//                    return handle.getReturnObject();
//                }

//                if (handleLessThan500(handle).isComplete()) {
//                    return handle.getReturnObject();
//                }
                try {
                    InputStream inputStream = response.getInputStream();
                    text = IOUtils.toString(inputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw new ClientResponseException(response.getStatusMessage() + " " + text);
            }

//            if (options != null && options.hasParser()) {
//                return options.getParser().apply(response);
//            }

            if (returnType == Void.class) {
                return null;
            }

            if (returnType == ActionResponse.class) {
                return (T) ActionResponse.actionSuccess(response.getStatus());
            }

            //TODO readEntity
            return response.readEntity(returnType);
        } finally {
            closeQuietly(response);
        }
    }

//    private static <T> Handle<T> handle404(Handle<T> handle) {
//        if (handle.getResponse().getStatus() == 404) {
//
//            if (ListType.class.isAssignableFrom(handle.getReturnType())) {
//                try {
//                    return handle.complete(handle.getReturnType().newInstance());
//                } catch (InstantiationException e) {
//                    LOG.error(e.getMessage(), e);
//                } catch (IllegalAccessException e) {
//                    LOG.error(e.getMessage(), e);
//                }
//            }
//
//            if (handle.getReturnType() != ActionResponse.class) {
//                return handle.complete(null);
//            }
//        }
//
//        return handle.continueHandling();
//    }

//    @SuppressWarnings("unchecked")
//    private static <T> Handle<T> handleLessThan500(Handle<T> handle) {
//        if (handle.getResponse().getStatus() < 500) {
//            try {
//                ActionResponse ar = ResponseToActionResponse.INSTANCE.apply(handle.getResponse());
//                if (handle.getReturnType() == ActionResponse.class) {
//                    return handle.complete((T) ar);
//                }
//                throw mapException(ar.getFault(), handle.getResponse().getStatus());
//            } catch (ResponseException re) {
//                throw re;
//            } catch (Exception e) {
//                LOG.error(e.getMessage(), e);
//            }
//        }
//        return handle.continueHandling();
//    }

    public static void closeQuietly(HttpResponse response) {
        try {
            response.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static int statusAndClose(HttpResponse response) {
        int status = response.getStatus();
        closeQuietly(response);
        return status;
    }
}
