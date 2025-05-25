package modelo;

import java.util.List;

public class Company {
    private List<Department> departments;

    public Company(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    //Método para agregar un departamento
    public void addDepartment(Department department){
        departments.add(department);
    }

}
