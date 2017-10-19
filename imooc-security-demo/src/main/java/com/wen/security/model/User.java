package com.wen.security.model;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.wen.security.validation.MyConstraint;
//jsonview   使用接口 申明视图
//get  使用视图

public class User {
	private int id;
	public interface UserSimpleView{};
	public interface UserDetailView extends UserSimpleView {};
	@MyConstraint(message="看见我了就代表成功了")
	private String username;
	@NotBlank(message="密码不能为空")
	private String password;
	private Date birthday;
	@JsonView(UserSimpleView.class)
	@Past(message="时间必须是过去的时间")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@JsonView(UserSimpleView.class)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	@JsonView(UserSimpleView.class)
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
