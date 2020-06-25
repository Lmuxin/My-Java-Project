package muzi.muxin.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import muzi.muxin.pojo.Member;


@Repository
public interface MemberDao {
	
	@Select("select * from member where id = #{memberId}")
	public Member findById(int memberId);
	
}
