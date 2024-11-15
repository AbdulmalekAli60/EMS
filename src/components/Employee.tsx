import { useEffect, useState } from "react";
import { createEmployee } from "../services/EmployeeServices";
import { getEmployee } from "../services/EmployeeServices";
import { updateEmployee } from "../services/EmployeeServices";
import { useNavigate, useParams } from "react-router-dom";
import { getAllDepartments } from "../services/DepartmentsService";

// add employee
export default function Employee({ pageTitle }) {
  const navigator = useNavigate();
  const [employeeDetails, setEmployeeDetails] = useState({
    firstName: "",
    lastName: "",
    email: "",
    departmentId: "",
  });

  const [departments, setDepartments] = useState([]);

  const [errors, setErrors] = useState({
    firstName: "",
    lastName: "",
    email: "",
    department:""
  });

  useEffect(() => {
    getAllDepartments()
      .then((response) => {
        setDepartments(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const { id } = useParams();
  //Event Handlers
  function saveNewOrUpdateExistingEmployee(e) {
    e.preventDefault();

    if (validateForm()) {
      if (id) {
        updateEmployee(id, employeeDetails)
          .then((response) => {
            console.log("Update =======> ", response.data);
            navigator("/employees");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        createEmployee(employeeDetails)
          .then((response) => {
            console.log(response.data);
            navigator("/employees");
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  }

  useEffect(() => {
    // we get the emplyee id to use in the update service
    if (id) {
      getEmployee(id)
        .then((response) => {

          console.log("to update form ================>", response.data)
          setEmployeeDetails(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };

    if (employeeDetails.firstName.trim()) {
      errorsCopy.firstName = "";
    } else {
      errorsCopy.firstName = "First Name is Required";
      valid = false;
    }
    if (employeeDetails.lastName.trim()) {
      errorsCopy.lastName = "";
    } else {
      errorsCopy.lastName = "Last Name is Required";
      valid = false;
    }
    if (employeeDetails.email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email is Required";
      valid = false;
    }

    if(employeeDetails.departmentId){
      errorsCopy.department = "";
    }else{
      errorsCopy.department = "Select Department"
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }

  // function pageTitle() {
  //   if (id) {
  //     return "Update Employee";
  //   } else {
  //     return "Add Employee";
  //   }
  // }

  //Event Handlers

  return (
    <div className="container mt-4">
      <div className="row">
        <div className="card col-md-6 offset-md-3">
          <h2 className="text-center">{pageTitle}</h2>
          <div className="card-body">
            <form>
              {/* First name */}
              <div className="form-group mb-2">
                <label className="form-label">First Name</label>
                <input
                  className={`form-control ${
                    errors.firstName ? "is-invalid" : ""
                  }`}
                  type="text"
                  placeholder="Enter Employee First Name"
                  name="firstName"
                  value={employeeDetails.firstName}
                  onChange={(e) => {
                    setEmployeeDetails({
                      ...employeeDetails,
                      firstName: e.target.value,
                    });
                  }}
                />
                {errors.firstName && (
                  <div className="invalid-feedback">{errors.firstName}</div>
                )}
              </div>

              {/* Last name */}
              <div className="form-group mb-2">
                <label className="form-label">Last Name</label>
                <input
                  className={`form-control ${
                    errors.lastName ? "is-invalid" : ""
                  }`}
                  type="text"
                  placeholder="Enter Employee Last Name"
                  name="lastName"
                  value={employeeDetails.lastName}
                  onChange={(e) => {
                    setEmployeeDetails({
                      ...employeeDetails,
                      lastName: e.target.value,
                    });
                  }}
                />
                <div className="invalid-feedback">{errors.lastName}</div>
              </div>

              {/* Email */}
              <div className="form-group mb-2">
                <label className="form-label">Email</label>
                <input
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  type="email"
                  placeholder="Enter Employee Email"
                  name="email"
                  value={employeeDetails.email}
                  onChange={(e) => {
                    setEmployeeDetails({
                      ...employeeDetails,
                      email: e.target.value,
                    });
                  }}
                />
                <div className="invalid-feedback">{errors.email}</div>
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Select Department</label>
                <select
                 className={`form-control ${errors.department ? "is-invalid" : ""}`}
                  value={employeeDetails.departmentId}
                  onChange={(e) =>
                    setEmployeeDetails({
                      ...employeeDetails,
                      departmentId: e.target.value,
                    })
                  }
                >
                  {/* <option value="Select Department">Selecet Department</option> */}
                  {departments.map((dep) => {
                  return  <option value={dep.departmentId} key={dep.departmentId}>{dep.departmentName}</option>
                  })}
                </select>
                <div className="invalid-feedback">{errors.department}</div>
              </div>

              {/* buttons container */}
              <div
                style={{
                  display: "flex",
                  justifyContent: "center",
                  marginTop: "1rem",
                  gap: "1%",
                }}
              >
                <button
                  className="btn btn-danger"
                  onClick={(e) => {
                    e.preventDefault();
                    setEmployeeDetails({
                      ...employeeDetails,
                      email: "",
                      firstName: "",
                      lastName: "",
                    });
                  }}
                >
                  Clear
                </button>

                <button
                  className="btn btn-success"
                  onClick={saveNewOrUpdateExistingEmployee}
                >
                  Submit
                </button>
              </div>
              {/* ===buttons container=== */}
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
