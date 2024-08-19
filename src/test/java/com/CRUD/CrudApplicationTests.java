package com.CRUD;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;


class CrudApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testEncryption(){
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword("password");
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);

		String t = "root";
		System.out.println("hahahaah");
		System.out.println("Encypted value: "+encryptor.encrypt(t));

	}

}
