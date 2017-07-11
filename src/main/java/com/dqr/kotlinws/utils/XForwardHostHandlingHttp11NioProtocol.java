package com.dqr.kotlinws.utils;

import org.apache.coyote.Adapter;
import org.apache.coyote.Request;
import org.apache.coyote.http11.Http11NioProtocol;

import java.lang.reflect.Proxy;

/**
 * Created by dqromney on 7/10/17.
 */
public class XForwardHostHandlingHttp11NioProtocol extends Http11NioProtocol {
    public XForwardHostHandlingHttp11NioProtocol() {
    }
    public void setAdapter(Adapter adapter) {
        Adapter adapterFacade = (Adapter) Proxy.newProxyInstance(XForwardHostHandlingHttp11NioProtocol.class.getClassLoader(), new Class[]{Adapter.class}, (proxy, method, args) -> {
            if(method.getName().equals("service")) {
                Request req = (Request)args[0];
                String header = req.getHeader("X-Forward-Host");
                if(header != null) {
                    req.serverName().setString(header.split(",")[0].trim());
                }
            }
            return method.invoke(adapter, args);
        });
        super.setAdapter(adapterFacade);
    }
}
