/**
 * Represents a course with a name, description, and credits.
 */
class Course {
    private String name;
    private String description;
    private int credits;

    /**
     * Constructs a course with the specified name, description, and credits.
     *
     * @param name        the name of the course
     * @param description the description of the course
     * @param credits     the credits of the course
     */
    public Course(String name, String description, int credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    /**
     * Returns the name of the course.
     *
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the course.
     *
     * @return the description of the course
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the credits of the course.
     *
     * @return the credits of the course
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a string representation of the course
     */
    @Override
    public String toString() {
        return String.format("%s;%s;%d", name, description, credits);
    }

    /**
     * Creates a Course object from the specified string representation.
     *
     * @param line the string representation of the course
     * @return the Course object created from the string representation
     * @throws IllegalArgumentException if the string representation is invalid
     */
    public static Course fromString(String line) {
        String[] parts = line.split(";");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid course format");
        }
        return new Course(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
