package com.lifei.spring.example.demo.cd;

import org.springframework.stereotype.Component;

//表明该类会作为组件类，并告知Spring要为这个类型创建bean
@Component
public class Jay implements CompactDisc{
    @Override
    public void play() {
        System.out.println("chuang wai de ma que");
    }
}
