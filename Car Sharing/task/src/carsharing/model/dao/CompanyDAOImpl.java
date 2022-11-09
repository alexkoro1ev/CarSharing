package carsharing.model.dao;

import carsharing.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

    List<Company> companies;

    public CompanyDAOImpl() {
        this.companies = new ArrayList<>();

    }

    @Override
    public List<Company> getAllCompanies() {
        return companies;
    }

    @Override
    public Company getCompany(int id) {
        return companies.get(id);
    }

    @Override
    public void updateCompany(Company company) {
        companies.get(company.getId()).setName(company.getName());
    }

    @Override
    public void deleteCompany(Company company) {
        companies.remove(company.getId());
    }

    @Override
    public void addCompany(Company company) {
        companies.add(company);
    }
}
