package carsharing.model.dao;

import carsharing.model.Company;

import java.util.List;

public interface CompanyDAO {
    List<Company> getAllCompanies();
    Company getCompany(int id);
    void updateCompany(Company company);
    void deleteCompany(Company company);
    void addCompany(Company company);
}
