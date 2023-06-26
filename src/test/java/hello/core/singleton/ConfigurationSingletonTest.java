package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("멤버 리포지토리 객체 싱글톤 확인")
    void singletonTest() {

        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberRepository memberRepository1 = memberService1.getMemberRepository();
        MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberRepository memberRepository2 = memberService2.getMemberRepository();

        OrderServiceImpl orderService1 = ac.getBean("orderService",OrderServiceImpl.class);
        MemberRepository memberRepository3 = orderService1.getMemberRepository();
        OrderServiceImpl orderService2 = ac.getBean("orderService",OrderServiceImpl.class);
        MemberRepository memberRepository4 = orderService1.getMemberRepository();

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository3);


    }
}
