package dao;

import entity.Branch;

import java.util.List;

public interface IBranchDAO {
     void save(Branch branch);
     Branch get(long branchId);
     List<Branch> get();
     /*void update(Branch branch);
     void delete(Branch branch);*/
}
