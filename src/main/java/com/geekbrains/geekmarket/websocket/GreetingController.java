package com.geekbrains.geekmarket.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web-socket")
public class GreetingController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private static int counter = 0;

    @MessageMapping("/hello")
    // @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @PutMapping
    public Greeting put(@RequestBody HelloMessage message) {
        counter++;
        message.setName(message.getName() + counter);
        Greeting greeting = new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        simpMessagingTemplate.convertAndSend("/topic/greetings", greeting);
        return greeting;
    }

}
