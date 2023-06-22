package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findByMember(member.getId());

        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);

    }
}
