<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Upload CSV File</h2>
    <form method="post" enctype="multipart/form-data" action="upload">
        <input type="file" name="file" accept=".csv"/>
        <button type="submit">Upload</button>
    </form>


</body>
</html>