package kosa.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
//        xml 기반 
//		Resource resource = new ClassPathResource("applicationContext.xml");
//
//		BeanFactory factory = new GenericXmlApplicationContext(resource);

		// Java 기반
		ApplicationContext factory = new AnnotationConfigApplicationContext(Factory.class);

		Service service = (Service) factory.getBean("writeService2");
		service.insertService();

	}

}
