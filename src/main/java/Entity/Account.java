package Entity;

public class Account {
	 	private String accountID;
	    private String userName;
	    private String password;
	    private String role;
	    private String maNV;
		public String getAccountID() {
			return accountID;
		}
		public void setAccountID(String accountID) {
			this.accountID = accountID;
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

		public String getMaNV() {
			return maNV;
		}
		public void setMaNV(String maNV) {
			this.maNV = maNV;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Account(String accountID, String userName, String password, String role, String maNV) {
			super();
			this.accountID = accountID;
			this.userName = userName;
			this.password = password;
			this.maNV = maNV;
			this.role = role;
		}

	   
	    
}
