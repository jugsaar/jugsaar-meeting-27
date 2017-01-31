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
package jug.saar.osgi;

import jug.saar.routes.ContentBasedRouterBuilder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.apache.camel.impl.DefaultCamelContext;
import static java.lang.System.out;

public class Activator implements BundleActivator {

    DefaultCamelContext camelContext;

    @Override
    public void start(BundleContext context) {
        out.printf("starting the bundle - %s%n", this.getClass().getCanonicalName());
        camelContext = new DefaultCamelContext();
        camelContext.setName("context simple OSGi route");
//        camelContext.setAutoStartup(Boolean.FALSE);
        try {
            camelContext.addRoutes(new ContentBasedRouterBuilder());
            camelContext.start();
        } catch (Exception ex) {
            out.println("something went wrong: " + ex.getMessage());
        }
    }

    @Override
    public void stop(BundleContext context) {
        out.printf("stopping the bundle - %s%n", this.getClass());
        if (camelContext != null) {
            try {
                camelContext.stop();
            } catch (Exception ex) {
                out.println("failed to stop the Camel context: "
                        + ex.getMessage());
            }
        }
    }
}
