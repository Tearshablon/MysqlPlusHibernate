package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "COURSES")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME_COURSES")
    private String name_courses;

    @Column(name = "DESCRIPTION_COURCES")
    private String description_courses;

    @Column (name = "PRICE")
    private BigDecimal price;

    @ManyToMany(mappedBy = "coursesSet")
    Set<Students> studentsSet;

    @ManyToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "COURS_LECTUR",
            joinColumns = @JoinColumn(name = "COURSES_ID"),
            inverseJoinColumns = @JoinColumn(name = "LECTURES_ID")
    )
    Set<Lecturers> lecturersSet;

    public Courses() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_courses() {
        return name_courses;
    }

    public void setName_courses(String name_courses) {
        this.name_courses = name_courses;
    }

    public String getDescription_courses() {
        return description_courses;
    }

    public void setDescription_courses(String description_courses) {
        this.description_courses = description_courses;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name_courses='" + name_courses + '\'' +
                ", description_courses='" + description_courses + '\'' +
                ", price=" + price +
                '}';
    }
}
