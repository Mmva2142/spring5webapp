package guru.spring5webapp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 13:40
 */
@Component
public class LifeCycleDemoBean implements
        InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {


    /*
        ## I`m the LifeCycleDemoBean Constructor
        ## My Bean Name is: lifeCycleDemoBean
        ## Bean Factory has been set.
        ## Application context has been set
        ## - Before init - Caaled by Bean Post Processor
        ## The Post Construct annotated method has been called
        ## The LifeCycleBean has its properties set !
        ## - After init called by Bean Post Processor
    */

    // 1
    public LifeCycleDemoBean() {
        System.out.println("## I`m the LifeCycleDemoBean Constructor");
    }

    // 2
    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: "+ name);
    }

    // 3
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set.");
    }

    // 4
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    // 5
    public void beforeInit(){
        System.out.println("## - Before init - Caaled by Bean Post Processor");
    }

    // 6
    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called");
    }

    // 7
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set !");
    }

    // 8
    public void afterInit(){
        System.out.println("## - After init called by Bean Post Processor");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("## The PreDestroy annotated method has been called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifeCycle Bean has been terminated");
    }


}
