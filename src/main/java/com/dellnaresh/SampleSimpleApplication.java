/*
 * Copyright 2012-2013 the original author or authors.
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

package com.dellnaresh;

import com.dellnaresh.torrent.PageExtractor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.dellnaresh.torrent.SeleniumPageExtractor;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = SeleniumPageExtractor.class)
public class SampleSimpleApplication implements CommandLineRunner {

    // Simple example shows how a command line spring application can execute an
    // injected bean pageExtractor. Also demonstrates how you can use @Value to inject
    // command line args ('--name=whatever') or application properties

    @Autowired
    private PageExtractor pageExtractor;

    @Override
    public void run(String... args) {
        System.out.println(this.pageExtractor.getHelloMessage());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleSimpleApplication.class, args);
    }

    @Bean
    public WebDriver driver() {
        return new FirefoxDriver();
    }

}
