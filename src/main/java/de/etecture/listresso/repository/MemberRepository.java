package de.etecture.listresso.repository;

import de.etecture.listresso.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
