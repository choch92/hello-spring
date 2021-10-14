package hellosibal.hellospring;

import hellosibal.hellospring.aop.TimeTraceAop;
import hellosibal.hellospring.repository.JpaMemberRepository;
import hellosibal.hellospring.repository.MemberRepository;
import hellosibal.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    /*private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }

/*    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/
}
