package com.asif.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.asif.configuration.BaseConfiguration;
import com.asif.configuration.PropertyConfig;
import com.asif.dao.StudentDao;
import com.asif.model.Enrollment;
import com.asif.model.Offer;
import com.asif.model.Student;
import com.asif.model.Term;
import com.asif.repositories.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.asif"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

//	@Autowired
//	private BaseConfiguration cp;
	
	@Autowired
	private ApplicationContext context;
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        //ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        Offer o = (Offer) context.getBean(Offer.class);
//        System.out.println(o.getStudent());
//        System.out.println(o.getCourse());
//        
//        Term t1 = (Term)context.getBean("term11");
//        System.out.println(t1);
        
//        Enrollment e = (Enrollment)context.getBean(Enrollment.class);
//        System.out.println(e);
        //PropertyConfig p = (PropertyConfig)context.getBean(PropertyConfig.class);
        //System.out.println(p.getOrg());
    }   
    
    //@Scheduled(fixedRate = 20000)
    public void reportCurrentTime() {      
    	BaseConfiguration cp = (BaseConfiguration)context.getBean(BaseConfiguration.class);
    	System.out.println(cp.getPropertyConfig().getOrg());
        System.out.println(cp.getDemographicConfig().getYearStart());
        System.out.println(cp.getUserConfig().getName());
        try {
			System.out.println(cp.getDataSource().getConnection().toString());
			StudentDao sd = context.getBean(StudentDao.class);
			for(Student student : sd.getStudents()) {
				System.out.println(student);
			}
			System.out.println("Student: " + sd.getStudent("0205031"));
			System.out.println("Student deleted: " + sd.deleteStudent("0205031"));
			System.out.println("Student added: " + sd.addStudent("0205031", "Asif Iqbal"));
//			System.out.println("Student added: " + sd.addStudent(new Student("0205033", "Hillol Debnnath")));
//			System.out.println("Student added: " + sd.addStudent(new Student("0205034", "Amatul Mohosina")));
//			for(Student student : sd.getStudents()) {
//				System.out.println(student);
//			}
//			System.out.println("Student updated: " + sd.updateStudent(new Student("0205033", "Hillol Debnathh")));
//			for(Student student : sd.getStudents()) {
//				System.out.println(student);
//			}
//			System.out.println("Student updated: " + sd.updateStudent(new Student("0205034", "Amatul Mohosinah")));
//			for(Student student : sd.getStudents()) {
//				System.out.println(student);
//			}
//			
//			List<Student> students = new ArrayList<Student>();
//			students.add(new Student("0205033", "Hillol Debnath"));
//			students.add(new Student("0205034", "Amatul Mohosina"));
//			sd.updateStudents(students);
			
			
			List<Student> students = new ArrayList<Student>();
			students.add(new Student("0205035", "Siam Abdullah"));
			students.add(new Student("0205036", "Tonmoy Majumdar"));
			sd.addStudents(students);
			
			for(Student student : sd.getStudents()) {
				System.out.println(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println();
        
    }
    
//    @Bean
//    public MappingJackson2HttpMessageConverter jsonConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(String.class, new StringSerializer());
//        ObjectMapper mapper = new ObjectMapper()
//            .registerModule(simpleModule);
//        converter.setObjectMapper(mapper);
//        return converter;
//    }

//    @Bean
//    public Jaxb2RootElementHttpMessageConverter jaxbConverter() {
//        return new Jaxb2RootElementHttpMessageConverter();
//    }
}