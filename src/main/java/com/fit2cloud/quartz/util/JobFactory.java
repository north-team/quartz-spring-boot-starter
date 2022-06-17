package com.fit2cloud.quartz.util;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * @author makai
 * 将自定义JOB注入Spring
 * 2022/6/16 19:43
 */
public class JobFactory extends SpringBeanJobFactory {
    /**
     * AutowireCapableBeanFactory接口是BeanFactory的子类
     * 可以连接和填充那些生命周期不被Spring管理的已存在的bean实例
     */
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    public void setBeanFactory(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 创建Job实例
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        // 实例化对象
        Object job = super.createJobInstance(bundle);
        // 进行注入（Spring管理该Bean）
        beanFactory.autowireBean(job);
        //返回对象
        return job;
    }

}
