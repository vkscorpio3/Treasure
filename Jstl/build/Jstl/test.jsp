<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/x" prefix="x" %>
<html>
  <head>
    <title>For Each Examples</title>
  </head>

  <body>
    <c:import var="students" url="students.xml" />

    <x:parse var="doc" xml="${students}" />

    <table border="1">
      <tr>
        <th>First</th>

        <th>Last</th>

        <th>Points</th>

        <th>Letter</th>

        <th>Note</th>
      </tr>

      <x:forEach var="student" select="$doc/students/student">
        <tr>
          <td>
            <x:out select="name/first" />
          </td>

          <td>
            <x:out select="name/last" />
          </td>

          <td>
            <x:out select="grade/points" />
          </td>

          <td>
            <x:out select="grade/letter" />
          </td>

          <td>
            <x:choose>
              <x:when select="grade/points>90">You did
              great!</x:when>

              <x:when select="grade/points>80">You did
              good!</x:when>

              <x:when select="grade/points>75">You did
              ok.</x:when>

              <x:when select="grade/points>70">Well, you
              passed.</x:when>

              <x:otherwise>You failed</x:otherwise>
            </x:choose>
          </td>
        </tr>
      </x:forEach>
    </table>
  </body>
</html>

