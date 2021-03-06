package ru.kpfu.itis.gafurova.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Specialty specialty;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int seniority;

    private int age;

    private String regalia;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegalia() {
        return regalia;
    }

    public void setRegalia(String regalia) {
        this.regalia = regalia;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return seniority == teacher.seniority &&
                age == teacher.age &&
                Objects.equals(id, teacher.id) &&
                Objects.equals(city, teacher.city) &&
                Objects.equals(studio, teacher.studio) &&
                Objects.equals(specialty, teacher.specialty) &&
                Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName) &&
                Objects.equals(regalia, teacher.regalia) &&
                Objects.equals(phoneNumber, teacher.phoneNumber) &&
                Objects.equals(schedules, teacher.schedules);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, city, studio, specialty, firstName, lastName, seniority, age, regalia, phoneNumber, schedules);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", city=" + city +
                ", studio=" + studio +
                ", specialty=" + specialty +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", seniority=" + seniority +
                ", age=" + age +
                ", regalia='" + regalia + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
