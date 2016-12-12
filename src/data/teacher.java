package data;

/**
 * Created by Administrator on 2016/12/12.
 */
public class teacher {
    private String id;
    private String password;
    private String name;
    private String college;
    private String title;
    private String teachAge;
    private String resArea;
    private String resAchievement;
    private String date;
    private String contact;
    public String getId() {
        return id;
    }

    public String getContact(){
    	return contact;
    }
    
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getTitle() {
        return title;
    }

    public String getTeachAge() {
        return teachAge;
    }

    public String getResArea() {
        return resArea;
    }

    public String getResAchievement() {
        return resAchievement;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
    	this.contact = contact;
    }
    
    public void setCollege(String college) {
        this.college = college;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTeachAge(String teachAge) {
        this.teachAge = teachAge;
    }

    public void setResArea(String resArea) {
        this.resArea = resArea;
    }

    public void setResAchievement(String resAchievement) {
        this.resAchievement = resAchievement;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
