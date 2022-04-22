package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.repositary.BranchRepositary;

@Repository
public class BranchDao {

	@Autowired
	BranchRepositary repositary;

	@Autowired
	HospitalDao hospitalDao;

	public Branch saveBranch(int h_id, Branch branch) {
		Hospital hospital = hospitalDao.getHospitalById(h_id);
		if (hospital != null) {
			branch.setHospital(hospital);
			return repositary.save(branch);
		}
		return null;
	}

	public Branch getBranchById(int b_id) {
		Optional<Branch> opt = repositary.findById(b_id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	public Branch updateBranchById(int id,Branch branch) {
		Branch b = getBranchById(id);
		if(b!=null) {
			return repositary.save(branch);
		}
		return null;
	}
	
	public boolean deleteBranchById(int id) {
		Branch b = getBranchById(id);
		if(b!=null) {
			repositary.delete(b);
			return true;
		}
		return false;
	}
	public List<Branch> allBranchsByHospitalId(int h_id){
		return repositary.getAllBranchsByHospitalId(h_id);
	}

}
