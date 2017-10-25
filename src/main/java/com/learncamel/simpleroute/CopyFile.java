package com.learncamel.simpleroute;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFile {

    public static void main(String[] args) {

        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {

                @Override
                public void configure() throws Exception {

                    from("file:data/input?noop=true")
                            .log("Received message with body ${body}")
                            .to("file:data/output");
                }
            });

            camelContext.start();

            Thread.sleep(5000);

            camelContext.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
