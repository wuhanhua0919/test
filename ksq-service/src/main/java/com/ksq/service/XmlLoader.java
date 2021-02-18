package com.ksq.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource(locations = {"classpath*:application-datasource.xml"})
public class XmlLoader {
}
