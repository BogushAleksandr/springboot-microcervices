package com.ua.sasha.bogush.springbootmicrocervices.configserver;

import com.ua.sasha.bogush.springbootmicrocervices.pojoconfig.NettyServer;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import reactor.netty.http.server.HttpServer;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Component
public class NettyFactoryCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    private final NettyServer nettyServer;

    public NettyFactoryCustomizer(NettyServer nettyServer) {
        this.nettyServer = nettyServer;
    }

    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        serverFactory.addServerCustomizers(new PortCustomizer(nettyServer.getPort(), nettyServer.getIpadress()));
    }

    private static class PortCustomizer implements NettyServerCustomizer {
        private final int port;
        private final String ipadress;

        public PortCustomizer(int port, String ipadress) {
            this.port = port;
            this.ipadress = ipadress;
        }

        @Override
        public HttpServer apply(HttpServer httpServer) {
            return httpServer.host(ipadress).port(port);
        }
    }
}
