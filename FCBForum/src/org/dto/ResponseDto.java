package org.dto;

import java.util.List;

import org.dao.UserDao;
import org.dao.impl.UserDaoImpl;
import org.model.Response;
import org.model.User;

public class ResponseDto extends Response{
	
	private String gradeName;
	
	public void convert(Response res,ResponseDto dto){
		dto.setAuthor(res.getAuthor());
		dto.setContent(res.getContent());
		dto.setId(res.getId());
		dto.setSubmittime(res.getSubmittime());
		dto.setTitle(res.getTitle());
		dto.setTopicid(res.getTopicid());
		//ʵ����dao
		UserDao dao = new UserDaoImpl();
        User user = dao.getByName(res.getAuthor());
        //ͨ��Mapȡ���ȼ�����
        if(user!=null){
        	dto.setGradeName(GradeInstance.getInstance().getByKey(user.getGrade()));	
        }	
	}
	
	public void convert(List<Response> list,List<ResponseDto> dtolist){
		for(int i=0;i<list.size();i++){
			ResponseDto dto = new ResponseDto();
			this.convert(list.get(i), dto);
			dtolist.add(dto);
		}
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	

}
