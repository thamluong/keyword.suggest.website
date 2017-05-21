<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Search keywords website</title>

<script type="text/javascript" charset="UTF-8"
	src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<link href="<c:url value="/resources/css/application.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/js/index.js" />"></script>
</head>
<body>
	<div class="div-header"></div>
	<div class="container">
		<div class="page-container">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<div id="custom-search-input">
						<div class="input-group col-md-12"
							style="display: inline-flex; padding-top: 20px;">
							<a class="header-logo-invertocat" href="https://github.com/"
								data-ga-click="Header, go to dashboard, icon:logo"> <img
								src="../search-keywords/resources/img/logo.png" alt="Logo"
								style="width: 40px;" />
							</a> <input type="text" class="  search-query form-control"
								placeholder="Search" style="border-bottom-left-radius: 20px;" />
							<span class="input-group-btn">
								<button class="btn btn-danger" type="button">
									<span class=" glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
					<span
						style="margin-left: 60px; font-family: monospace; font-size: 10px;">
						( Login to save your searched keywords )</span>
				</div>
			</div>

			<div class="result" style="width: 60%;float:left;">
				<table>
					<c:forEach begin="0" end="5" varStatus='status'>
						<tr style="line-height: 30px;">
							<td><span class="input-group-btn">
									<button class="btn btn-success" type="button"
										style="font-size: x-small; border-radius: 20px;">
										<span class=" glyphicon glyphicon-search"></span>
									</button>
							</span></td>
							<td><span style="display: list-items;">ORM,
									Hibernate, mapping ...</span></td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<div class="relate-page"
				style="border: 3px; float: right; border-style: inset;">
				<article style="text-align: center;">( Some trusted
					websites )</article>
				<ul>
					<li><a href="http://www.tutorialspoint.com/">tutorialpoints.com </a></li>
					<li><a href="http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html">hibernate.com </a></li>
					<li><a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/">spring.io </a></li>

					<li>.............</li>
				</ul>

			</div>

		</div>
	</div>




	<div class="div-footer"></div>
</body>
</html>
