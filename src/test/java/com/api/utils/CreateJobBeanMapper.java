package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.Model.CreateJobPayload;
import com.Model.Customer;
import com.Model.CustomerAddress;
import com.Model.CustomerProduct;
import com.Model.Problems;
import com.dataProviders.api.bean.CreateJobBean;

public class CreateJobBeanMapper {

	// feed the bean and create the payload. This is utility class

	private CreateJobBeanMapper() {

	}

	public static void mapper(CreateJobBean bean) {
		// bean------>Create Job payload object

		int mstServiceLocationId = Integer.parseInt(bean.getMst_service_location_id());
		int mstPlatformId = Integer.parseInt(bean.getMst_platform_id());
		int mstWarrentyStatusId = Integer.parseInt(bean.getMst_warrenty_status_id());
		int mstOemId = Integer.parseInt(bean.getMst_oem_id());
		int productId=Integer.parseInt(bean.getCustomer_product_product_id());
		int modelId=Integer.parseInt(bean.getCustomer_product_mst_model_id());

		Customer customer = new Customer(bean.getCustomer_first_name(), bean.getCustomer_last_name(),
				bean.getCustomer_mobile_number(), bean.getCustomer_mobile_number_alt(), bean.getCustomer_email_id(),
				bean.getCustomer_email_id_alt());
		
		CustomerAddress customerAddress = new CustomerAddress(bean.getCustomer_address_flat_number(),
				bean.getCustomer_address_apartment_name(), bean.getCustomer_address_street_name(),
				bean.getCustomer_address_landmark(), bean.getCustomer_address_area(),
				bean.getCustomer_address_pincode(), bean.getCustomer_address_country(),
				bean.getCustomer_address_state());
		
		CustomerProduct customerProduct=new CustomerProduct(bean.getCustomer_product_dop(),
				bean.getCustomer_product_serial_number(),
				bean.getCustomer_product_imei1(),
				bean.getCustomer_product_imei2(),
				bean.getCustomer_product_popurl(), 
				productId, 
				modelId);

		
		List<Problems> problemList=new ArrayList<Problems>();
		
		int problemId=Integer.parseInt(bean.getProblems_0_id());
		Problems problems=new Problems(problemId, bean.getProblems_0_remark());
		
		

		CreateJobPayload payload = new CreateJobPayload(mstServiceLocationId, mstPlatformId, mstWarrentyStatusId,
				mstOemId, customer, customerAddress, customerProduct, problemList);
	}

}
