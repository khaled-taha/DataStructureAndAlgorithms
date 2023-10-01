package cloudNativeBaseCamp.sections.section_5;

class Student implements Comparable<Student> {
    Integer id;
    String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        int idComparison = id.compareTo(student.id);
        if (idComparison != 0) {
            return idComparison;
        }
        return Character.compare(name.charAt(0), student.name.charAt(0));
    }
}
