package querydsl;

import com.mysema.query.jpa.impl.JPAQuery;
import querydsl.domain.Item;
import querydsl.domain.Member;
import querydsl.domain.QItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import static querydsl.domain.QMember.member; //기본 인스턴스

public class QueryDSLMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("querydsl");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = new Member();
        member1.setName("회원1");
        member1.setAge(10);
        em.persist(member1);
        tx.commit();

        JPAQuery query = new JPAQuery(em);
        //QMember qMember = new QMember("m"); //생성되는 JPQL의 별칭이 m (직접 지정)
        //QMember qMember1 = QMember.member; //기본 인스턴스 사용

        /**
         * static import도 가능
         */
        List<Member> findMembers = query.from(member)
                .where(member.name.eq("회원1"))
                .orderBy(member.name.desc())
                .list(member);

        for (Member findMember : findMembers) {
            System.out.println("member1 = " + member1.getAge());
        }

        QItem item = QItem.item;
        List<Item> findList = query.from(item)
                .where(item.name.eq("좋은상품").and(item.price.gt(20000)))
                .list(item);
    }
}
