package kr.kwangan2.tx.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TBL2Mapper {

	@Insert(" insert into tbl2(col2) values (#{data}) ")
	public int insertCol2(String data);

}
