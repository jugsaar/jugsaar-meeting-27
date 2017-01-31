/*
 * Copyright 2016 Frank Dietrich <Frank.Dietrich@gmx.li>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jug.saar.camel.simple;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author Frank Dietrich <Frank.Dietrich@gmx.li>
 */
public class OrderRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        String order = "file://target/subfolder/Order?delay=2000&delete=true";
        String fileNamePattern = "${date:now:yyyyMMdd.HHmmss}_${file:name.noext}.txt";
        String workshop = "file://target/subfolder/Workshop?fileName=" + fileNamePattern;
        String warehouse = "file://target/subfolder/Warehouse?fileName=" + fileNamePattern;

        from(order)
                .routeId("Java DSL")
                .choice()
                    .when(simple("${bodyAs(String)} contains 'module'"))
                    .log("we got a module order : [${body}]")
                    .to(workshop)
                .otherwise()
                    .log("we got a parts order : [${body}]")
                    .to(warehouse);
    }

}
