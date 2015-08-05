package net.study.code;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Embeddable
public class CodeId implements Serializable {
  
	/** CODECATEGORYKEY */
	@Column(name="codecategorykey")
	private String codecategorykey = "";

	/** CODE */
	@Column(name="code")
	private String code = "";
	
	public CodeId() {}
	
	public CodeId(String codecategorykey, String code) {
		this.codecategorykey = codecategorykey;
		this.code = code;
	}

	public String getCodecategorykey() {
		return codecategorykey;
	}

	public void setCodecategorykey(String codecategorykey) {
		this.codecategorykey = codecategorykey;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * toString
	 * @return String
	 */
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
