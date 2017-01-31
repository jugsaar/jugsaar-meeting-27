Example for deploying an Apache Camel route as OSGI bundle.

###compile the bundle and install it in the local Maven repository###

    mvn compile install

###load the bundle into Karaf###

   karaf@root()> bundle:install --start mvn:sub.optimal/apache.camel.demo.osgi
   starting the bundle - jug.saar.osgi.Activator
   Bundle ID: 157

If the bundle was already installed before it must be removed first.

   karaf@root()> bundle:uninstall "05 :: Apache Camel :: osgi"
   stopping the bundle - class jug.saar.osgi.Activator

###watch the Camel route processing###

   karaf@root()> log:tail

###place a parts order###

   cp order1.xml ${KARAF_ROOT}/target/subfolder/Order

The processed order is created in `${KARAF_ROOT}/target/subfolder/Warehouse`.

###place a module order####

   cp order2.xml ${KARAF_ROOT}/target/subfolder/Order

The processed order is created in `${KARAF_ROOT}/target/subfolder/Workshop`.
