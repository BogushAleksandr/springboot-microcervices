package com.ua.sasha.bogush.springbootmicroservices.config.server;

import com.ua.sasha.bogush.springbootmicroservices.configpojo.server.Netty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.server.HttpServer;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 08.12.2020
 */

@Configuration
public class NettyFactoryCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    private static final Logger logNettyFactoryCustomizer = LoggerFactory.getLogger(NettyFactoryCustomizer.class);


    private final Netty nettyServer;

    public NettyFactoryCustomizer(Netty nettyServer) {
        this.nettyServer = nettyServer;
    }

    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        /**
         * @author Oleksandr Bogush
         * @version 1.0
         * @since 17.12.2020
         */
        logNettyFactoryCustomizer.info("See REST API doc on \"http://"
                + nettyServer.getIpadress() + ":"
                + nettyServer.getPort() + "/swagger-ui-custom.html\""
        );
        serverFactory.addServerCustomizers(new PortCustomizer(nettyServer.getPort(), nettyServer.getIpadress()));
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 08.12.2020
     */
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
