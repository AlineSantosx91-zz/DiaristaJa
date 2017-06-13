package br.com.diaristaja.enumeration;

public enum RestricaoEnum {
	
	LAVAR_ROUPA("Lavar roupa"),
	PASSAR_ROUPA("Passar Roupa");
	
	private final String valor;
	
	private RestricaoEnum(String valor) {
		this.valor = valor;
	}
	
	
	public String getValor(){
		return this.valor;
	}
	
}
