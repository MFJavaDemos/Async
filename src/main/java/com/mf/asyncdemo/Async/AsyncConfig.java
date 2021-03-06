package com.mf.asyncdemo.Async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;


/**
 * @description:
 * @author: chang
 * @create: 2020-08-24 14:58
 **/
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public Executor getAsyncExecutor() {
        /**这里我们自己手写一个自定义线程池*/
        threadPoolExecutor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() << 1,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadPoolExecutor.AbortPolicy()
        );

        return threadPoolExecutor;
    }


}
