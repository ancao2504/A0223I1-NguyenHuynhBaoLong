package manage.student.bean;

import java.util.Date;

public class Classroom {
    private int id;
    private String name;
    private Date start;
    private Boolean status;

    public Classroom(int id, String name, Date start, Boolean status) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.status = status;
    }

    public Classroom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
