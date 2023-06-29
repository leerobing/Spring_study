package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeFindBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        assertThat(bean1).isNotSameAs(bean2);

        ac.close();
    }


    @Scope("prototype")
    static class PrototypeBean{

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("PrototypeBean.close");
        }

    }
}
