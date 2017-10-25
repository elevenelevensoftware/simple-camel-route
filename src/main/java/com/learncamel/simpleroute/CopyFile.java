package com.learncamel.simpleroute;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.impl.DefaultCamelContext;


public class CopyFile {

    public static void main(String[] args) {

        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {

                @Override
                public void configure() throws Exception {

                    from("file:data/input?noop=true")
                            .log("Received message with body \n ${body} \n with headers ${headers} \n")
                            .process(new Processor() {
                                public void process(Exchange exchange) throws Exception {

                                    GenericFile genericFile = exchange.getIn().getBody(GenericFile.class);
                                    CamelFile camelFile = new CamelFile(genericFile.getAbsoluteFilePath(),
                                            genericFile.getFileName(), genericFile.getFile().toString());
                                }
                            })
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
