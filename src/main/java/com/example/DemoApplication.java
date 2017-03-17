package com.example;

//import com.example.Domain.Phones;
import com.example.Domain.User;
//import com.example.Repository.PhoneRepository;
import com.example.Repository.UserRepository;
import java.util.List;

import com.example.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Autowired
    MailService mailservice ;

//    @Autowired
//    PhoneRepository phoneRepository;

    @Autowired
    UserRepository userRepository;
            @Override
    public void run(String... strings) throws Exception {
//                System.out.println(userRepository.findOneByEmail("ass"));
//                User user=new User();
//                user.setEmail("ashrafatef@gmail.com");
//                user.setUsername("ashrafatef") ;
//                user.setPassword("123456");
//                user.setPhone(null);
//               userRepository.save(user);
 //               System.out.println("Inserted");
//        mailservice.Send("ashrafatef84@gmail.com","Hello Spring Boot","now we are testing the code",false);
//                System.out.println("Done");
//        User u=new User("ashraf","ashraf");
//        userRepository.save(u);
//        phoneRepository.save(new Phones("01120266849", u));
       //         System.out.println( userRepository.Login("ashrafatef", "123456").getEmail());  ;
   
//      List<User> users =  userRepository.findByUSerId(new Long(1));
//         for (int i=0 ; i<users.size() ; i++)
//         {
//             System.out.println(users.get(i).getEmail());
//         }
//                System.out.println("------------------------------------>"+userRepository.findOneByPhone("01285084404").getEmail() );
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:messages/messages");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }
}
