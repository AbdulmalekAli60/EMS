// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import "./App.css";
import ListEmployee from "./components/ListEmployee";
import Header from "./components/Header";
import Footer from "./components/Footer";
import { Route, Routes } from "react-router-dom";
import Employee from "./components/Employee";
import ListDepartments from "./components/ListDepartments";
import Department from "./components/Department";
function App() {
  return (
    <div>
      <Header />

      <Footer />

      <Routes>
        {/* http://loclahost:5173 */}
        <Route path="/" element={<ListEmployee />} />
        {/* http://loclahost:3000/employees */}
        <Route path="/employees" element={<ListEmployee />} />
        {/* http://loclahost:3000/add-employee */}
        <Route
          path="/add-employee"
          element={<Employee pageTitle={"Add Employee"} />}
        />
        {/* http://loclahost:3000/update-Employee */}
        <Route
          path="/update-Employee/:id"
          element={<Employee pageTitle={"Edite Employee"} />}
        />{" "}
        {/* update employee based on id "path variable"*/}
        {/* http://loclahost:3000/departments */}
        <Route path="/departments" element={<ListDepartments />} /> 

        {/* http://loclahost:3000/add-department */}
        <Route path="/add-department" element={<Department pageTitle={"Add department"} />} />

        {/* http://loclahost:3000/update-department */}
        <Route path="/update-department/:departmentId" element={<Department pageTitle={"Update Department"} />} />
      </Routes>
    </div>
  );
}

export default App;
