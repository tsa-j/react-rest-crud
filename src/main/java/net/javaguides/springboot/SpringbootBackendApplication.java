package net.javaguides.springboot;

import net.javaguides.springboot.model.NewElement;
import net.javaguides.springboot.model.Phone;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.NewElementRepository;
import net.javaguides.springboot.repository.PhoneRepository;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private NewElementRepository newElementRepository;

    @Override
    public void run(String... args) throws Exception {

        this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com", Role.ADMIN, Role.USER));
        this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com", Role.ADMIN, Role.USER));
        this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com", Role.ADMIN, Role.USER));

        this.phoneRepository.save(new Phone(userRepository.getOne(1L), "111", "222"));
        this.phoneRepository.save(new Phone(userRepository.getOne(1L), "333", "444"));
        this.phoneRepository.save(new Phone(userRepository.getOne(1L), "555", "666"));
        this.phoneRepository.save(new Phone(userRepository.getOne(2L), "111", "222"));
        this.phoneRepository.save(new Phone(userRepository.getOne(2L), "33", "44"));
        this.userRepository.deleteById(3L);

        this.newElementRepository.save(new NewElement("test1","Summary Test 1","2001","us","1000","Desc 1"));
        this.newElementRepository.save(new NewElement("test2","Summary Test 2","2002","us","1000","Desc 1"));
        this.newElementRepository.save(new NewElement("test3","Summary Test 3","2003","us","1000","Desc 1"));
    }
}
//https://www.javaguides.net/2020/07/react-js-spring-boot-rest-api-example-tutorial.html

//http://localhost:8080/api/users

//// {link:1, name:"test1", summary:"Summary Test 1", year:"2001", country:"us", price:"1000", description:"Desc 1"},