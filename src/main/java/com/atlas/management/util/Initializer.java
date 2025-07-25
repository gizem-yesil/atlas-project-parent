package com.atlas.management.util;

import com.atlas.management.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

public class Initializer {
    @EventListener(ApplicationReadyEvent.class)
    public void initializeCourseData()  {
        User user = new User();
        user.setUserName("admin");
        user.setUserPassword("admin");
        user.setId("first");

    }

}
