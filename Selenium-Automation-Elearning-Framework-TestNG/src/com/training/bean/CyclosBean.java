package com.training.bean;

public class CyclosBean {
	private String userName;
	private String password;
	private String memberusrnm;
	private String amount;
	private String transaction;
	private String description;

	public CyclosBean() {
	}

	public CyclosBean(String userName, String password, String memberusrnm, String amount, String transaction, String description) {
		super();
		this.userName = userName;
		this.password = password;
		this.memberusrnm = memberusrnm;
		this.amount = amount;
		this.transaction = transaction;
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//memberusrnm
	public String getMemberUsername() {
		return memberusrnm;
	}

	public void setMemberUsername(String memberusrnm) {
		this.memberusrnm = memberusrnm;
	}
	//amount
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	//transaction
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	//description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CyclosBean [userName=" + userName + ", password=" + password + ", memberusrnm=" + memberusrnm + ", amount=" + amount + ", transaction=" + transaction + ", description=" + description + "]";
	}


}
