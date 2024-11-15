import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/department";

export const getAllDepartments = () => axios.get(REST_API_BASE_URL);

export const addDepartment = (departmentInfo) =>
  axios.post(REST_API_BASE_URL, departmentInfo);

export const getDepartmentById = (departmentId) =>
  axios.get(REST_API_BASE_URL + "/" + departmentId);

export const updateDepartment = (departmentId, departmentInfo) =>
  axios.put(REST_API_BASE_URL + "/" + departmentId, departmentInfo);

export const deleteDepaerment = (departmentId) => axios.delete(REST_API_BASE_URL + "/" + departmentId)
