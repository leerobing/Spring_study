package hello.core.member;

public interface MemberService {
    void join(Member member);

    Member findByMember(Long memberId);
}
