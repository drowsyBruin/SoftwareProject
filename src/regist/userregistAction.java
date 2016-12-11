package regist;

import com.opensymphony.xwork2.Action;

public class userregistAction implements Action {

	private String userkind;

	public String getUserkind() {
		return userkind;
	}

	public void setUserkind(String userkind) {
		this.userkind = userkind;
	}
	@Override
	public String execute() throws Exception {
		System.out.print(userkind);
		if (userkind.equals("student")){
			return "student";
		}
		else if(userkind.equals("teacher")){
			return "teacher";
		}
		// TODO Auto-generated method stub
		else{ 
			System.out.print("a");
		  return "Faild";
		}
	}

}
