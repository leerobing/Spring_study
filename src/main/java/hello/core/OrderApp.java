package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;

        Member member = new Member(memberId,"어정잡이",Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"축구공",10000);

        System.out.println(order);
    }
}
