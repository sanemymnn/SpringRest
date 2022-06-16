package springRest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplicationClass {

    public static void main(String[] args) {
        try{
            SpringApplication.run(MainApplicationClass.class, args);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
