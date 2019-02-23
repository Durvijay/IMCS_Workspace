<html>
<head>
<style>
/* search box*/
#search-form_3 {
	background: #e1e1e1; /* Fallback color for non-css3 browsers */
	width: 365px;
	margin: 100px auto;
	/* Gradients */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgb(243,
		243, 243)), color-stop(1, rgb(225, 225, 225)));
	background: -moz-linear-gradient(center top, rgb(243, 243, 243) 0%,
		rgb(225, 225, 225) 100%);
	/* Rounded Corners */
	border-radius: 17px;
	-webkit-border-radius: 17px;
	-moz-border-radius: 17px;
	/* Shadows */
	box-shadow: 1px 1px 2px rgba(0, 0, 0, .3), 0 0 2px rgba(0, 0, 0, .3);
	-webkit-box-shadow: 1px 1px 2px rgba(0, 0, 0, .3), 0 0 2px
		rgba(0, 0, 0, .3);
	-moz-box-shadow: 1px 1px 2px rgba(0, 0, 0, .3), 0 0 2px
		rgba(0, 0, 0, .3);
}

/*** TEXT BOX ***/
.search_3 {
	background: #fafafa; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0, rgb(250,
		250, 250)), color-stop(1, rgb(230, 230, 230)));
	background: -moz-linear-gradient(center top, rgb(250, 250, 250) 0%,
		rgb(230, 230, 230) 100%);
	border: 0;
	border-bottom: 1px solid #fff;
	border-right: 1px solid rgba(255, 255, 255, .8);
	font-size: 16px;
	margin: 4px;
	padding: 5px;
	width: 250px;
	/* Rounded Corners */
	border-radius: 17px;
	-webkit-border-radius: 17px;
	-moz-border-radius: 17px;
	/* Shadows */
	box-shadow: -1px -1px 2px rgba(0, 0, 0, .3), 0 0 1px rgba(0, 0, 0, .2);
	-webkit-box-shadow: -1px -1px 2px rgba(0, 0, 0, .3), 0 0 1px
		rgba(0, 0, 0, .2);
	-moz-box-shadow: -1px -1px 2px rgba(0, 0, 0, .3), 0 0 1px
		rgba(0, 0, 0, .2);
}

/*** USER IS FOCUSED ON TEXT BOX ***/
.search_3:focus {
	outline: none;
	background: #fff; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0, rgb(255,
		255, 255)), color-stop(1, rgb(235, 235, 235)));
	background: -moz-linear-gradient(center top, rgb(255, 255, 255) 0%,
		rgb(235, 235, 235) 100%);
}

/*** SEARCH BUTTON ***/
.submit_3 {
	background: #44921f; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgb(79,
		188, 32)), color-stop(0.15, rgb(73, 157, 34)),
		color-stop(0.88, rgb(62, 135, 28)), color-stop(1, rgb(49, 114, 21)));
	background: -moz-linear-gradient(center top, rgb(79, 188, 32) 0%,
		rgb(73, 157, 34) 15%, rgb(62, 135, 28) 88%, rgb(49, 114, 21) 100%);
	border: 0;
	color: #eee;
	cursor: pointer;
	float: right;
	font: 16px 'Raleway', sans-serif;
	font-weight: bold;
	height: 30px;
	margin: 4px 4px 0;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .3);
	width: 84px;
	outline: none;
	/* Rounded Corners */
	border-radius: 30px;
	-webkit-border-radius: 30px;
	-moz-border-radius: 30px;
	/* Shadows */
	box-shadow: -1px -1px 1px rgba(255, 255, 255, .5), 1px 1px 0
		rgba(0, 0, 0, .4);
	-moz-box-shadow: -1px -1px 1px rgba(255, 255, 255, .5), 1px 1px 0
		rgba(0, 0, 0, .2);
	-webkit-box-shadow: -1px -1px 1px rgba(255, 255, 255, .5), 1px 1px 0
		rgba(0, 0, 0, .4);
}
/*** SEARCH BUTTON HOVER ***/
.submit_3:hover {
	background: #4ea923; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgb(89,
		222, 27)), color-stop(0.15, rgb(83, 179, 38)),
		color-stop(0.8, rgb(66, 143, 27)), color-stop(1, rgb(54, 120, 22)));
	background: -moz-linear-gradient(center top, rgb(89, 222, 27) 0%,
		rgb(83, 179, 38) 15%, rgb(66, 143, 27) 80%, rgb(54, 120, 22) 100%);
}

.submit_3:active {
	background: #4ea923; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0, rgb(89,
		222, 27)), color-stop(0.15, rgb(83, 179, 38)),
		color-stop(0.8, rgb(66, 143, 27)), color-stop(1, rgb(54, 120, 22)));
	background: -moz-linear-gradient(center bottom, rgb(89, 222, 27) 0%,
		rgb(83, 179, 38) 15%, rgb(66, 143, 27) 80%, rgb(54, 120, 22) 100%);
}

/*** HOME BUTTON ***/
.submit_4 {
	background: #44921f; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgb(79,
		188, 32)), color-stop(0.15, rgb(73, 157, 34)),
		color-stop(0.88, rgb(62, 135, 28)), color-stop(1, rgb(49, 114, 21)));
	background: -moz-linear-gradient(center top, rgb(79, 188, 32) 0%,
		rgb(73, 157, 34) 15%, rgb(62, 135, 28) 88%, rgb(49, 114, 21) 100%);
	border: 0;
	color: #eee;
	cursor: pointer;
	float: right;
	font: 16px 'Raleway', sans-serif;
	font-weight: bold;
	height: 30px;
	margin: 4px 4px 0;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .3);
	width: 84px;
	outline: none;
	/* Rounded Corners */
	border-radius: 30px;
	-webkit-border-radius: 30px;
	-moz-border-radius: 30px;
	/* Shadows */
	box-shadow: -1px -1px 1px rgba(255, 255, 255, .5), 1px 1px 0
		rgba(0, 0, 0, .4);
	-moz-box-shadow: -1px -1px 1px rgba(255, 255, 255, .5), 1px 1px 0
		rgba(0, 0, 0, .2);
	-webkit-box-shadow: -1px -1px 1px rgba(255, 255, 255, .5), 1px 1px 0
		rgba(0, 0, 0, .4);
	position: absolute;
	top: 0;
	right: 0;
}
/*** SEARCH BUTTON HOVER ***/
.submit_4:hover {
	background: #4ea923; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, rgb(89,
		222, 27)), color-stop(0.15, rgb(83, 179, 38)),
		color-stop(0.8, rgb(66, 143, 27)), color-stop(1, rgb(54, 120, 22)));
	background: -moz-linear-gradient(center top, rgb(89, 222, 27) 0%,
		rgb(83, 179, 38) 15%, rgb(66, 143, 27) 80%, rgb(54, 120, 22) 100%);
}

.submit_4:active {
	background: #4ea923; /* Fallback color for non-css3 browsers */
	/* Gradients */
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0, rgb(89,
		222, 27)), color-stop(0.15, rgb(83, 179, 38)),
		color-stop(0.8, rgb(66, 143, 27)), color-stop(1, rgb(54, 120, 22)));
	background: -moz-linear-gradient(center bottom, rgb(89, 222, 27) 0%,
		rgb(83, 179, 38) 15%, rgb(66, 143, 27) 80%, rgb(54, 120, 22) 100%);
}
</style>
<title>Design search Button</title>
</head>
<body>
	<jsp:include page="views/Menu.jsp"></jsp:include> 
	<form id="search-form_3">
		<input type="text" class="search_3" /> <input type="submit"
			class="submit_3" value="Delete" />
	</form>
</body>
</html>