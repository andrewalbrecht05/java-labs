import java.io.Serializable;

/**
 * Represents a student with a name and age.
 */
class Student implements Serializable {
    private String name;
    private int age;

    /**
     * Constructs a student with the specified name and age.
     *
     * @param name the name of the student
     * @param age  the age of the student
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the student.
     *
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the student.
     *
     * @return the age of the student
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return name + "," + age;
    }
}
