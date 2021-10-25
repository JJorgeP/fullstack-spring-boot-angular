package com.jjp.money.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("money")
@Component
public class MoneyApiProperty {
	
	private String originPermitido = "http://localhost:8000";
	
	private final Seguranca seguranca = new Seguranca();
	
	public Seguranca getSeguranca() {
		return seguranca;
	}
	
	public String getOriginPermitido() {
		return originPermitido;
	}

	public void setOriginPermitido(String originPermitido) {
		this.originPermitido = originPermitido;
	}


	public static class Seguranca {

		private boolean enableHttps;
		
		public boolean isEnableHttps() {
			return enableHttps;
		}
		
		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
	}

}
