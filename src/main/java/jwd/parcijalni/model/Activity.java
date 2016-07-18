package jwd.parcijalni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_activity")
public class Activity {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="admin_comment")
	private String adminComment = "test";
	
	public Activity() {
		super();
	}
	
	public Activity(String name) {
		super();
		this.name = name;
	}

	public Activity(String name, String adminComment) {
		super();
		this.name = name;
		this.adminComment = adminComment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminComment() {
		return adminComment;
	}
	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}
	
	

}
