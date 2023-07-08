package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L, "itemA",10000);
////      이 테스트 실행하려면 AppConfig에 return을 주석 처리하고 return null로 해야 실행해 볼 수 있다.

        MemoryMemberRepository memberRepository= new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService= new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order=orderService.createOrder(1L, "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
