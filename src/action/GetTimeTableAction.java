package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 42982 on 2016/11/13.
 */
public class GetTimeTableAction extends ActionSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
}
