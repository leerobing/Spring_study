package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singleTonFindBean() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean SingleTonBean = ac.getBean(SingleTonBean.class);
        SingleTonBean SingleTonBean2 = ac.getBean(SingleTonBean.class);
        System.out.println("SingleTonBean = " + SingleTonBean);
        System.out.println("SingleTonBean2 = " + SingleTonBean2);

        assertThat(SingleTonBean).isSameAs(SingleTonBean2);

        ac.close();

    }


    static class SingleTonBean {

        public SingleTonBean singleTon() {
            return new SingleTonBean();
        }

        @PostConstruct
        public void init () {
            System.out.println("SingleTonBean.init");
        }
        @PreDestroy
        public void close() {
            System.out.println("SingleTonBean.close");
        }
    }
}
