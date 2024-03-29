<%@page import="test.Animal"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animal Shelter Information</title>
</head>
<body>
    <h1>Animal Shelter Information</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Desertion No</th>
                <th>Filename</th>
                <th>Happen Date</th>
                <th>Happen Place</th>
                <th>Kind Code</th>
                <th>Color Code</th>
                <th>Age</th>
                <th>Weight</th>
                <th>Notice No</th>
                <th>Notice Start Date</th>
                <th>Notice End Date</th>
                <th>Popfile</th>
                <th>Process State</th>
                <th>Sex Code</th>
                <th>Neuter YN</th>
                <th>Special Mark</th>
                <th>Care Name</th>
                <th>Care Tel</th>
                <th>Care Addr</th>
                <th>Org Name</th>
                <th>Charge Name</th>
                <th>Office Tel</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Animal> animalList = (List<Animal>) request.getAttribute("animalList");
                if (animalList != null) {
                    for (Animal animal : animalList) {
            %>
            <tr>
                <td><%= animal.getDesertionNo() %></td>
                <td><%= animal.getFilename() %></td>
                <td><%= animal.getHappenDt() %></td>
                <td><%= animal.getHappenPlace() %></td>
                <td><%= animal.getKindCd() %></td>
                <td><%= animal.getColorCd() %></td>
                <td><%= animal.getAge() %></td>
                <td><%= animal.getWeight() %></td>
                <td><%= animal.getNoticeNo() %></td>
                <td><%= animal.getNoticeSdt() %></td>
                <td><%= animal.getNoticeEdt() %></td>
                <td><%= animal.getPopfile() %></td>
                <td><%= animal.getProcessState() %></td>
                <td><%= animal.getSexCd() %></td>
                <td><%= animal.getNeuterYn() %></td>
                <td><%= animal.getSpecialMark() %></td>
                <td><%= animal.getCareNm() %></td>
                <td><%= animal.getCareTel() %></td>
                <td><%= animal.getCareAddr() %></td>
                <td><%= animal.getOrgNm() %></td>
                <td><%= animal.getChargeNm() %></td>
                <td><%= animal.getOfficetel() %></td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
