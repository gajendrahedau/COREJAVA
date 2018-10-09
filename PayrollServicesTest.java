package com.cg.payroll.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class PayrollServicesTest {
	private static PayrollServices payrollServices;
	private static AssociateDAO mockAssociateDao;

	@BeforeClass
	public static void setUpTestEnv() {
		mockAssociateDao = EasyMock.mock(AssociateDAO.class);
		payrollServices = new PayrollServicesImpl(mockAssociateDao);
	}
	
	@Before
	public void setUpTestData() {	
		Associate associate1 = new Associate(1001, 78000, "Satish", "Mahajan", "Training", "Manager", "DTDYF736",
				"satish.mahajan@capgemini.com",new BankDetails(12345, "HDFC", "HDFC0097"), new Salary(35000, 1800, 1800)
				);
		
		Associate associate2 =new Associate(1002, 87372, "Ayush", "Mahajan", "Training", "Manager", "YCTCC727",
				"ayush.mahajan@capgemini.com", new BankDetails(12345, "HDFC", "HDFC0097"),new Salary(87738, 1800, 1800)
				);
		
		
		
		
		ArrayList<Associate> associatesList = new ArrayList<>();
		associatesList.add(associate1);
		associatesList.add(associate2);
		
		Associate associate3 =new Associate( 65440, "Mayur", "Patil", "ADC", "Trainee", "CYYJUUF887",
				"mayur.patil@capgemini.com",new BankDetails(123738, "HDFC", "HDFC0097"),new Salary(86222, 1800, 1800));
		
		EasyMock.expect(mockAssociateDao.findOne(1000)).andReturn(associate1);
		EasyMock.expect(mockAssociateDao.findOne(1001)).andReturn(associate2);
		EasyMock.expect(mockAssociateDao.findOne(1234)).andReturn(null);
		
		EasyMock.expect(mockAssociateDao.findAll()).andReturn(associatesList);
		
		
		EasyMock.expect(mockAssociateDao.save(associate3)).andReturn(associate3);
		
		
	}

	@Test(expected = AssociateDetailsNotFoundException.class)
	public void testGetAssociateDataForInvalidAssociateId()
			throws PayrollServicesDownException, AssociateDetailsNotFoundException {
		payrollServices.getAssociateDetails(1234);
		
		EasyMock.verify(mockAssociateDao.findOne(1234));
	}
	
	
	@Test
	public void testGetAssociateDataForValidAssociateId()
			throws PayrollServicesDownException, AssociateDetailsNotFoundException{
		Associate expectedAssociate = new Associate(1001, 78000, "Satish", "Mahajan", "Training", "Manager", "DTDYF736",
				"satish.mahajan@capgemini.com", new BankDetails(12345, "HDFC", "HDFC0097"),new Salary(35000, 1800, 1800));
		Associate actualAssociate = payrollServices.getAssociateDetails(1001);
		
		EasyMock.verify(mockAssociateDao.findOne(1001));
		assertEquals(expectedAssociate, actualAssociate);
	}

	@Test
	public void testAcceptAssociateDetailsForValidData() throws PayrollServicesDownException {
		int expectedAssociateId = 1003;
		int actualAssociateId = payrollServices.acceptAssociateDetails("NIlesh", "Patil", "nilesh.patil@capgemini.com",
				"ADM", "Manager", "ohhoh73763", 78999, 30000, 1800, 1800, 645454, "ICICI", "ICICI8437");
		assertEquals(expectedAssociateId, actualAssociateId);
	}

	@Test(expected = AssociateDetailsNotFoundException.class)
	public void testCalculateNetSalaryForInvalidAssociateId()
			throws PayrollServicesDownException, AssociateDetailsNotFoundException {
		payrollServices.getAssociateDetails(63363);
	}

	@Test
	public void testCalculateNetSalaryForValidAssociateId() {
		fail();
	}

	@Test
	public void testGetAllAssociatesDetails() throws PayrollServicesDownException {
		Associate associate1 = new Associate(1001, 78000, "Satish", "Mahajan", "Training", "Manager", "DTDYF736",
				"satish.mahajan@capgemini.com",new BankDetails(12345, "HDFC", "HDFC0097"), new Salary(35000, 1800, 1800)
				);
		Associate associate2 =new Associate(1002, 87372, "Ayush", "Mahajan", "Training", "Manager", "YCTCC727",
				"ayush.mahajan@capgemini.com", new BankDetails(12345, "HDFC", "HDFC0097"),new Salary(87738, 1800, 1800)
				);
		ArrayList<Associate> expectedAssociateList = new ArrayList<>();
		expectedAssociateList.add(associate1);
		expectedAssociateList.add(associate2);
		
		
		ArrayList<Associate> actualAssociateList = payrollServices.getAllAssociatesDetails();
		assertEquals(expectedAssociateList,actualAssociateList);
		
		
	}
	@After
	public void tearDownTestData() {
		
	}
	
	@AfterClass
	public static void tearDownTestEnv() {
		mockAssociateDao=null;
		payrollServices=null;
	}
}
