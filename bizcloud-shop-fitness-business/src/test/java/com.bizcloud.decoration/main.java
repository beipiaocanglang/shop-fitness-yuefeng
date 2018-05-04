package com.bizcloud.decoration;

import com.bizcloud.memberdecoration.modal.fitness.MemberPageTdk;
import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.bizcloud.memberdecoration.service.MemberPageTdkService;
import com.bizcloud.memberdecoration.service.SystemtTempModuleService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dev on 2017/4/14.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:AC.xml", "classpath*:META-INF/spring/*.xml"});
    }

}
