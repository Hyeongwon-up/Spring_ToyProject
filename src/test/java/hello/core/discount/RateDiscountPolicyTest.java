package hello.core.discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인 적용")
    void vip_0() {
        //given
        Member member = new Member(1L, "memverVIP", Grade.VIP);

        //when

        int discount;


        //then




    }

}