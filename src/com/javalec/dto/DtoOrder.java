package com.javalec.dto;

public class DtoOrder {

	// F
		int storeseq;
		String sname;
		String saddress;
		String stelno;
		String scrn;
		String sopendate;
		String sclosedate;
		int count;

		// C
		public DtoOrder() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		public DtoOrder(int storeseq, String sname) {
			super();
			this.storeseq = storeseq;
			this.sname = sname;
		}



		// M
		public int getStoreseq() {
			return storeseq;
		}

		public void setStoreseq(int storeseq) {
			storeseq = storeseq;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public String getSaddress() {
			return saddress;
		}

		public void setSaddress(String saddress) {
			this.saddress = saddress;
		}

		public String getStelno() {
			return stelno;
		}

		public void setStelno(String stelno) {
			this.stelno = stelno;
		}

		public String getScrn() {
			return scrn;
		}

		public void setScrn(String scrn) {
			this.scrn = scrn;
		}

		public String getSopendate() {
			return sopendate;
		}

		public void setSopendate(String sopendate) {
			this.sopendate = sopendate;
		}

		public String getSclosedate() {
			return sclosedate;
		}

		public void setSclosedate(String sclosedate) {
			this.sclosedate = sclosedate;
		}
		
		public int getCount() {
			return count;
		}
		
		public void setCount(int count) {
			this.count = count;
		}
		
		
		
		
}
