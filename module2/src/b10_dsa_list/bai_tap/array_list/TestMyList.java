package b10_dsa_list.bai_tap.array_list;

public class TestMyList {
    public static class Student {
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        MyList<Student> listStudent = new MyList<>();
        Student st1 = new Student("Luan", 21);
        Student st2 = new Student("Khoa", 21);
        Student st3 = new Student("Xuyen", 21);

        listStudent.add(st1);
        listStudent.add(st2);
        listStudent.add(1, st3);

        for (int i = 0; i < listStudent.size() - 1; i++) {
            Student student = (Student) listStudent.elements[i];
            System.out.println(student.toString());
        }

        listStudent.remove(1);

        for (int i = 0; i < listStudent.size() - 1; i++) {
            Student student = (Student) listStudent.elements[i];
            System.out.println(student.toString());
        }

        System.out.println(listStudent.indexOf(st2));
    }
}
