package com.viondh.document;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "alarm")
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonIgnoreProperties
public class Alarm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Field("_id")
	@JsonIgnore
	private String id;
	private String severity;
    private String nodeName;
    private String emsName;
    private String category;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date occurrenceTime;
    private Long occurrence;
    private String emsIp;
    private String nodeIp;
    private Long emsId;
    private Long nodeId;
    private String protocol;
    private Integer port;
    private String deviceType;
    private String identifier;
    private String type;
    private String tid;
    private String sid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receivedTime;
    private String alarmCode;
    private String atag;
    private String verb;
    private String modifier1;
    private String modifier2;
    private String comment01;
    private String comment02;
    private String quotedline;
    private String section1Field1;
    private String section2Field1;
    private String section2Field2;
    private String section2Field3;
    private String section2Field4;
    private String section2Field5;
    private String section2Field6;
    private String section2Field7;
    private String section2Field8;
    private String section2Field9;
    private String section2Field10;
    private String section3Field1;
    private String section3Field2;
    private String section3Field3;
    private String section3Field4;
    private String section4Field1;
    private String section4Field2;
	private Integer trapRequestId;
	private String location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getEmsName() {
		return emsName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getOccurrenceTime() {
		return occurrenceTime;
	}

	public void setOccurrenceTime(Date occurrenceTime) {
		this.occurrenceTime = occurrenceTime;
	}

	public Long getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(Long occurrence) {
		this.occurrence = occurrence;
	}

	public String getEmsIp() {
		return emsIp;
	}

	public void setEmsIp(String emsIp) {
		this.emsIp = emsIp;
	}

	public String getNodeIp() {
		return nodeIp;
	}

	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}

	public Long getEmsId() {
		return emsId;
	}

	public void setEmsId(Long emsId) {
		this.emsId = emsId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Date getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}

	public String getAlarmCode() {
		return alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public String getAtag() {
		return atag;
	}

	public void setAtag(String atag) {
		this.atag = atag;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getModifier1() {
		return modifier1;
	}

	public void setModifier1(String modifier1) {
		this.modifier1 = modifier1;
	}

	public String getModifier2() {
		return modifier2;
	}

	public void setModifier2(String modifier2) {
		this.modifier2 = modifier2;
	}

	public String getComment01() {
		return comment01;
	}

	public void setComment01(String comment01) {
		this.comment01 = comment01;
	}

	public String getComment02() {
		return comment02;
	}

	public void setComment02(String comment02) {
		this.comment02 = comment02;
	}

	public String getQuotedline() {
		return quotedline;
	}

	public void setQuotedline(String quotedline) {
		this.quotedline = quotedline;
	}

	public String getSection1Field1() {
		return section1Field1;
	}

	public void setSection1Field1(String section1Field1) {
		this.section1Field1 = section1Field1;
	}

	public String getSection2Field1() {
		return section2Field1;
	}

	public void setSection2Field1(String section2Field1) {
		this.section2Field1 = section2Field1;
	}

	public String getSection2Field2() {
		return section2Field2;
	}

	public void setSection2Field2(String section2Field2) {
		this.section2Field2 = section2Field2;
	}

	public String getSection2Field3() {
		return section2Field3;
	}

	public void setSection2Field3(String section2Field3) {
		this.section2Field3 = section2Field3;
	}

	public String getSection2Field4() {
		return section2Field4;
	}

	public void setSection2Field4(String section2Field4) {
		this.section2Field4 = section2Field4;
	}

	public String getSection2Field5() {
		return section2Field5;
	}

	public void setSection2Field5(String section2Field5) {
		this.section2Field5 = section2Field5;
	}

	public String getSection2Field6() {
		return section2Field6;
	}

	public void setSection2Field6(String section2Field6) {
		this.section2Field6 = section2Field6;
	}

	public String getSection2Field7() {
		return section2Field7;
	}

	public void setSection2Field7(String section2Field7) {
		this.section2Field7 = section2Field7;
	}

	public String getSection2Field8() {
		return section2Field8;
	}

	public void setSection2Field8(String section2Field8) {
		this.section2Field8 = section2Field8;
	}

	public String getSection2Field9() {
		return section2Field9;
	}

	public void setSection2Field9(String section2Field9) {
		this.section2Field9 = section2Field9;
	}

	public String getSection2Field10() {
		return section2Field10;
	}

	public void setSection2Field10(String section2Field10) {
		this.section2Field10 = section2Field10;
	}

	public String getSection3Field1() {
		return section3Field1;
	}

	public void setSection3Field1(String section3Field1) {
		this.section3Field1 = section3Field1;
	}

	public String getSection3Field2() {
		return section3Field2;
	}

	public void setSection3Field2(String section3Field2) {
		this.section3Field2 = section3Field2;
	}

	public String getSection3Field3() {
		return section3Field3;
	}

	public void setSection3Field3(String section3Field3) {
		this.section3Field3 = section3Field3;
	}

	public String getSection3Field4() {
		return section3Field4;
	}

	public void setSection3Field4(String section3Field4) {
		this.section3Field4 = section3Field4;
	}

	public String getSection4Field1() {
		return section4Field1;
	}

	public void setSection4Field1(String section4Field1) {
		this.section4Field1 = section4Field1;
	}

	public String getSection4Field2() {
		return section4Field2;
	}

	public void setSection4Field2(String section4Field2) {
		this.section4Field2 = section4Field2;
	}

	public Integer getTrapRequestId() {
		return trapRequestId;
	}

	public void setTrapRequestId(Integer trapRequestId) {
		this.trapRequestId = trapRequestId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}