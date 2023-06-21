package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    @Test
    void order() {
        //given
        Member member = new Member(1L,"어정잡이", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(member.getId(), "텐트",20000);

        //then
        Assertions.assertThat(order.getMemberId()).isEqualTo(member.getId());
    }
}
