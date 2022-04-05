package com.order.repository;

import com.order.pojo.AppCApplicantEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="app_c_applicant")
@Qualifier("applicantRepository")
public interface ApplicantRepository extends CrudRepository<AppCApplicantEntity,Long>{
	public AppCApplicantEntity findOne(Long id);

	@Query("select t from AppCApplicantEntity t where t.status='0' and isDefalt=1 and t.userId=:userId")
	public AppCApplicantEntity findDefalt(@Param("userId") Long userId);

	@Query("select t from AppCApplicantEntity t where t.status='0' and t.userId=:userId")
	public List<AppCApplicantEntity> listAll(@Param("userId") Long userId);

	@Query("select t from AppCApplicantEntity t where t.status='0' and  t.id in(:Ids)")
	public List<AppCApplicantEntity> listByIds(@Param("Ids") List Ids);

	@Query("select t from AppCApplicantEntity t where t.status='0' and  t.applyName=:name and t.userId=:userId")
	public AppCApplicantEntity findByName(@Param("userId") Long userId,@Param("name") String name);

	@Query("select t from AppCApplicantEntity t where t.userId = :userId and t.sfzNum = :sfzNum")
	List<AppCApplicantEntity> findByUserIdAndSfzNum(@Param("userId")Long userId, @Param("sfzNum")String sfzNum);

	/*@Query("SELECT GROUP_CONCAT(t.name),SUM(t.num),t.createTime,a FROM AppCTradeEntity t,AppCApplicantEntity a where t.applicantId=a.id  GROUP BY t.applicantId ")*/
	//public List list();

}
