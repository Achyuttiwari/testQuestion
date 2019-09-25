package testQuestion;

import java.util.Random;

public class User {
    private String name;
    private String companyName;
    private int age;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String createUserEmail() {
        return String.format("%s_%d%s.com", getName().toLowerCase(), getAge(), getCompanyName());
    }


    public String createUserpassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(genrateRandomcharacter());
        for (int i = 0; i < 4; i++) {
            sb.append(genrateRandomIntegerFromLimit(10));
        }
        sb.append(getFirst5CharacterfromUserName());
        sb.append(genrateRandomSpecialSymbol());
        return sb.toString();
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String companyName, int age) {
        this.name = name;
        this.companyName = companyName;
        this.age = age;
        this.email = createUserEmail();
        this.password = createUserpassword();

    }

    private String getFirst5CharacterfromUserName() {
        if (getName().length() < 5) {
            int difference = 5 - getName().length();
            StringBuilder tempName = new StringBuilder(getName());
            for (int i = 0; i < difference; i++) {
                tempName.append("0");
            }
            return tempName.toString();
        } else {
            return getName().substring(0, 5);
        }
    }

    private char genrateRandomSpecialSymbol() {
        char[] specialSymbols =
                {
                        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '[', ']', '|', '\\', ';', ';', '<', '>', ',', '.', '?', '\'', '\"', '/'
                };
        int randomInteger = genrateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }

    private char genrateRandomcharacter() {
        int randomNumberUpto26 = genrateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }

    public int genrateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }
}

class UserEntry {
    public static void main(String[] args) {
        User achyut = new User("achyut", "google", 2022);
        System.out.println(achyut.getEmail());
        System.out.println(achyut.getPassword());
    }

}
