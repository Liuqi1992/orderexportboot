package com.order.repository;

import com.order.pojo.AppCTradeEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Repository
@Table(name="app_c_Trade")
@Qualifier("tradeRepository")
public interface TradeRepository extends CrudRepository<AppCTradeEntity,Long>{
	public AppCTradeEntity findOne(Long id);

	@Query("select t from AppCTradeEntity t where t.relationId=:relationId and t.status=-2")
	public AppCTradeEntity findOneByRelationId(@Param("relationId") Long relationId);

	@Query("select t from AppCTradeEntity t where t.payTime>:taday")
	public List<AppCTradeEntity> listByTime(@Param("taday") Date taday);

	@Query("select t from AppCTradeEntity t where t.doctorId=:doctorId and t.status=:status")
	public List<AppCTradeEntity> listByDoctorId(@Param("doctorId") Long doctorId,@Param("status") String status);

	@Query("select t from AppCTradeEntity t where t.hospitalId=:hospitalId and t.status=:status")
	public List<AppCTradeEntity> listByHospitalId(@Param("hospitalId") Long hospitalId,@Param("status") String status);

	@Query("select t from AppCTradeEntity t where t.userId=:userId")
	public List<AppCTradeEntity> listByUserId(@Param("userId") Long userId);

	@Query("select t from AppCTradeEntity t where t.userId=:userId and status=:status")
	public List<AppCTradeEntity> listByUserIdAndStatus(@Param("userId") Long userId,@Param("status") String status);

	@Query("select t from AppCTradeEntity t ")
	public List<AppCTradeEntity> listAll();

	@Query("select t from AppCTradeEntity t where t.tradeNum=:tradeNum and t.status>=:status")
	public AppCTradeEntity getTradeByTradeNum(@Param("tradeNum") String tradeNum,@Param("status") String status);

	@Query("select t from AppCTradeEntity t where t.userId=:userId and t.needRead=:needRead order by id desc")
	List<AppCTradeEntity> listIfSelectReadService(@Param("userId") Long userId,@Param("needRead") Integer needRead);

	@Query("select t from AppCTradeEntity t where t.tradeNum = :tradeNum")
	AppCTradeEntity findByTradeNum(@Param("tradeNum") String tradeNum);

	@Query("select t from AppCTradeEntity t where t.tradeNum like :keyword and t.doctorId = :doctorId and t.status = :status")
	Page<AppCTradeEntity> findByDoctorIdAndStatus(Pageable pageable, @Param("keyword")String keyword, @Param("doctorId")Long doctorId, @Param("status")String status);

	@Query("select t from AppCTradeEntity t where t.userId = :userId and t.status >= :status and t.isFromShulan = :isFromShulan")
	List<AppCTradeEntity> findByUserIdAndStatus(@Param("userId")Long userId, @Param("status")String status, @Param("isFromShulan")String isFromShulan);
}
