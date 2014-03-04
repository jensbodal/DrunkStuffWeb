<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Am I Drunk?</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <script type="text/javascript">
        function checkForm(form) {
            var result = true;
            var numbers = /^[0-9|\.]+$/;
            var checkFields = new Array(
                    form.age,
                    form.weight,
                    form.drinks,
                    form.hours);

            for (i = 0; i < checkFields.length; i++) {
                if (!checkFields[i].value.match(numbers)) {
                    alert(checkFields[i].name + " field must be a number");
                    checkFields[i].focus();
                    result = false;
                    break;
                }
            }
            return result;
        }

        function optionChange(form) {

            if (checkForm(form)) {
                form.submit();
            }

        }
    </script>
    <body>
        <div>
            <h1>BAC Calculator</h1>
            <form name="Name Input Form" action="./FormValidation" method="GET" onsubmit="return checkForm(this)">
                <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                Select Gender:
                                <br />

                            </td>
                            <td>
                                <select name="gender" id="gender" onchange="optionChange(this.form)">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>


                                <jsp:useBean id="WebViewBean" scope="session" class="drunkstuff.view.WebView" />
                                <c:set var="gender" scope="session" value="${WebViewBean.gender}" />
                                <c:set var="age" scope="session" value="${WebViewBean.age}" />
                                <c:set var="weight" scope="session" value="${WebViewBean.weight}" />
                                <c:set var="drinks" scope="session" value="${WebViewBean.drinks}" />
                                <c:set var="hours" scope="session" value="${WebViewBean.hours}" />
                                <jsp:setProperty name="WebViewBean" property="gender" value="${gender}" />
                                <jsp:setProperty name="WebViewBean" property="age" value="${age}" />
                                <jsp:setProperty name="WebViewBean" property="weight" value="${weight}" />
                                <jsp:setProperty name="WebViewBean" property="drinks" value="${drinks}" />
                                <jsp:setProperty name="WebViewBean" property="hours" value="${hours}" />
                                <script type ="text/javascript">
                                    document.getElementById('gender').value = '<jsp:getProperty name="WebViewBean" property="gender" />';</script>
                                Your BAC is: <jsp:getProperty name="WebViewBean" property="BAC" />
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                Age:
                            </td>
                            <td>
                                <input type="text" name="age" id="age"/>
                                <script type ="text/javascript">
                                    document.getElementById('age').value = '<jsp:getProperty name="WebViewBean" property="age" />';</script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Weight:
                            </td>
                            <td>
                                <input type="text" name="weight" id="weight"/>
                                <script type ="text/javascript">
                                    document.getElementById('weight').value = '<jsp:getProperty name="WebViewBean" property="weight" />';
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Number of Drinks:
                            </td>
                            <td>
                                <input type="text" name="drinks" id="drinks"/>
                                <script type ="text/javascript">
                                    document.getElementById('drinks').value = '<jsp:getProperty name="WebViewBean" property="drinks" />';</script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Hours since first drink:
                            </td>
                            <td>
                                <input type="text" name="hours" id="hours"/>
                                <script type ="text/javascript">
                                    document.getElementById('hours').value = '<jsp:getProperty name="WebViewBean" property="hours" />';
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                    <center>
                        <input type="submit" value="Submit" />   
                    </center>
                    </td>
                    </tr>
                    <tr>
                        <td colSpan="3">
                    <center>
                        <h2>
                            <jsp:getProperty name="WebViewBean" property="results" />
                        </h2>
                    </center>
                    </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
