package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.assertj.core.internal.cglib.core.DebuggingClassWriter;

import com.tl.mybatis.cglibproxy.ProxyFactory;
import com.tl.mybatis.cglibproxy.TargetC;
import sun.misc.ProxyGenerator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			TargetC target = new TargetC();
			ProxyFactory  proxy  = new ProxyFactory(target);
			
			target  = (TargetC) proxy.getProxy();
			target.insert();
			System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
			System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\class");  
			byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{TargetC.class});

			String filePath = System.getProperty("user.dir")+"/src/main/java/com/tl/mybatis/cglibproxy/$proxy.class";
	        try {
				FileOutputStream fos = new FileOutputStream(filePath);
				fos.write(bytes);
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	}

}
