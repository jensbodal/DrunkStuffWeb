<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
            
            for (i=0; i < checkFields.length; i++) {
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
            <form name="Name Input Form" action="index.jsp" method="POST" onsubmit="return checkForm(this)">
                <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                Select Gender:
                            </td>
                            <td>
                                <select name="gender" id="gender" onchange="optionChange(this.form)">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                
                                <jsp:useBean id="WebTest" scope="session" class="drunkstuff.view.WebView" />
                                <jsp:setProperty name="WebTest" property="gender" />
                                <jsp:setProperty name="WebTest" property="age" />
                                <jsp:setProperty name="WebTest" property="weight" />
                                <jsp:setProperty name="WebTest" property="drinks" />
                                <jsp:setProperty name="WebTest" property="hours" />
                                <script type ="text/javascript">
                                    document.getElementById('gender').value = '<jsp:getProperty name="WebTest" property="gender" />';</script>
                                Your BAC is: <jsp:getProperty name="WebTest" property="BAC" />
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                Age:
                            </td>
                            <td>
                                <input type="text" name="age" id="age"/>
                                <input type="submit" value="OK" style="visibility: hidden;"/>
                                <script type ="text/javascript">
                                    document.getElementById('age').value = '<jsp:getProperty name="WebTest" property="age" />';</script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Weight:
                            </td>
                            <td>
                                <input type="text" name="weight" id="weight"/>
                                <input type="submit" value="OK" style="visibility: hidden;"/>
                                <script type ="text/javascript">
                                    document.getElementById('weight').value = '<jsp:getProperty name="WebTest" property="weight" />';</script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Number of Drinks:
                            </td>
                            <td>
                                <input type="text" name="drinks" id="drinks"/>
                                <input type="submit" value="OK" style="visibility: hidden;"/>
                                <script type ="text/javascript">
                                    document.getElementById('drinks').value = '<jsp:getProperty name="WebTest" property="drinks" />';</script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Hours since first drink:
                            </td>
                            <td>
                                <input type="text" name="hours" id="hours"/>
                                <input type="submit" value="OK" style="visibility: hidden;"/>
                                <script type ="text/javascript">
                                    document.getElementById('hours').value = '<jsp:getProperty name="WebTest" property="hours" />';
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
                            <jsp:getProperty name="WebTest" property="results" />
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
