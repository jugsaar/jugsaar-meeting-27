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

import java.util.concurrent.TimeUnit;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author Frank Dietrich <Frank.Dietrich@gmx.li>
 */
public class OrderDemo {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext camel = new DefaultCamelContext();
        OrderRoute routes = new OrderRoute();
        camel.addRoutes(routes);
        camel.start();

        TimeUnit.SECONDS.sleep(60);

        camel.stop();
    }

}
