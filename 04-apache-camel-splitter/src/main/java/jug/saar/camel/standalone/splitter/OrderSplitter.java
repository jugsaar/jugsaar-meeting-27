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
package jug.saar.camel.standalone.splitter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.camel.component.file.GenericFile;

/**
 * @author Frank Dietrich <Frank.Dietrich@gmx.li>
 */
public class OrderSplitter {

    public List<String> split(GenericFile genFile) throws IOException {
        Iterator<String> iterator = getIterator(genFile);
        String customer = getCustomer(iterator);
        List<String> modules = getModules(iterator);

        int orderNumber = 1;
        int ordersCount = modules.size();
        List<String> splittedOrders = new ArrayList<>();

        for (String module : modules) {
            StringBuilder sb = new StringBuilder();
            sb.append(customer)
                    .append(System.lineSeparator())
                    .append(String.format("  order %d of %d", orderNumber, ordersCount))
                    .append(System.lineSeparator())
                    .append(module);
            orderNumber++;
            splittedOrders.add(sb.toString());
        }

        return splittedOrders;
    }

    private static String getCustomer(Iterator<String> iterator) {
        return iterator.next();
    }

    private Iterator<String> getIterator(GenericFile o) throws IOException {
        File file = (File) o.getBody();
        return Files.readAllLines(file.toPath()).iterator();
    }

    private List<String> getModules(Iterator<String> iterator) {
        List<String> modules = new ArrayList<>();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.contains("module")) {
                modules.add(line);
            }
        }
        return modules;
    }
}
