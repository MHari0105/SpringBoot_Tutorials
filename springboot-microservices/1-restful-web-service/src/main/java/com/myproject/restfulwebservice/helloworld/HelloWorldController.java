package com.myproject.restfulwebservice.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private MessageSource msgSrc;

    public HelloWorldController(MessageSource msgSrc) {
        this.msgSrc = msgSrc;
    }

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(
            String.format("Hello, %s", name)
        );
    }

    @GetMapping("/i18n")
    public String helloWorldInternationalised() {

        Locale locale = LocaleContextHolder.getLocale();
        return msgSrc.getMessage("good.morning.message", null, "Default Message", locale);

    }
    
}
