package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dto.Branch;

@Service
public class BranchService {

	@Autowired
	BranchDao dao;

	public Branch saveBranch(int h_id, Branch branch) {
		Branch b = dao.saveBranch(h_id, branch);
		if(b==null) {
			throw new NoFoundByIdException();
		}
		return b;
	}

	public Branch updateBranch(int b_id, Branch branch) {
		Branch b = dao.updateBranchById(b_id, branch);
		if (b == null) {
			throw new NoFoundByIdException();
		} else {
			return b;
		}
	}

	public Branch getBranchById(int b_id) {
		Branch branch = dao.getBranchById(b_id);
		if (branch == null) {
			throw new NoFoundByIdException();
		} else {
			return branch;
		}
	}

	public boolean deleteBranchById(int b_id) {
		return dao.deleteBranchById(b_id);
	}

	public List<Branch> allBranchsByHospitalId(int h_id) {
		List<Branch> branchs = dao.allBranchsByHospitalId(h_id);
		if (branchs == null) {
			throw new NoFoundByIdException("Given ID:"+h_id+" does not exsist");
		} else {
			return branchs;
		}
	}

}
