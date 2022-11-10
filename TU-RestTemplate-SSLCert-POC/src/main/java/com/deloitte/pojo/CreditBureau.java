package com.deloitte.pojo;

public class CreditBureau {
	 private String xmlns;
	 Product ProductObject;
	 private String document;
	 TransactionControl TransactionControlObject;
	 private float version;
	 


	 // Getter Methods 

	 public String getXmlns() {
	  return xmlns;
	 }

	 public Product getProduct() {
	  return ProductObject;
	 }

	 public String getDocument() {
	  return document;
	 }

	 public TransactionControl getTransactionControl() {
	  return TransactionControlObject;
	 }

	 public float getVersion() {
	  return version;
	 }

	 // Setter Methods 

	 public void setXmlns(String xmlns) {
	  this.xmlns = xmlns;
	 }

	 public void setProduct(Product productObject) {
	  this.ProductObject = productObject;
	 }

	 public void setDocument(String document) {
	  this.document = document;
	 }

	

	 public void setTransactionControl(TransactionControl transactionControlObject) {
	  this.TransactionControlObject = transactionControlObject;
	 }

	 public void setVersion(float version) {
	  this.version = version;
	 }

	@Override
	public String toString() {
		return "CreditBureau [xmlns=" + xmlns + ", ProductObject=" + ProductObject + ", document=" + document
				+ ", TransactionControlObject=" + TransactionControlObject + ", version=" + version + "]";
	}
	}
