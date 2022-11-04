open module com.chrosciu.java17spring {
    requires static lombok;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.core;
    requires spring.context;

    requires org.apache.tomcat.embed.core;
    requires com.fasterxml.jackson.databind;
}