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
package jug.saar.routes;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouterBuilder extends RouteBuilder {

    @Override
    public void configure() {
        String fileNamePattern = "${date:now:yyyyMMdd.HHmmssSSS}_${file:name.noext}.txt";

        from("file:target/subfolder/Order?delay=2000&delete=true")
                //                .noAutoStartup()
                .routeId("OSGi simple route")
                .choice().id("id choice")
                .when(xpath("//item[@module]")).id("is a module order")
                .log("module order").id("log module")
                .to("file:target/subfolder/Workshop?fileName=" + fileNamePattern).id("workshop folder")
                .otherwise().id("is not a module order")
                .log("other message").id("log others")
                .to("file:target/subfolder/Warehouse?fileName=" + fileNamePattern).id("warehouse folder");
    }
}
