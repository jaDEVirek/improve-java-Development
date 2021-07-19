package javaFeature16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SealedClassAndInterfaces {

    public static void main(String[] args) {

        List<UserService> provideUsers = new ArrayList<>();
        provideUsers.add(new UserService("Tom", "scrum master", "Business"));
        provideUsers.add(new UserService("Antony", "developer", "Programing"));
        provideUsers.add(new UserService("Wiktor", "tester", "Testing"));
        provideUsers.add(new UserService("Alice", "devloper", "Programing"));
        System.out.println("Show users hash no service : " + provideUsers.hashCode());

        Service serviceProvider = new AdminService("Admin", true, provideUsers);

        Class<?>[] permittedSubclasses = Service.class.getPermittedSubclasses();
        for (Class<?> t : permittedSubclasses) {
             System.out.println(t);
        }
//        switch ( serviceProvider ) {
//            case UserService us -> System.out.println(us.);
//                break;
//            case AdminService ad -> System.out.println(ad.);
//                break;
//            default ->
//                throw new IllegalStateException("Unexpected value");
//        }

    }
}


/**
 * Sealed interface
 */
sealed interface Service permits UserService, AdminService {

    String information = "This is static field information";

    String getServiceInformation();

    default String getUserServiceGlobalInformation() {
        return information;
    }

}

/**
 * Blocking inheritance
 */
final class UserService implements Service {

    String userName;
    String userRole;
    String serviceType;

    public UserService(String userName, String userRole, String serviceType) {
        this.userName = userName;
        this.userRole = userRole;
        this.serviceType = serviceType;
    }

    @Override
    public String getServiceInformation() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "UserService{" + "userName='" +
                userName +
                '\'' +
                ", userRole='" +
                userRole +
                '\'' +
                ", serviceType='" +
                serviceType +
                '\'' +
                '}';
    }
}

non-sealed class AdminService implements Service {
    String adminName;
    boolean isOnline;
    List<UserService> users;


    public AdminService(String adminName, boolean isOnline, List<UserService> users) {
        this.adminName = adminName;
        this.isOnline = isOnline;
        this.users = new ArrayList<>(users);
        System.out.println("Show users hash : " + users.hashCode());
        System.out.println("Show users hash : " + this.users.hashCode());
        System.out.println((users));
        System.out.println(this.users == users);
    }

    @Override
    public String getServiceInformation() {
        return this.toString();
    }

    @Override public String toString() {
        return "AdminService{" + "adminName='" +
                adminName +
                '\'' +
                ", isOnline=" +
                isOnline +
                ", users=" +
                Arrays.toString(users.toArray()) +
                '}';
    }
}

/**
 * We cant create other class that implements Service, no permission !
 */
//class OtherService implements  Service {
//
//    @Override public String getServiceInformation() {
//        return null;
//    }
//}
