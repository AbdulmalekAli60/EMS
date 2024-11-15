import { useEffect, useState } from "react";
import {
  addDepartment,
  getDepartmentById,
  updateDepartment,
} from "../services/DepartmentsService";
import { useNavigate, useParams } from "react-router-dom";
// add department
export default function Department({ pageTitle }) {
  const [departmentInfo, setDepartmentInfo] = useState({
    departmentNamee: "",
    departmentDescrepttion: "",
  });

  const { departmentId } = useParams();
  console.log("The id id=====>", departmentId);

  const navigator = useNavigate();

  // const [error,setError] = useState({
  //   departmentName: "",
  //   departmentDescrepttion: "",
  // })

  // Evenet handelrs

  useEffect(() => {
    getDepartmentById(departmentId)
      .then(({ data }) => {
        setDepartmentInfo({
          ...departmentInfo,
          departmentNamee: data.departmentName,
          departmentDescrepttion: data.departmentDescrepttion,
        });
      })
      .catch((error) => {
        console.error(error);
      });
  });

  function saveOrUpdateDepartment(e) {
    e.preventDefault();

    const updatedDepartmentInfo = {
      departmentName: departmentInfo.departmentNamee,
      departmentDescrepttion: departmentInfo.departmentDescrepttion,
    };

    if (departmentId) {
      updateDepartment(departmentId, updatedDepartmentInfo)
        .then((response) => {
          console.log(response.data);
          navigator("/departments");
        })
        .catch((error) => {
          console.error(error);
        });
    } else {
      addDepartment(departmentInfo)
        .then((response) => {
          console.log(response.data);
          navigator("/departments");
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }
  // Evenet handelrs
  return (
    <div className="container mt-4">
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center">{pageTitle}</h2>

          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                {/* department name */}
                <label className="form-label">Department Name</label>
                <input
                  className="form-control"
                  type="text"
                  name="deparmentName"
                  placeholder="Enter Department Name"
                  value={departmentInfo.departmentNamee}
                  onChange={(e) => {
                    setDepartmentInfo({
                      ...departmentInfo,
                      departmentNamee: e.target.value,
                    });
                  }}
                />
                {/* ===department name ==== */}

                <label className="form-label">Department Descreption</label>
                <input
                  className="form-control"
                  type="text"
                  name="deparmentDescreption"
                  placeholder="Enter Department Descreption"
                  value={departmentInfo.departmentDescrepttion}
                  onChange={(e) => {
                    setDepartmentInfo({
                      ...departmentInfo,
                      departmentDescrepttion: e.target.value,
                    });
                  }}
                />
              </div>

              {/* button containder */}
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
                    setDepartmentInfo({
                      ...departmentInfo,
                      departmentNamee: "",
                      departmentDescrepttion: "",
                      
                    });
                  }
                }
                >
                  Clear
                </button> 
                <button
                  className="btn btn-success"
                  onClick={(e) => saveOrUpdateDepartment(e)}
                >
                  Submit
                </button>
              </div>
              {/* button containder */}
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
