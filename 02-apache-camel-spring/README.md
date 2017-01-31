The Camel context and the route are defined in the Spring application context and started programmatically.

###execute the route###

    mvn exec:java -Dexec.mainClass=jug.saar.camel.simple.spring.OrderDemo

Execution finishes after 60 seconds.

###create a parts order###

    create_parts_order.sh

Parts order is created in `target/subfolder/Order` the processed order is in `target/subfolder/Warehouse`.

###create a module order###

    create_module_order.sh

Parts module is created in `target/subfolder/Order` the processed order is in `target/subfolder/Workshop`.

###create multiple module order###

    create_module_multiorder.sh

Parts multiple module is created in `target/subfolder/Order` the processed order is in `target/subfolder/Workshop`.
