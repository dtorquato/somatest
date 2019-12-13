package com.douglastorquato.somaapp.enums;


public enum TypeEnum {

	WD("WDLAS", "Saque ATM"),
	PR("PR", "Pagamento de folha"),
	SL("SL", "Vendas TEF");
	
	private String code;
	private String description;
	
	public static final String TYPE_CODES = "WD|PR|SL";
	
	private TypeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static TypeEnum toEnum(String code) {
		if(code == null) return null;

		for(TypeEnum s : TypeEnum.values()) {
			if(s.getCode().equals(code)) return s;
		}

		return null;
	}

	
}
