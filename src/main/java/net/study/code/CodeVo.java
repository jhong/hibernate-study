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

@Entity
@Table(name="CODE")
public class CodeVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	@EmbeddedId
	private CodeId id;
	
	/** CODEEXPLAIN */
	@Column(name="codeexplain")
	private String codeexplain = "";
	
	/** CODENAME */
	@Column(name="codename")
	private String codename = "";
	
	/** CODEENGNAME */
	@Column(name="codeengname")
	private String codeengname = "";
	
	/** STATUS */
	@Column(name="status")
	private String status = "";
	
	/** SORTORDER */
	@Column(name="sortorder")
	private BigDecimal sortorder = null;


	
	public String getCodecategorykey() {
		return this.id == null ? "" : id.getCodecategorykey();
	}
	
//	public void setCodecategorykey(String codecategorykey) {
//		this.codecategorykey = codecategorykey;
//	}

	public String getCode() {
		return this.id == null ? "" : id.getCode();
	}
//	
//	public void setCode(String code) {
//		this.code = code;
//	}

	public CodeId getId() {
		return id;
	}

	public void setId(CodeId id) {
		this.id = id;
	}

	public String getCodeexplain() {
		return this.codeexplain;
	}
	
	public void setCodeexplain(String codeexplain) {
		this.codeexplain = codeexplain;
	}

	public String getCodename() {
		return this.codename;
	}
	
	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getCodeengname() {
		return this.codeengname;
	}
	
	public void setCodeengname(String codeengname) {
		this.codeengname = codeengname;
	}

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getSortorder() {
		return this.sortorder;
	}
	
	public void setSortorder(BigDecimal sortorder) {
		this.sortorder = sortorder;
	}

	
	/**
	 * toString
	 * @return String
	 */
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
	
}
