package com.howard.www.business.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.howard.www.business.controller.ObtainUnprocessedOrderController;
import com.howard.www.business.dao.ICustomerJurisdictionDao;
import com.howard.www.business.service.ICustomerJurisdictionService;
import com.howard.www.core.data.transfer.dto.IDataTransferObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @ClassName:  CustomerJurisdictionServiceImpl   
 * @Description:TODO 管辖客户管理
 * @author: mayijie
 * @date:   2017年5月4日 下午4:41:50   
 *     
 * @Copyright: 2017 https://github.com/majieHoward Inc. All rights reserved.
 */
@Repository("customerJurisdictionService")
public class CustomerJurisdictionServiceImpl implements ICustomerJurisdictionService {
	
	protected final Logger log = LoggerFactory.getLogger(ObtainUnprocessedOrderController.class);
	@Autowired
	private ApplicationContext cApplicationContext;
	
	private ICustomerJurisdictionDao obtainICustomerJurisdictionDao(String daoName)throws Exception{
		return (ICustomerJurisdictionDao) cApplicationContext.getBean(daoName);
	}
	/**
	 * 
	 * <p>Title: obtainCustomerInformation</p>   
	 * <p>Description: 获取管辖客户列表</p>   
	 * @param queryParameters
	 * @return
	 * @throws Exception   
	 * @see com.howard.www.business.service.ICustomerJurisdictionService#obtainCustomerInformation(com.howard.www.core.data.transfer.dto.IDataTransferObject)
	 */
	public JSONArray obtainCustomerInformation(IDataTransferObject queryParameters) throws Exception {
		if(queryParameters==null){
			throw new RuntimeException("系统内部处理错误");
		}
		List<JSONObject> customerInformationItems=obtainICustomerJurisdictionDao("customerJurisdictionDao").obtainCustomerInformation(queryParameters);
		if(customerInformationItems!=null&&customerInformationItems.size()>0){
			
		}
		return null;
	}

}
