package com.jumpserver.sdk.v2.httpclient;

import java.util.Iterator;
import java.util.ServiceLoader;

public class HttpExecutor {

    private static final HttpExecutor INSTANCE = new HttpExecutor();
    private HttpExecutorService service = new HttpExecutorService();

    private HttpExecutor() {
    }

    private HttpExecutorService service() {
//        if (service != null) return service;
//
//        Iterator<HttpExecutorService> it = ServiceLoader.load(HttpExecutorService.class, getClass().getClassLoader()).iterator();
//        if (!it.hasNext()) {
//            throw new RuntimeException("No  connector HttpExecutorService  found in classpath");
//        }
//        return service = it.next();
        return  service;
    }

    public static HttpExecutor create() {
        return INSTANCE;
    }

    public <R> HttpResponse execute(HttpRequest<R> request) {
        return service().execute(request);
    }
}
