package com.vinodh.criteria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.vinodh.advanced.search.model.AlarmSearchField;
import com.vinodh.advanced.search.model.SearchOperation;
import com.vinodh.advanced.search.model.SearchParam;

public class AlarmCriteriaBuilder {

	public static Logger logger = LoggerFactory.getLogger(AlarmCriteriaBuilder.class);

	private Query query = null;
	private List<Criteria> criterias =null;

	public AlarmCriteriaBuilder() {
		super();
		query = new Query();
		criterias = new ArrayList<Criteria>();
	}

	// Building Criteria based on search params
	public final AlarmCriteriaBuilder with(final SearchParam searchParam) {
		if (searchParam.getValue() == null && searchParam.getValues() == null && searchParam.getValues().size() == 0) {
			return this;
		}
		AlarmSearchField searchField = (AlarmSearchField) searchParam.getField();
		switch (searchField) {
		case nodeName:
			String nodeName =searchParam.getValue();
			logger.debug("building with search String:::::::" + nodeName);
			criterias.add(hasNodeName(nodeName));
			break;
		case nodeIp:
			String nodeIp = searchParam.getValue();
			logger.debug("building with search String:::::::" + nodeIp);
			criterias.add(hasNodeIp(nodeIp));
			break;
		case emsName:
			String emsName = searchParam.getValue();
			logger.debug("building with search String:::::::" + emsName);
			criterias.add(emsName(emsName));
			break;
		case emsIp:
			String emsIp = searchParam.getValue();
			logger.debug("building with search String:::::::" + emsIp);
			criterias.add(hasEmsIp(emsIp));
			break;
		case category:
			String category = searchParam.getValue();
			logger.debug("building with search String:::::::" + category);
			criterias.add(hasCategory(category));
			break;
		case severity:
			String severity = searchParam.getValue();
			logger.debug("building with search String:::::::" + severity);
			criterias.add(hasSeverity(severity));
			break;
		case deviceType:
			String deviceType = searchParam.getValue();
			logger.debug("building with search String:::::::" + deviceType);
			break;
		case identifier:
			String identifier = searchParam.getValue();
			logger.debug("building with search String:::::::" + identifier);
			criterias.add(hasIdentifier(identifier));
			break;
		case trapRequestId:
			Integer trapRequestId = Integer.parseInt(searchParam.getValue());
			logger.debug("building with search String:::::::" + trapRequestId);
			criterias.add(hasTrapRequestId(trapRequestId));
			break;
		case location:
			String location = searchParam.getValue();
			logger.debug("building with search String:::::::" + location);
			criterias.add(hasLocation(location));
			break;
		case receivedTime:
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Date parsedDate = dateFormat.parse(searchParam.getValue());
			    criterias.add(hasReceivedTime(parsedDate, searchParam.getOperation()));
			    logger.debug("building with search String:::::::" + searchParam.getValue());
			} catch (ParseException e) {
				logger.error("Error in building search String for received time" + e);
			}
			break;

		default:
			break;
		}
		return this;
	}

	public Criteria hasNodeName(final String searchValue){
		return Criteria.where("nodeName").regex(searchValue);
	}
	public Criteria hasNodeIp(final String searchValue){
		return Criteria.where("nodeIp").regex(searchValue);
	}
	public Criteria emsName(final String searchValue){
		return Criteria.where("emsName").regex(searchValue);
	}
	public Criteria hasEmsIp(final String searchValue){
		return Criteria.where("emsIp").regex(searchValue);
	}
	public Criteria hasCategory(final String searchValue){
		return Criteria.where("category").regex(searchValue);
	}
	public Criteria hasSeverity(final String searchValue){
		return Criteria.where("severity").regex(searchValue);
	}
	public Criteria hasDeviceType(final String searchValue){
		return Criteria.where("deviceType").regex(searchValue);
	}
	public Criteria hasIdentifier(final String searchValue){
		return Criteria.where("identifier").regex(searchValue);
	}
	public Criteria hasTrapRequestId(final Integer searchValue){
		return Criteria.where("trapRequestId").is(searchValue);
	}
	public Criteria hasLocation(final String searchValue){
		return Criteria.where("location").regex(searchValue);
	}
	public Criteria hasReceivedTime(Date parsedDate,final SearchOperation operation){
		if(operation == SearchOperation.GREATER_THAN_OR_EQUAL){
			return Criteria.where("receivedTime").gte(parsedDate);
		}else if(operation == SearchOperation.GREATER_THAN){
			return Criteria.where("receivedTime").gt(parsedDate);
		}else if(operation == SearchOperation.LESS_THAN){
			return Criteria.where("receivedTime").lt(parsedDate);
		}else{
			return Criteria.where("receivedTime").lte(parsedDate);
		}
	}
	public Query build() {
		return query;
	}
	
	public Query criteriaOrConditionBuild() {
		Criteria criteria=new Criteria();
		criteria.orOperator(criterias.toArray(new Criteria[criterias.size()]));
		return query.addCriteria(criteria);
	}
	
	public Query criteriaAndConditionBuild() {
		Criteria criteria=new Criteria();
		criteria.andOperator(criterias.toArray(new Criteria[criterias.size()]));
		return query.addCriteria(criteria);
	}


}
