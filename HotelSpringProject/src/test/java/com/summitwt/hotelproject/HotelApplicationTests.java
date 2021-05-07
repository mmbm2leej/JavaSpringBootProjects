package com.summitwt.hotelproject;

import com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA.ConsoleColorSettings.*;

@SpringBootTest(classes = HotelApplication.class)
@RunWith(SpringRunner.class)
class HotelApplicationTests {

    @Autowired
    private HotelRepo HR;
    @Autowired
    private RoomRepo RR;

    @Test
    public void contextLoads() {};

    @Test
    public void createHotel() {
        String testname = "TEST NAME";
        String testloc = "TEST LOCATION";

        Hotel myHotel = new Hotel();
        myHotel.setName(testname);
        myHotel.setLocation(testloc);
        HR.save(myHotel);

    };




    //REPOs

//    @Autowired
//    private AdminRepo myAdminRepo;
//    @Autowired
//    private DoctorRepo myDoctorRepo;
//    @Autowired
//    private PatientRepo myPatientRepo;


//    @Test
//    public void contextLoads() {};
//
//    @Test
//    public void logIn() {
//        String usernameInput, passwordInput;
//        boolean successful = false;
//
//        while (!successful) {
//            Scanner myScanner = new Scanner(System.in);
//            System.out.println(CC_CYAN + "Enter Username: " + CC_GREEN);
//            usernameInput = myScanner.nextLine();
//            System.out.println(CC_CYAN + "Enter Password: " + CC_GREEN);
//            passwordInput = myScanner.nextLine();
//
//            successful = (myUserRepo.findByLogIn(usernameInput,passwordInput) != null) ? true : false;
//            if (!successful) System.out.println(CC_RED + "Login Failed.");
//
//        }
//        System.out.println(CC_GREEN + "Success!");
//    }
//
//    @Test
//    public void findbyid() {
//        Long testid = 3L;
//        myUserRepo.findByID(testid);
//    }
//
//    //ADMIN COMMANDS
//
//    @Test
//    public void createAccount() {
//        Users newUser = new Users();
//        newUser.setUsername("testUserName");
//        newUser.setPassword("testpass");
//        newUser.setFirstname("Joseph");
//        newUser.setLastname("Johnson");
//        myUserRepo.save(newUser);
//    }
//
//    @Test
//    public void createDoctor() {
//        Doctors newD0 = new Doctors();
//        newD0.setFirstname("fg43125432"); newD0.setUsername("7647");
//        newD0.setPassword("235324"); newD0.setLastname("435636");
//        newD0.setSpecialty("Cardiology");
//        myDoctorRepo.save(newD0);
//    }
//
//
//    @Test
//    public void saveEmp() {
//        Student s = new Student(
//                "Tom",
//                "Parsons",
//                "aageage@gmail.com",
//                25);
//        stuRepo.save(s);
//
//        Student t = new Student(
//                "Ally",
//                "Tomkins",
//                "afw3gt3t@gmail.com",
//                27);
//        stuRepo.save(t);
//
//        Student u = new Student(
//                "Stuart",
//                "Jones",
//                "avzvzxvxz@hotmail.com",
//                42);
//        stuRepo.save(u);
//
//        Student v = new Student(
//                "Bill",
//                "Stevens",
//                "fhgfhdethr@yahoo.com",
//                21);
//        stuRepo.save(v);
//
//        Student w = new Student(
//                "Tom",
//                "Parsons",
//                "ykyrj5yhsrgr@gmail.com",
//                55);
//        stuRepo.save(w);
//
//    }

}
