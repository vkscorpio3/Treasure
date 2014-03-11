<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/x" prefix="x" %>
<html>
    <head>
        <title>Parse Examples</title>
    </head>

    <body>Please enter an XML file:
        <br />

        <form method="post">
            <textarea rows="10" cols="50" name="xml">
      <students>
        <student id="1">
          <name>
            <first>John</first>

            <last>Smith</last>

            <middle>T</middle>
          </name>

          <grade>
            <points>88</points>

            <letter>B</letter>
          </grade>
        </student>

        <student id="2">
          <name>
            <first>James</first>

            <last>Smith</last>

            <middle>K</middle>
          </name>

          <grade>
            <points>92</points>

            <letter>A</letter>
          </grade>
        </student>

        <student id="3">
          <name>
            <first>Kelly</first>

            <last>Lane</last>

            <middle>A</middle>
          </name>

          <grade>
            <points>72</points>

            <letter>C</letter>
          </grade>
        </student>
      </students>
            </textarea>

            <br />

            <input type="submit" />
        </form>

        <c:if test="${pageContext.request.method=='POST'}">

            <x:parse var="doc" xml="${param.xml}"/>

            <table border="1">
                <tr>
                    <td>$doc/students/student/name/first</td>

                    <td>
                        <x:out select="$doc/students/student/name/first" />
                    </td>
                </tr>

                <tr>
                    <td>$doc/students/student[@id=2]/name/first</td>

                    <td>
                        <x:out
                            select="$doc/students/student[@id=2]/name/first" />
                    </td>
                </tr>

                <tr>
                    <td>$doc/students/student[@id=1]/name/first</td>

                    <td>
                        <x:out
                            select="$doc/students/student[@id=3]/name/first" />
                    </td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
