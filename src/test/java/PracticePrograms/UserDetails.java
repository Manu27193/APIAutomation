package PracticePrograms;
    public class UserDetails {
        private String name;
        private String email;
        private int age;

        public UserDetails(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        @Override
        public String toString() {
            return "UserDetails{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

