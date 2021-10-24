package com.springboot.bloggerapp.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private String roleName;
	private boolean onlyView;
	private boolean isInsert;
	private boolean isUpdate;
	private boolean isDelete;

	public UserRole(String roleName, boolean onlyView, boolean isInsert, boolean isUpdate, boolean isDelete) {
		super();
		this.roleName = roleName;
		this.onlyView = onlyView;
		this.isInsert = isInsert;
		this.isUpdate = isUpdate;
		this.isDelete = isDelete;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isOnlyView() {
		return onlyView;
	}

	public void setOnlyView(boolean onlyView) {
		this.onlyView = onlyView;
	}

	public boolean isInsert() {
		return isInsert;
	}

	public void setInsert(boolean isInsert) {
		this.isInsert = isInsert;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + ", onlyView=" + onlyView + ", isInsert="
				+ isInsert + ", isUpdate=" + isUpdate + ", isDelete=" + isDelete + "]";
	}

}
