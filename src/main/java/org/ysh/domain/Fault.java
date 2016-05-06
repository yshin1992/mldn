package org.ysh.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault implements Entity {
	
	private Long id;
	private Long machineryId;
	private String faultCode;
	private Date beginTime;
	private Date endTime;
	private Double beginLongitude;
	private Double beginLatitude;
	private Double endLongitude;
	private Double endLatitude;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMachineryId() {
		return machineryId;
	}
	public void setMachineryId(Long machineryId) {
		this.machineryId = machineryId;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Double getBeginLongitude() {
		return beginLongitude;
	}
	public void setBeginLongitude(Double beginLongitude) {
		this.beginLongitude = beginLongitude;
	}
	public Double getBeginLatitude() {
		return beginLatitude;
	}
	public void setBeginLatitude(Double beginLatitude) {
		this.beginLatitude = beginLatitude;
	}
	public Double getEndLongitude() {
		return endLongitude;
	}
	public void setEndLongitude(Double endLongitude) {
		this.endLongitude = endLongitude;
	}
	public Double getEndLatitude() {
		return endLatitude;
	}
	public void setEndLatitude(Double endLatitude) {
		this.endLatitude = endLatitude;
	}
	@Override
	public String toString() {
		return "Fault [id=" + id + ", machineryId=" + machineryId
				+ ", faultCode=" + faultCode + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", beginLongitude=" + beginLongitude
				+ ", beginLatitude=" + beginLatitude + ", endLongitude="
				+ endLongitude + ", endLatitude=" + endLatitude + "]";
	}
	
}
