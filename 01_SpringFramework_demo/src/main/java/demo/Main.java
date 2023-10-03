package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
/* 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        // TIGHTLY COUPLED OVER A PARTICULAR CLASS 
        System.out.println("TIGHT COUPLING : ");
        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        Nurse nurse = (Nurse) context.getBean("nurse");     // another way of calling
        nurse.assist();

        // LOOSE COUPLING
        System.out.println("\nLOOSE COUPLING :");
        Staff staff1 = context.getBean(Doctor.class);
        staff1.assist();
        Staff staff2 = context.getBean(Nurse.class);
        staff2.assist();


        // SETTER INJECTION
        System.out.println("\nSETTER INJECTION : ");
        Doctor callBySetter = context.getBean(Doctor.class);
        callBySetter.assist();
        System.out.println(callBySetter.getQualification()); 

        // CONSTRUCTOR INJECTION
        System.out.println("\nCONSTRUCTOR INJECTION : ");
        Doctor callByConstructor = context.getBean(Doctor.class);
        callByConstructor .assist();
        System.out.println(callByConstructor.getQualification()); 

*/
        
        // JAVA BASED CONFIGURATION - JavaConfig, Nurse-@Component, spring.xml - <context:component-scan />
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Staff staff = context.getBean(Nurse.class);
        staff.assist();
    }
}
