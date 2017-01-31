The Camel context and the route are created programmatically using the `org.apache.camel.main.Main`.

Multiple module orders are splitted into single module orders.

###execute the route###

    mvn exec:java -Dexec.mainClass=jug.saar.camel.standalone.splitter.OrderStandaloneSplitter

Execution must be finished with `CTRL-C`.

###create a parts order###

    create_parts_order.sh

Parts order is created in `target/subfolder/Order` the processed order is in `target/subfolder/Warehouse`.

###create a module order###

    create_module_order.sh

Parts module is created in `target/subfolder/Order` the processed order is in `target/subfolder/Workshop`.

###create multiple module order###

    create_module_multiorder.sh

Parts multiple module is created in `target/subfolder/Order` the processed order is in `target/subfolder/Workshop`.
