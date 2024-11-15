import { useEffect, useState } from "react";
import {
  getAllDepartments,
  deleteDepaerment,
} from "../services/DepartmentsService";
import { Link, useNavigate, useParams } from "react-router-dom";
export default function ListDepartments() {
  const [departments, setDepartments] = useState([]);
  const navigator = useNavigate();

  const { departmentId } = useParams();
  useEffect(() => {
    getAllDepartments()
      .then((response) => {
        console.log("============> all departments response", response.data);
        setDepartments(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  // Evenet handlers
  function updateDepartment(departmentId) {
    navigator(`/update-department/${departmentId}`);
  }

  function deleteDepartment(id) {
    deleteDepaerment(id)
      .then((response) => {
        console.log(response.data);
        // alert(response.data)
        getAllDepartments()
      })
      .catch((error) => {
        console.error(error);
      });
  }
  // Evenet Handlers

  return (
    <div className="container">
      <h2 className="text-center"> List Of departments</h2>
      <Link to="/add-department" className="btn btn-primary mb-2">
        Add Department
      </Link>
      <table className="table table-striped table-bordered text-center">
        <thead>
          <tr>
            <th>Department Id</th>
            <th>Department Name</th>
            <th>Department Descreption</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {departments.map((d) => {
            return (
              <tr key={d.id}>
                <td>{d.id}</td>
                <td>{d.departmentName}</td>
                <td>{d.departmentDescrepttion}</td>
                <td>
                  <button
                    className="btn btn-info"
                    onClick={() => updateDepartment(d.id)}
                  >
                    Update Department
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => deleteDepartment(d.id)}
                  >
                    Delete Department
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}
