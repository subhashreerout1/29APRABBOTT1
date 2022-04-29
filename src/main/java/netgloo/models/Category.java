package netgloo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@Column(name = "Cat_ID")
	private Integer cat_ID;
	@Column(name = "Category_Name")
	private String category_Name;

	@Column(name = "Category_Desc")
	private String category_Desc;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	public Integer getCat_ID() {
		return cat_ID;
	}

	public void setCat_ID(Integer cat_ID) {
		this.cat_ID = cat_ID;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public String getCategory_Desc() {
		return category_Desc;
	}

	public void setCategory_Desc(String category_Desc) {
		this.category_Desc = category_Desc;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
