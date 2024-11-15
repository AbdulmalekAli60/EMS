import { useEffect, useState } from "react";
// import { listEmployees } from "../services/EmployeeServices";
import { deleteEmployee } from "../services/EmployeeServices";
import { listEmployees } from "../services/EmployeeServices";
import { useNavigate, useParams } from "react-router-dom";
export default function ListEmployee() {
  const [employees, setEmployees] = useState([]);
  const { id } = useParams();

  const navigator = useNavigate();
  useEffect(() => {
    getAllEmplyees();
  }, []);

  // Event handlers
  function addNewEmployee() {
    navigator("/add-employee");
  }

  function getAllEmplyees() {
    listEmployees()
      .then((response) => {
        console.log("all data: =======>", response.data);
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function updateEmployee(id) {
    navigator(`/update-Employee/${id}`);
  }

  function removeEmployee(id) {
    deleteEmployee(id)
      .then((response) => {
        getAllEmplyees();
      })
      .catch((error) => {
        console.error(error);
      });
  }
  // Event handlers

  return (
    <div className="container mt-2">
      <h2 className="text-center">List of Employees </h2>
      <button className="btn btn-primary m-1" onClick={addNewEmployee}>
        Add Employee
      </button>
      <div style={{ overflowY: "scroll", height: "350px" }}>
        <table className="table table-striped table-bordered text-center">
          <thead>
            <tr>
              <th>Employee Id</th>
              <th>Employee First Name</th>
              <th>Employee Last Name</th>
              <th>Employee Email Id</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((d) => {
              return (
                <tr key={d.id}>
                  <td>{d.id}</td>
                  <td>{d.firstName}</td>
                  <td>{d.lastName}</td>
                  <td>{d.email}</td>
                  <td>
                    <button
                      className="btn btn-info"
                      onClick={() => updateEmployee(d.id)}
                    >
                      Update
                    </button>
                    <button
                      className="btn btn-danger m-sm-1"
                      onClick={() => removeEmployee(d.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}
