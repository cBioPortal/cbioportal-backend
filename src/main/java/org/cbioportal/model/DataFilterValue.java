package org.cbioportal.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DataFilterValue implements Serializable {

	private static final long serialVersionUID = 9185530320985440550L;
	private BigDecimal start;
	private BigDecimal end;
	private String value;

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
