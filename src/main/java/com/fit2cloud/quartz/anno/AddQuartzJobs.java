package com.fit2cloud.quartz.anno;

import java.lang.annotation.*;

/**
 * @author makai
 * 标注在添加定时任务的方法上。
 * 注解 @QuartzScheduled 标注方法添加为定时任务后，
 * 执行该注解标注的方法，用于添加定时任务
 *
 * 注意：该注解标注的方法 添加定时任务前需要先检查定时任务是否存在 避免重复添加
 * 2022/6/29 16:32
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddQuartzJobs {
}
