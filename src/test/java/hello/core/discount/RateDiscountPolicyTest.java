package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 적용되어야 한다.")
    void vipDiscountTest() {
        //given
        Member member = new Member(1L, "어정잡이", Grade.VIP);

        //when
       int discountPrice = discountPolicy.discount(member,20000);

        //then
        assertThat(discountPrice).isEqualTo(2000);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다.")
    void basicDiscountTest() {

        //given
        Member member = new Member(2L, "어정잡삼", Grade.BASIC);


        //when
        int discountPrice = discountPolicy.discount(member,20000);

        //then
        assertThat(discountPrice).isEqualTo(0);


    }
}