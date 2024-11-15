import { NavLink } from "react-router-dom";

export default function Header() {
  return (
    <div>
      <header>
        <nav className="navbar navbar-dark bg-dark navbar navbar-expand-lg ">
          <a className="navbar-brand m-lg-1" href="/employees">
            Our Companies's System
          </a>

          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item ">
                <NavLink className="nav-link" to="/employees" >Employees</NavLink>
              </li>

              <li className="nav-item ">
                <NavLink className="nav-link" to="/departments" >Departments</NavLink>
              </li>
            </ul>
          </div>
        </nav>
      </header>
    </div>
  );
}
