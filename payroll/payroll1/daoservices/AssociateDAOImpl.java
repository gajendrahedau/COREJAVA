package com.cg.payroll.daoservices;
import com.cg.payroll.beans.Associate;
public class AssociateDAOImpl implements AssociateDAO {
	
	private static  Associate []  associates = new Associate[10];
	private static int ASSOCIATE_IDX=0;
	private static int ASSOCIATE_ID_COUNTER=101;
	
	@Override
	public Associate save(Associate associate) {
		associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associates[ASSOCIATE_IDX++]=associate;
		return associate;
	}
	@Override
	public Associate findOne(int associateId) {
		for(int i=0;i<associates.length;i++) 
			if(associates[i]!=null&& associateId==associates[i].getAssociateID())
				return associates[i];
		return null;
	}
	@Override
	public Associate[] findAll() {
		return associates;
	}

	

}
