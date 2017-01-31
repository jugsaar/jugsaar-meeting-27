###installation of Apache Karaf###

Download the installation archive from https://karaf.apache.org/download.html

    tar xzf apache-karaf-4.0.8.tar.gz 
    cd apache-karaf-4.0.8/bin
    ./karaf

###install Apache Camel into Karaf###

    karaf@root()> feature:repo-add camel 2.16.3
    Adding feature url mvn:org.apache.camel.karaf/apache-camel/2.16.3/xml/features

    karaf@root()> feature:install camel

    karaf@root()> feature:list | grep "camel.*Started"
    camel                                   | 2.16.3           | x        | Started     | camel-2.16.3
    camel-core                              | 2.16.3           |          | Started     | camel-2.16.3
    camel-spring                            | 2.16.3           |          | Started     | camel-2.16.3
    camel-blueprint                         | 2.16.3           |          | Started     | camel-2.16.3


###install Apache ActiveMQ into Karaf###

    karaf@root()> feature:repo-add activemq 5.13.3
    Adding feature url mvn:org.apache.activemq/activemq-karaf/5.13.3/xml/features

    karaf@root()> feature:install activemq activemq-broker

    karaf@root()> feature:list | grep "activemq.*Started"
    activemq-broker                         | 5.13.3           | x        | Started     | activemq-5.13.3
    activemq-web-console                    | 5.13.3           |          | Started     | activemq-5.13.3
    activemq-client                         | 5.13.3           |          | Started     | activemq-core-5.13.3
    activemq                                | 5.13.3           | x        | Started     | activemq-core-5.13.3

###install webconsole hawtio into Karaf###

    karaf@root()> feature:repo-add hawtio 1.4.65
    Adding feature url mvn:io.hawt/hawtio-karaf/1.4.65/xml/features

    karaf@root()> feature:install hawtio

    karaf@root()> feature:list | grep "hawtio.*Started"
    hawtio-core                             | 1.4.65           |          | Started     | hawtio-1.4.65
    hawtio-log                              | 1.4.65           |          | Started     | hawtio-1.4.65
    hawtio                                  | 1.4.65           | x        | Started     | hawtio-1.4.65
    hawtio-maven-indexer                    | 1.4.65           |          | Started     | hawtio-1.4.65
    hawtio-karaf-terminal                   | 1.4.65           |          | Started     | hawtio-1.4.65

Find out the webconsole port.

    karaf@root()> config:list "(service.pid=org.ops4j.pax.web)"
    ----------------------------------------------------------------
    Pid:            org.ops4j.pax.web
    BundleLocation: mvn:org.ops4j.pax.web/pax-web-runtime/4.3.0
    Properties:
       felix.fileinstall.filename = file:/home/suboptimal/tmp/testdrive/apache-karaf-4.0.8/etc/org.ops4j.pax.web.cfg
       javax.servlet.context.tempdir = /home/suboptimal/tmp/testdrive/apache-karaf-4.0.8/data/pax-web-jsp
       org.ops4j.pax.web.config.file = /home/suboptimal/tmp/testdrive/apache-karaf-4.0.8/etc/jetty.xml
       org.osgi.service.http.port = 8181
       service.pid = org.ops4j.pax.web

The hawtio webconsole can be accessed by http://localhost:8181/hawtio/login

    username: karaf
    password: karaf
