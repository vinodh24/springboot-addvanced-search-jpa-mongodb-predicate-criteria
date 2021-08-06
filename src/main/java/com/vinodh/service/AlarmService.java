package com.vinodh.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.vinodh.advanced.search.model.SearchParam;
import com.vinodh.criteria.AlarmCriteriaBuilder;
import com.vinodh.criteria.AlarmPredicateBuilder;
import com.vinodh.dto.InPutParams;
import com.vinodh.dto.PagingResponseDTO;
import com.vinodh.repository.AlarmRepository;
import com.vinodh.repository.GenericExampleExecutor;
import com.viondh.document.Alarm;

@Service
public class AlarmService {
	public static Logger logger = LoggerFactory.getLogger(AlarmCriteriaBuilder.class);

	@Autowired
	private GenericExampleExecutor genericExampleExecutor;

	@Autowired
	private AlarmRepository alarmRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveAlarms(List<Alarm> alarmList) {
		alarmRepository.saveAll(alarmList);
	}

	public Alarm saveAlarm(Alarm alarm) {
		alarm.setOccurrenceTime(new Date());
		alarm.setReceivedTime(new Date());
		return alarmRepository.save(alarm);
	}

	public Optional<Alarm> findById(String id) {
		return alarmRepository.findById(id);
	}

	public PagingResponseDTO getAllAlarms(InPutParams inPutParams) {
		Example<Alarm> example=genericExampleExecutor.getExampleExecutor(inPutParams.getAlarm());
		Pageable paging = PageRequest.of(inPutParams.getOffset(), inPutParams.getLimit());
		Page<Alarm> alarms =alarmRepository.findAll(example,paging);
		return new PagingResponseDTO(alarms);
	}

	public PagingResponseDTO getAllAlarmsByCriteria(List<SearchParam> searchParams) {
		Query query =null;
		AlarmCriteriaBuilder alarmCriteriaBuilder=new AlarmCriteriaBuilder();
		Page<Alarm> alarmsPage =null;
		Pageable pageable = PageRequest.of(0, 10);
		for (SearchParam searchParam : searchParams) {
			alarmCriteriaBuilder.with(searchParam);
		}
		query=alarmCriteriaBuilder.criteriaOrConditionBuild();
		List<Alarm> alarms=mongoTemplate.find(query.with(pageable),Alarm.class);
		logger.info(alarms.size()+"    :::alarms    :::"+alarms);
		long count = mongoTemplate.count(query, Alarm.class);	
		alarmsPage =  PageableExecutionUtils.getPage(alarms, pageable, () -> count);
		return new PagingResponseDTO(alarmsPage);
	}
	public PagingResponseDTO getAllAlarmsByPredicates(List<SearchParam> searchParams) {
		AlarmPredicateBuilder alarmPredicateBuilder=new AlarmPredicateBuilder();
		Pageable pageable = PageRequest.of(0, 10);
		for (SearchParam searchParam : searchParams) {
			alarmPredicateBuilder.with(searchParam);
		}
		Page<Alarm> alarmsPage = alarmRepository.findAll(alarmPredicateBuilder.build(), pageable);
		return new PagingResponseDTO(alarmsPage);
	}

}
