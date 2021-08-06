package com.vinodh.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.viondh.document.Alarm;

public interface AlarmRepository extends MongoRepository<Alarm, String>,QueryByExampleExecutor<Alarm>, QuerydslPredicateExecutor<Alarm>{
	
	//, QueryDslPredicateExecutor<Alarm>,QueryByExampleExecutor<Alarm>

}
